package view;

import interface_adapter.inventory.InventoryState;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Logged In";
    private final LoggedInViewModel loggedInViewModel;
    private final InventoryViewModel inventoryViewModel;


    JLabel username;
    final JButton logOut;
    final JButton inventory;
    final JButton restriction;
    final JButton getRecipe;

    //a window with title and 4 JButtons
    public LoggedInView(LoggedInViewModel loggedInViewModel, InventoryViewModel inventoryViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.inventoryViewModel = inventoryViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Hello ");
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
                        if (e.getSource().equals(inventory)){
                            InventoryState currentState = inventoryViewModel.getState();
                        }
                    }
                }
        );
        restriction.addActionListener(this);
        getRecipe.addActionListener(this);
        logOut.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}