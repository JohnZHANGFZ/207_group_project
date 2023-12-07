package use_case.add_dietary_restriction;

import entity.Ingredient;
import entity.IngredientFactory;

public class AddRestrictionInteractor implements AddRestrictionInputBoundary{

    final AddRestrictionDataAccessInterface addRestrictionDataAccessObject;
    final AddRestrictionOutputBoundary addRestrictionPresenter;

    final IngredientFactory ingredientFactory;

    public AddRestrictionInteractor(AddRestrictionDataAccessInterface addRestrictionDataAccessInterface,
                                    AddRestrictionOutputBoundary addRestrictionOutputBoundary, IngredientFactory ingredientFactory){
        this.addRestrictionDataAccessObject = addRestrictionDataAccessInterface;
        this.addRestrictionPresenter = addRestrictionOutputBoundary;
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void execute(AddRestrictionInputData addRestrictionInputData) {
        if(addRestrictionInputData.getItems().isEmpty()) {
            addRestrictionPresenter.prepareFailView("No input.");
        } else {
            for(int i = 0; i < addRestrictionInputData.getItems().size();) {

                String item = addRestrictionInputData.getItems().get(i);
                Ingredient ingredient = ingredientFactory.create(item);
                addRestrictionDataAccessObject.addRestriction(ingredient);
            }
            addRestrictionPresenter.prepareSuccessView();
        }
    }
}