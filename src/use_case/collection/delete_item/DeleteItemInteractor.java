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

    // This is about when to have success or fail views
    @Override
    public void execute(DeleteItemInputData deleteItemInputData) {
        List<String> itemList = deleteItemInputData.getItems();
        List<String> deletedItemList = new ArrayList<>();
        List<String> itemDNE = new ArrayList<>();

        if(itemList.isEmpty()) {
            // If user does not type anything--> FailView: 'no input, try again'
            deletePresenter.prepareFailView("No input. Try again.");
        } else{
            for (String s : itemList) {
                if (deleteItemDataAccessObject.existByName(s)) {
                    Ingredient ingredient = ingredientFactory.create(s);
                    String deletedItem = deleteItemDataAccessObject.delete(ingredient);
                    deletedItemList.add(deletedItem);
                } else {
                    itemDNE.add(s);
                }
            }
            if (deletedItemList.isEmpty()) {
                // If none of user's input exists --> FailView: 'Input does not exist. Check spelling'
                deletePresenter.prepareFailView("Input does not exist. Check spelling");

            } else {
                // If some or all user's input exists --> SuccessView: show the user what was just deleted
                // successfully and what was not
                List<List<String>> outputData = new ArrayList<>();
                outputData.add(deletedItemList);
                outputData.add(itemDNE);

                DeleteItemOutputData deleteItemOutputData = new DeleteItemOutputData(outputData);
                deletePresenter.prepareSuccessView(deleteItemOutputData);
            }
        }
    }
}
