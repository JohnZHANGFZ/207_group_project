package use_case.input_new_ingredient;

import entity.Ingredient;
import entity.IngredientFactory;

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
        List<String> ingredientList = inputIngredientInputData.getIngredients();
        for (int i = 0; i < ingredientList.size();) {
            String item = ingredientList.get(i);

            if (ingredientDataAccessObject.existsByName(item)){
                ingredientPresenter.prepareFailView();
            } else if (item.isEmpty()) {
                ingredientPresenter.prepareFailView();
            } else {
                Ingredient ingredient = ingredientFactory.create(item);
                ingredientDataAccessObject.save(ingredient);
            }
        }
    }
}

