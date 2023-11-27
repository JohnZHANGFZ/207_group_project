package use_case.recipe_information_getter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class RecipeInfoOutputData {
    private final JsonObject recipe;

    public RecipeInfoOutputData(JsonObject recipe) {
        this.recipe = recipe;
    }

    public JsonObject ReturnRecipe() {
        return recipe;
    }
}
