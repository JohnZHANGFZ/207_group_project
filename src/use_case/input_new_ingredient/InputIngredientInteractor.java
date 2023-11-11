package use_case.input_new_ingredient;

public class InputIngredientInteractor implements InputIngredientInputBoundary{
    final InputIngredientDataAccessInterface ingredientDataAccessObject;

    final InputIngredientOutputBoundary ingredientPresenter;

    public InputIngredientInteractor(InputIngredientDataAccessInterface ingredientDataAccessObject,
                                     InputIngredientOutputBoundary ingredientPresenter) {
        this.ingredientDataAccessObject = ingredientDataAccessObject;
        this.ingredientPresenter = ingredientPresenter;
    }
}
