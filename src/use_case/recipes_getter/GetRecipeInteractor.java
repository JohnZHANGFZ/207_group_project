package use_case.recipes_getter;

import java.util.ArrayList;

public class GetRecipeInteractor implements GetRecipeInputBoundary{

    final GetRecipeDataAccessInterface getRecipeDataAccessObject;
    final GetRecipeOutputBoundary getRecipeInputPresenter;

    public GetRecipeInteractor(GetRecipeDataAccessInterface getRecipeDataAccessObject, GetRecipeOutputBoundary getRecipeInputPresenter) {
        this.getRecipeDataAccessObject = getRecipeDataAccessObject;
        this.getRecipeInputPresenter = getRecipeInputPresenter;
    }

    /* This method takes in an arraylist of ingredients and an integer of number of recipes to return and returns
    a success or fail view with the recipes it found by querying the API.
     */
    @Override
    public void execute(GetRecipeInputData getRecipeInputData) {
        ArrayList<String> ingredients = getRecipeInputData.getIngredients();
        int number = getRecipeInputData.getNumber();
        if (!ingredients.isEmpty() && number > 0 && number < 100) {
            GetRecipeOutputData recipes = new GetRecipeOutputData(getRecipeDataAccessObject.getResults(ingredients, number));
            getRecipeInputPresenter.prepareSuccessView(recipes);
        }
        else if (number < 0 | number > 100){
            getRecipeInputPresenter.prepareFailView("The accepted range for number recipes to return is 0-100");
        }
        else {
            getRecipeInputPresenter.prepareFailView("The ingredient list is empty");
        }
    }
}
