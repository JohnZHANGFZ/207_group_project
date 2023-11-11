package interface_adapter.input_ingredient;

import use_case.input_new_ingredient.InputIngredientOutputBoundary;

public class InputIngredientPresenter implements InputIngredientOutputBoundary {

    private final InputIngredientViewModel inputIngredientViewModel;

    public InputIngredientPresenter(InputIngredientViewModel inputIngredientViewModel) {
        this.inputIngredientViewModel = inputIngredientViewModel;
    }

    @Override
    public void prepareSuccessView() {
    }

    @Override
    public void prepareFailView(String error) {
        InputIngredientState inputIngredientState = inputIngredientViewModel.getState();
        inputIngredientState.setInputIngredientError(error);
        inputIngredientViewModel.firePropertyChanged();
    }
}
