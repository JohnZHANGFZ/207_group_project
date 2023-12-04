package view;

import interface_adapter.inventory.InventoryController;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logout.LogoutController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final LogoutController logoutController;
    private final InventoryController inventoryController;

    JLabel username;

    final JButton logOut;
    final JButton inventory;
    final JButton restriction;
    final JButton getRecipe;

    //a window with title and 4 JButtons
    public LoggedInView(LoggedInViewModel loggedInViewModel, LogoutController logoutController, InventoryController inventoryController) {
        this.logoutController = logoutController;
        this.inventoryController = inventoryController;
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Logged In");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcomeBack = new JLabel("Welcome!");
        username = new JLabel();

        JPanel buttons = new JPanel();

        inventory = new JButton(loggedInViewModel.INVENTORY_BUTTON_LABEL);
        buttons.add(inventory);
        restriction = new JButton(loggedInViewModel.RESTRICTION_BUTTON_LABEL);
        buttons.add(restriction);
        getRecipe = new JButton(loggedInViewModel.RECIPEGETTER_BUTTON_LABLE);
        buttons.add(getRecipe);
        logOut = new JButton(loggedInViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logOut);

        inventory.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(inventory)) {
                            inventoryController.execute();
                        }
                    }
                }
        );

        restriction.addActionListener(this);
        getRecipe.addActionListener(this);

        logOut.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logOut)) {
                            logoutController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(welcomeBack);
        this.add(username);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState state = (LoggedInState) evt.getNewValue();
        username.setText(state.getUsername());
    }
}
