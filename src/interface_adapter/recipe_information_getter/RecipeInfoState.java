package interface_adapter.recipe_information_getter;

import com.google.gson.JsonObject;

public class RecipeInfoState {
    private String resultError = null;
    private JsonObject recipe;

    public RecipeInfoState(RecipeInfoState copy) {
        resultError = copy.resultError;
        recipe = copy.recipe;
    }

    public RecipeInfoState() {

    }

    public JsonObject getRecipe() {
        return recipe;
    }

    public void setRecipe(JsonObject recipe) {
        this.recipe = recipe;
    }

    public void setRecipeInfoError(String error) {
        this.resultError = error;
    }
}
