package use_case.add_inventory;

import entity.Ingredient;
import entity.IngredientFactory;

public class AddInventoryInteractor implements AddInventoryInputBoundary {

    final AddInventoryDataAccessInterface addItemDataAccessObject;

    final AddItemOutputBoundary addItemPresenter;

    final IngredientFactory ingredientFactory;

    public AddInventoryInteractor(AddInventoryDataAccessInterface addItemDataAccessObject,
                                  AddItemOutputBoundary addItemPresenter,
                                  IngredientFactory ingredientFactory) {
        this.addItemDataAccessObject = addItemDataAccessObject;
        this.addItemPresenter = addItemPresenter;
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void execute(AddInventoryInputData addInventoryInputData) {
        if(addInventoryInputData.getItems().isEmpty()) {
            addItemPresenter.prepareFailView("No input.");
        } else {
            for(int i = 0; i < addInventoryInputData.getItems().size();) {

                String item = addInventoryInputData.getItems().get(i);
                Ingredient ingredient = ingredientFactory.create(item);
                addItemDataAccessObject.save(ingredient);
            }
            addItemPresenter.prepareSuccessView();
        }
    }
}
