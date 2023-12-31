package use_case.add_inventory;

import entity.Ingredient;
import entity.IngredientFactory;

public class AddInventoryInteractor implements AddInventoryInputBoundary {

    final AddInventoryDataAccessInterface addItemDataAccessObject;

    final AddInventoryOutputBoundary addItemPresenter;

    final IngredientFactory ingredientFactory;

    public AddInventoryInteractor(AddInventoryDataAccessInterface addItemDataAccessObject,
                                  AddInventoryOutputBoundary addItemPresenter,
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
                String user = addInventoryInputData.getUser();
                Ingredient ingredient = ingredientFactory.create(item);
                addItemDataAccessObject.addInventory(user, ingredient);
            }
            addItemPresenter.prepareSuccessView();
        }
    }
}
