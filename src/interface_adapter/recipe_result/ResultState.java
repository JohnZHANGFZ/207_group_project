package interface_adapter.recipe_result;

import com.google.gson.JsonArray;
import interface_adapter.recipes_getter.GetRecipesState;

public class ResultState {

    private String resultError = null;
    private JsonArray recipes;

    public ResultState(ResultState copy) {
        resultError = copy.resultError;
        recipes = copy.recipes;
    }

    public ResultState(){}

    public JsonArray getRecipes() {
        return recipes;
    }

    public void setRecipes(JsonArray recipes) {
        this.recipes = recipes;
    }

    public void setGetRecipeError(String resultError) {
        this.resultError = resultError;
    }
}
