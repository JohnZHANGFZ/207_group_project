package use_case.recipes_getter;

import java.util.ArrayList;

public class GetRecipeInteractor implements GetRecipeInputBoundary{

    final GetRecipeDataAccessInterface getRecipeDataAccessObject;
    final GetRecipeOutputBoundary getRecipeInputPresenter;

    public GetRecipeInteractor(GetRecipeDataAccessInterface getRecipeDataAccessObject, GetRecipeOutputBoundary getRecipeInputPresenter) {
        this.getRecipeDataAccessObject = getRecipeDataAccessObject;
        this.getRecipeInputPresenter = getRecipeInputPresenter;
    }
    @Override
    public void execute(GetRecipeInputData getRecipeInputData) {
        ArrayList<String> ingredients = getRecipeInputData.getIngredients();
        int number = getRecipeInputData.getNumber();
        if (!ingredients.isEmpty() && number > 0) {
            new GetRecipeOutputData(getRecipeDataAccessObject.getResults(ingredients, number));
        }
    }
}
