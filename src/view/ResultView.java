package view;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import interface_adapter.recipe_information_getter.RecipeInfoController;
import interface_adapter.recipe_information_getter.RecipeInfoState;
import interface_adapter.recipe_information_getter.RecipeInfoViewModel;
import interface_adapter.recipes_getter.GetRecipesState;
import interface_adapter.recipes_getter.GetRecipesViewModel;
import interface_adapter.return_home.ReturnController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

public class ResultView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Result";
    private final JTextField idInputField = new JTextField(15);

    private final GetRecipesViewModel getRecipesViewModel;
    private final RecipeInfoViewModel recipeInfoViewModel;
    private final RecipeInfoController recipeInfoController;
    private final ReturnController returnController;

    JTable recipeResult;
    final JButton cancel;
    final JButton searchID;

    public ResultView(GetRecipesViewModel getRecipesViewModel,
                      RecipeInfoViewModel recipeInfoViewModel,
                      RecipeInfoController recipeInfoController,
                      ReturnController returnController) {
        this.getRecipesViewModel = getRecipesViewModel;
        this.recipeInfoViewModel = recipeInfoViewModel;
        this.recipeInfoController = recipeInfoController;
        this.returnController = returnController;


        JLabel viewTitle = new JLabel("Recipe Result");
        viewTitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        // display recipe as a table
        JsonArray recipes = getRecipesViewModel.getState().getRecipes();
        //TODO: please make sure it is not null when it been processed
        Vector<Vector<String>> dataVector = new Vector<>();
        if (recipes != null) {
            for (int i = 0; i < recipes.size(); i++) {
                JsonObject recipe = recipes.get(i).getAsJsonObject();

                String id = recipe.get("id").getAsString();
                String title = recipe.get("title").getAsString();
                String image = recipe.get("image").getAsString();

                Vector<String> row = new Vector<>();
                row.add(id);
                row.add(title);
                row.add(image);

                dataVector.add(row);
            }
        }

        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Title");
        columnNames.add("Image");

        DefaultTableModel model = new DefaultTableModel(dataVector, columnNames);
        JTable recipeResult = new JTable(model);


        //a typing box for user to type recipe id
        LabelTextPanel recipeIDInfo = new LabelTextPanel(
                new JLabel("Enter Recipe ID: "), idInputField);
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
                }
        );

        //buttons
        JPanel buttons = new JPanel();

        cancel = new JButton(GetRecipesViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        searchID = new JButton(GetRecipesViewModel.SEARCHID_BUTTON_LABEL);
        buttons.add(searchID);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(cancel)) {
                    returnController.execute();
                }
            }
        });

        searchID.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        RecipeInfoState currentState = recipeInfoViewModel.getState();

                        recipeInfoController.execute(currentState.getID());
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(viewTitle);
        this.add(recipeResult);
        this.add(recipeIDInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {System.out.println("Click " + e.getActionCommand()); }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        GetRecipesState state = (GetRecipesState) evt.getNewValue();
    }
}