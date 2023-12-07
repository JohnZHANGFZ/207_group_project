package use_case.remove_dietary_restriction;

import entity.Ingredient;
import entity.IngredientFactory;

import java.util.ArrayList;
import java.util.List;

public class RemoveRestrictionInteractor implements RemoveRestrictionInputBoundary{
    final RemoveRestrictionDataAccessInterface removeRestrictionDataAccessObject;

    final RemoveRestrictionOutputBoundary removeRestrictionPresenter;

    final IngredientFactory ingredientFactory;

    public RemoveRestrictionInteractor(RemoveRestrictionDataAccessInterface removeRestrictionDataAccessObject,
                                       RemoveRestrictionOutputBoundary removeRestrictionPresenter,
                                     IngredientFactory ingredientFactory) {
        this.removeRestrictionDataAccessObject = removeRestrictionDataAccessObject;
        this.removeRestrictionPresenter = removeRestrictionPresenter;
        this.ingredientFactory = ingredientFactory;
    }

    // This is about when to have success or fail views
    @Override
    public void execute(RemoveRestrictionInputData removeRestrictionInputData) {
        List<String> itemList = removeRestrictionInputData.getItems();
        List<String> removeRestrictionList = new ArrayList<>();
        List<String> itemDNE = new ArrayList<>();

        if(itemList.isEmpty()) {
            // If user does not type anything--> FailView: 'no input, try again'
            removeRestrictionPresenter.prepareFailView("No input. Try again.");
        } else{
            for (String s : itemList) {
                if (removeRestrictionDataAccessObject.restrictionExists(s)) {
                    Ingredient ingredient = ingredientFactory.create(s);
                    String deletedItem = removeRestrictionDataAccessObject.removeRestriction(ingredient);
                    removeRestrictionList.add(deletedItem);
                } else {
                    itemDNE.add(s);
                }
            }
            if (removeRestrictionList.isEmpty()) {
                // If none of user's input exists --> FailView: 'Input does not exist. Check spelling'
                removeRestrictionPresenter.prepareFailView("Input does not exist. Check spelling");

            } else {
                // If some or all user's input exists --> SuccessView: show the user what was just deleted
                // successfully and what was not
                RemoveRestrictionOutputData removeRestrictionoutputData =
                        new RemoveRestrictionOutputData(removeRestrictionList, itemDNE);
                removeRestrictionPresenter.prepareSuccessView(removeRestrictionoutputData);
            }
        }
    }
}
