package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_info_result.ResultInfoViewModel;
import interface_adapter.recipe_information_getter.RecipeInfoController;
import interface_adapter.recipe_information_getter.RecipeInfoPresenter;
import interface_adapter.recipe_information_getter.RecipeInfoViewModel;
import interface_adapter.recipes_getter.GetRecipesViewModel;
import search_recipe.QueryAPI;
import use_case.recipe_information_getter.RecipeInfoDataAccessInterface;
import use_case.recipe_information_getter.RecipeInfoInputBoundary;
import use_case.recipe_information_getter.RecipeInfoInteractor;
import use_case.recipe_information_getter.RecipeInfoOutputBoundary;
import view.ResultView;

import javax.swing.*;
import java.io.IOException;

public class ResultViewFactory {
    private ResultViewFactory() {}

    public static ResultView create(GetRecipesViewModel getRecipesViewModel,
                                    RecipeInfoViewModel recipeInfoViewModel,
                                    ResultInfoViewModel resultInfoViewModel,
                                    ViewManagerModel viewManagerModel) {
        try {
            RecipeInfoController recipeInfoController = createRecipeInfoUseCase(recipeInfoViewModel,
                    resultInfoViewModel, viewManagerModel);
            return new ResultView(getRecipesViewModel, recipeInfoViewModel, recipeInfoController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open APIKey file.");
        }
        return null;
    }

    private static RecipeInfoController createRecipeInfoUseCase(RecipeInfoViewModel recipeInfoViewModel,
                                                                ResultInfoViewModel resultInfoViewModel,
                                                                ViewManagerModel viewManagerModel) throws IOException {
        RecipeInfoOutputBoundary recipeInfoPresenter = new RecipeInfoPresenter(recipeInfoViewModel,
                resultInfoViewModel, viewManagerModel);
        RecipeInfoDataAccessInterface recipeInfoDataAccessInterface = new QueryAPI();
        RecipeInfoInputBoundary recipeInfoInteractor = new RecipeInfoInteractor(recipeInfoDataAccessInterface,
                recipeInfoPresenter);
        return new RecipeInfoController(recipeInfoInteractor);
    }
}
