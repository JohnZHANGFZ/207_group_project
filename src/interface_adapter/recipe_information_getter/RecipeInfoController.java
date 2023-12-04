package interface_adapter.recipe_information_getter;

import use_case.recipe_information_getter.RecipeInfoInputBoundary;
import use_case.recipe_information_getter.RecipeInfoInputData;

import java.util.ArrayList;

public class RecipeInfoController {
    final RecipeInfoInputBoundary recipeInfoInteractor;
    public RecipeInfoController(RecipeInfoInputBoundary recipeInfoInteractor) {
        this.recipeInfoInteractor = recipeInfoInteractor;
    }

    public void execute(String id) {
        RecipeInfoInputData recipeInfoInputData = new RecipeInfoInputData(id);

        recipeInfoInteractor.execute(recipeInfoInputData);
    }

}
