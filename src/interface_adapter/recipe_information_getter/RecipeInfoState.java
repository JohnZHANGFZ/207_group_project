package interface_adapter.recipe_information_getter;

import com.google.gson.JsonObject;
import interface_adapter.recipe_info_result.ResultInfoState;

public class RecipeInfoState {
    private String resultError = null;
    private JsonObject recipe;

    public RecipeInfoState(RecipeInfoState copy) {
        this.resultError = copy.resultError;
        this.recipe = copy.recipe;
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
