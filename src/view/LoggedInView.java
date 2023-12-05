package view;

import interface_adapter.inventory.InventoryController;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.logout.LogoutController;
import interface_adapter.restriction.RestrictionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;

    final JTextField ingredientsInputField = new JTextField(15);
    final JPasswordField numRecipesInputField = new JPasswordField(15);

    private final LogoutController logoutController;
    private final InventoryController inventoryController;
    private final RestrictionController restrictionController;

    JLabel username;

    final JButton logOut;
    final JButton inventory;
    final JButton restriction;
    final JButton getRecipeButton;

    //a window with title, 2 textboxes, 4 JButtons
    public LoggedInView(LoggedInViewModel loggedInViewModel, LogoutController logoutController,
                        InventoryController inventoryController, RestrictionController restrictionController) {
        this.logoutController = logoutController;
        this.inventoryController = inventoryController;
        this.restrictionController = restrictionController;
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Logged In");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcomeBack = new JLabel("Welcome!");
        username = new JLabel();

        LabelTextPanel ingredientsInfo = new LabelTextPanel(
                new JLabel("Ingredients:"), ingredientsInputField);
        ingredientsInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoggedInState currentState = loggedInViewModel.getState();
                currentState.setIngredients(ingredientsInputField.getText() + e.getKeyChar());
                loggedInViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        LabelTextPanel numRecipesInfo = new LabelTextPanel(
                new JLabel("Number of recipes: "), numRecipesInputField);
        numRecipesInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoggedInState currentState = loggedInViewModel.getState();
                currentState.setNumRecipes(ingredientsInputField.getText() + e.getKeyChar());
                loggedInViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JPanel getRecipe = new JPanel();
        getRecipeButton = new JButton(loggedInViewModel.RECIPEGETTER_BUTTON_LABLE);
        getRecipe.add(ingredientsInfo);
        getRecipe.add(numRecipesInfo);
        getRecipe.add(getRecipeButton);

        JPanel buttons = new JPanel();

        inventory = new JButton(loggedInViewModel.INVENTORY_BUTTON_LABEL);
        buttons.add(inventory);
        restriction = new JButton(loggedInViewModel.RESTRICTION_BUTTON_LABEL);
        buttons.add(restriction);
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

        restriction.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(restriction)) {
                            restrictionController.execute();
                        }
                    }
                }
        );

        getRecipeButton.addActionListener(this);

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
        this.add(getRecipe); // includes 2 input textboxes and getRecipeButton
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
