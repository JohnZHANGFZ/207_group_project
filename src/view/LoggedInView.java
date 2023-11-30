package view;

import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


// TODO add inventory info to the view
public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Logged In";
    private final LoggedInViewModel loggedInViewModel;


    JLabel username;
    final JButton logOut;
    final JButton inventory;
    final JButton restriction;
    final JButton getRecipe;

    //a window with title and 4 JButtons
    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
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

        // TODO Add the body to the actionPerformed method of the action listener below
        //      for all buttons.
        inventory.addActionListener(this);
        restriction.addActionListener(this);
        getRecipe.addActionListener(this);
        logOut.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(buttons);

    }

    //React to a button click that results in e.

    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState state = (LoggedInState) evt.getNewValue();
        username.setText(state.getUsername());
    }
}