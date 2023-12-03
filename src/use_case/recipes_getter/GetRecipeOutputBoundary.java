package use_case.recipes_getter;

import com.google.gson.JsonArray;

public interface GetRecipeOutputBoundary {
    void prepareSuccessView(GetRecipeOutputData results);

    void prepareFailView(String error);
}
