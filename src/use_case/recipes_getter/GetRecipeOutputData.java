package use_case.recipes_getter;
import com.google.gson.JsonArray;

public class GetRecipeOutputData {

    private final JsonArray recipes;

    public GetRecipeOutputData(JsonArray recipes) {
        this.recipes = recipes;
    }
}
