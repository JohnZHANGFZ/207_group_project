package interface_adapter.recipe_information_getter;

import com.google.gson.JsonObject;
import interface_adapter.recipe_info_result.ResultInfoState;

public class RecipeInfoState {
    private String resultError = null;
    private JsonObject recipe;
    private String id;

    public RecipeInfoState(RecipeInfoState copy) {
        resultError = copy.resultError;
        recipe = copy.recipe;
        id = copy.id;
    }

    public RecipeInfoState() {

    }

    public String getID(){return id; }

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
