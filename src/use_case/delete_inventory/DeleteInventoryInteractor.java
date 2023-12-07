package use_case.delete_inventory;

import entity.Ingredient;
import entity.IngredientFactory;

import java.util.ArrayList;
import java.util.List;

public class DeleteInventoryInteractor implements DeleteInventoryInputBoundary {

    final DeleteInventoryDataAccessInterface deleteItemDataAccessObject;

    final DeleteInventoryOutputBoundary deletePresenter;

    final IngredientFactory ingredientFactory;

    public DeleteInventoryInteractor(DeleteInventoryDataAccessInterface deleteItemDataAccessObject,
                                     DeleteInventoryOutputBoundary deletePresenter,
                                     IngredientFactory ingredientFactory) {
        this.deleteItemDataAccessObject = deleteItemDataAccessObject;
        this.deletePresenter = deletePresenter;
        this.ingredientFactory = ingredientFactory;
    }

    // This is about when to have success or fail views
    @Override
    public void execute(DeleteInventoryInputData deleteInventoryInputData) {
        ArrayList<String> itemList = deleteInventoryInputData.getItems();
        String user = deleteInventoryInputData.getUser();
        ArrayList<String> successDelete = new ArrayList<>();
        ArrayList<String> failedDelete = new ArrayList<>();

        if(itemList.isEmpty()) {
            // If user does not type anything--> FailView: 'no input, try again'
            deletePresenter.prepareFailView("No input. Try again.");
        } else {
            for (String s : itemList) {

                if (deleteItemDataAccessObject.inventoryExists(user, s)) {
                    Ingredient ingredient = ingredientFactory.create(s);
                    String deletedItem = deleteItemDataAccessObject.deleteInventory(user, ingredient);
                    successDelete.add(deletedItem);

                } else {
                    failedDelete.add(s);
                }
            }
            if (successDelete.isEmpty()) {
                // If none of user's input exists --> FailView: 'Input does not exist. Check spelling'
                deletePresenter.prepareFailView("Input does not exist. Check spelling");

            } else {
                // If some or all user's input exists --> SuccessView: show the user what was just deleted
                // successfully and what was not
                DeleteInventoryOutputData deleteInventoryOutputData = new DeleteInventoryOutputData(successDelete, failedDelete);
                deletePresenter.prepareSuccessView(deleteInventoryOutputData);
            }
        }
    }
}
