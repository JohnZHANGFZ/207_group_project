package interface_adapter.input_ingredient;

import use_case.input_new_ingredient.InputIngredientInputBoundary;
import use_case.input_new_ingredient.InputIngredientInputData;

import java.util.List;

public class InputIngredientController {
    final InputIngredientInputBoundary inputIngredientUseCaseInteractor;

    public InputIngredientController(InputIngredientInputBoundary inputIngredientUseCaseInteractor) {
        this.inputIngredientUseCaseInteractor = inputIngredientUseCaseInteractor;
    }

    public void execute(List<String> ingredients) {
        InputIngredientInputData inputIngredientInputData = new InputIngredientInputData(ingredients);

        inputIngredientUseCaseInteractor.execute(inputIngredientInputData);
    }
}
