package use_case.collection.delete_item;

import entity.Ingredient;
import entity.IngredientFactory;

import java.util.ArrayList;
import java.util.List;

public class DeleteItemInteractor implements DeleteItemInputBoundary{

    final DeleteItemDataAccessInterface deleteItemDataAccessObject;

    final DeleteItemOutputBoundary deletePresenter;

    final IngredientFactory ingredientFactory;

    public DeleteItemInteractor(DeleteItemDataAccessInterface deleteItemDataAccessObject,
                                DeleteItemOutputBoundary deletePresenter,
                                IngredientFactory ingredientFactory) {
        this.deleteItemDataAccessObject = deleteItemDataAccessObject;
        this.deletePresenter = deletePresenter;
        this.ingredientFactory = ingredientFactory;
    }

//know when to have success view and fail view.
    @Override
    public void execute(DeleteItemInputData deleteItemInputData) {
        List<String> itemList = deleteItemInputData.getItems();
        List<String> deletedItemList = new ArrayList<>();
        if(itemList.isEmpty()) {
            deletePresenter.prepareFailView("No input. Try agian.");
        } else{
            for (String s : itemList) {
                if (deleteItemDataAccessObject.existByName(s)) {
                    Ingredient ingredient = ingredientFactory.create(s);
                    String deletedItem = deleteItemDataAccessObject.delete(ingredient);
                    deletedItemList.add(deletedItem);
                }
            }
            if (deletedItemList.isEmpty()) {
                deletePresenter.prepareFailView("Input does not exist. Check spelling");
            } else {
                DeleteItemOutputData deleteItemOutputData = new DeleteItemOutputData(deletedItemList);
                deletePresenter.prepareSuccessView(deleteItemOutputData);
            }
        }
    }
}
