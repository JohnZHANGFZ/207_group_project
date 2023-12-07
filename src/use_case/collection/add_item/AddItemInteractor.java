package use_case.collection.add_item;

import entity.Ingredient;
import entity.IngredientFactory;

public class AddItemInteractor implements AddItemInputBoundary {

    final AddItemDataAccessInterface addItemDataAccessObject;

    final AddItemOutputBoundary addItemPresenter;

    final IngredientFactory ingredientFactory;

    public AddItemInteractor(AddItemDataAccessInterface addItemDataAccessObject,
                             AddItemOutputBoundary addItemPresenter,
                             IngredientFactory ingredientFactory) {
        this.addItemDataAccessObject = addItemDataAccessObject;
        this.addItemPresenter = addItemPresenter;
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void execute(AddItemInputData addItemInputData) {
        if(addItemInputData.getItems().isEmpty()) {
            addItemPresenter.prepareFailView("No input.");
        } else {
            for(int i = 0; i < addItemInputData.getItems().size();) {


                String item = addItemInputData.getItems().get(i);
                Ingredient ingredient = ingredientFactory.create(item);
                addItemDataAccessObject.add(ingredient);
            }
            addItemPresenter.prepareSuccessView();
        }
    }
}
