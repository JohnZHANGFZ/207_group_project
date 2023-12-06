package view;

import interface_adapter.recipe_info_result.ResultInfoViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsView extends JPanel implements ActionListener{

    public final String viewName = "Details";
    public DetailsView(ResultInfoViewModel resultInfoViewModel) {

        JLabel title = new JLabel("Recipe Details Screen");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        // JLabel recipeName = new JLabel("Recipe Name: " + recipeInfoViewModel.getState().getName());
        // JLabel recipeIngredients = new JLabel("Recipe Ingredients: " + recipeInfoViewModel.getState().getIngredients());
        JLabel recipeInstructions = new JLabel("Recipe Instructions: " + resultInfoViewModel.getState().getRecipe());


        //add buttons
        JPanel buttons = new JPanel();

        JButton cancel = new JButton("Cancel");
        buttons.add(cancel);

        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //TODO
                    }
}
        );
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}