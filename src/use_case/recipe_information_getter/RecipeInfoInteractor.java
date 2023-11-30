package use_case.recipe_information_getter;

import com.google.gson.JsonObject;

public class RecipeInfoInteractor implements RecipeInfoInputBoundary{
    final RecipeInfoDataAccessInterface recipeInfoDataAccessObject;
    final RecipeInfoOutputBoundary recipeInfoInputPresenter;

    public RecipeInfoInteractor(RecipeInfoDataAccessInterface recipeInfoDataAccessInterface, RecipeInfoOutputBoundary recipeInfoInputBoundary) {
        this.recipeInfoInputPresenter = recipeInfoInputBoundary;
        this.recipeInfoDataAccessObject = recipeInfoDataAccessInterface;
    }

    /* This method takes in a string id and returns
    a success or fail view with the recipe information it found by querying the API.
    */
    @Override
    public void execute(RecipeInfoInputData recipeInfoInputData) {
        try {
            String id = recipeInfoInputData.getId();
            Integer.parseInt(id);
            RecipeInfoOutputData recipe = new RecipeInfoOutputData(recipeInfoDataAccessObject.getRecipeInformation("id"));
            recipeInfoInputPresenter.prepareSuccessView(recipe);
        }
        catch (Exception e) {
            recipeInfoInputPresenter.prepareFailView("Invalid id");
        }
    }

}
