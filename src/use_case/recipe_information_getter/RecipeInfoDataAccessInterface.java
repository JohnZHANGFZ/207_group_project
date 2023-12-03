package use_case.recipe_information_getter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public interface RecipeInfoDataAccessInterface {
    JsonObject getRecipeInformation(JsonObject recipe);

    JsonObject getRecipeInformation(String id);
}
