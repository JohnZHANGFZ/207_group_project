package use_case.recipes_getter;
public interface GetRecipeOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
