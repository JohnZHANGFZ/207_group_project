package use_case.input_new_ingredient;

import entity.Ingredient;
import entity.IngredientFactory;

import java.util.ArrayList;
import java.util.List;

public class InputIngredientInteractor implements InputIngredientInputBoundary{
    final InputIngredientDataAccessInterface ingredientDataAccessObject;

    final InputIngredientOutputBoundary ingredientPresenter;

    final IngredientFactory ingredientFactory;

    public InputIngredientInteractor(InputIngredientDataAccessInterface ingredientDataAccessObject,
                                     InputIngredientOutputBoundary ingredientPresenter,
                                     IngredientFactory ingredientFactory) {
        this.ingredientDataAccessObject = ingredientDataAccessObject;
        this.ingredientPresenter = ingredientPresenter;
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void execute(InputIngredientInputData inputIngredientInputData) {

        if (inputIngredientInputData.getIngredients().isEmpty()) {
                ingredientPresenter.prepareFailView();
        } else {
            for(int i = 0; i < inputIngredientInputData.getIngredients().size();) {

                List<String> newIngredientList = new ArrayList<>();
                String item = inputIngredientInputData.getIngredients().get(i);
                Ingredient ingredient = ingredientFactory.create(item);
                ingredientDataAccessObject.save(ingredient);
            }
            ingredientPresenter.prepareSuccessView();
        }
    }
}

