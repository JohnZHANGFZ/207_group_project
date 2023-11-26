package use_case.recipes_getter;

import com.google.gson.JsonArray;

import java.util.ArrayList;

public interface GetRecipeDataAccessInterface {
    JsonArray getResults(ArrayList<String> ingredients, int number);
}
