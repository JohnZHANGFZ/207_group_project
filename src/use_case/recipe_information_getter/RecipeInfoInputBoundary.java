package use_case.recipe_information_getter;

import com.google.gson.JsonObject;

public interface RecipeInfoInputBoundary {
    void execute(String id);
}
