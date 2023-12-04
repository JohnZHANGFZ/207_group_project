package interface_adapter.recipes_getter;

import com.google.gson.JsonArray;

public class GetRecipesState {

    private String getRecipeError = null;
    private JsonArray recipes;

    public GetRecipesState(GetRecipesState copy) {
        getRecipeError = copy.getRecipeError;
        recipes = copy.recipes;
    }

    public GetRecipesState(){}

    public JsonArray getRecipes() {
        return recipes;
    }

    public void setRecipes(JsonArray recipes) {
        this.recipes = recipes;
    }

    public void setGetRecipeError(String getRecipeError) {
        this.getRecipeError = getRecipeError;
    }
}
