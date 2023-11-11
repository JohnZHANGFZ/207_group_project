package use_case.input_new_ingredient;

public interface InputIngredientOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
}
