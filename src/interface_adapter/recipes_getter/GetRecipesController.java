package interface_adapter.recipes_getter;
import use_case.recipes_getter.GetRecipeInputBoundary;
import use_case.recipes_getter.GetRecipeInputData;

import java.util.ArrayList;

public class GetRecipesController {
    final GetRecipeInputBoundary getRecipeUseCaseInteractor;

    public GetRecipesController(GetRecipeInputBoundary getRecipeUseCaseInteractor) {
        this.getRecipeUseCaseInteractor = getRecipeUseCaseInteractor;
    }

    public void execute(ArrayList<String> ingredients, int number) {
        GetRecipeInputData recipeInputData = new GetRecipeInputData(ingredients, number);
        
        getRecipeUseCaseInteractor.execute(recipeInputData);
    }
}
