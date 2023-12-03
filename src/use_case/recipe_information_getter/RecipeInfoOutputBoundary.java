package use_case.recipe_information_getter;

public interface RecipeInfoOutputBoundary {
    void prepareSuccessView(RecipeInfoOutputData recipe);

    void prepareFailView(String error);
}
