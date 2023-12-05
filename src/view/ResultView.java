package view;

import interface_adapter.recipe_information_getter.RecipeInfoController;
import interface_adapter.recipe_information_getter.RecipeInfoState;
import interface_adapter.recipe_information_getter.RecipeInfoViewModel;
import interface_adapter.recipes_getter.GetRecipesState;
import interface_adapter.recipes_getter.GetRecipesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ResultView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Result";
    private final JTextField idInputField = new JTextField(15);

    private final GetRecipesViewModel getRecipesViewModel;
    private final RecipeInfoViewModel recipeInfoViewModel;
    private final RecipeInfoController recipeInfoController;
    final JButton cancel;
    final JButton searchID;

    public ResultView(GetRecipesViewModel getRecipesViewModel,
                      RecipeInfoViewModel recipeInfoViewModel,
                      RecipeInfoController recipeInfoController) {
        this.getRecipesViewModel = getRecipesViewModel;
        this.recipeInfoViewModel = recipeInfoViewModel;
        this.recipeInfoController = recipeInfoController;


        JLabel title = new JLabel("Recipe Result Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Enter Recipe ID: "), idInputField);

        //add buttons
        JPanel buttons = new JPanel();

        cancel = new JButton(GetRecipesViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        searchID = new JButton(GetRecipesViewModel.SEARCHID_BUTTON_LABEL);
        buttons.add(searchID);

        searchID.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        RecipeInfoState currentState = recipeInfoViewModel.getState();

                        recipeInfoController.execute(currentState.getID());
                    }
                }
        );

        idInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                GetRecipesState currentState = getRecipesViewModel.getState();
                currentState.setRecipes(currentState.getRecipes());
                getRecipesViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {System.out.println("Click " + e.getActionCommand()); }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}