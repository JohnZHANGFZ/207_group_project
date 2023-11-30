package use_case.add_dietary_restriction;

import java.util.List;
import use_case.login.LoginOutputBoundary;

public class AddRestrictionInteractor implements AddRestrictionInputBoundary{

    final AddRestrictionUserDataAccessInterface addRestrictionDataAccessObject;
    final AddRestrictionOutputBoundary addRestrictionPresenter;

    public AddRestrictionInteractor(AddRestrictionUserDataAccessInterface addRestrictionDataAccessInterface,
                                AddRestrictionOutputBoundary addRestrictionOutputBoundary){
        this.addRestrictionDataAccessObject = addRestrictionDataAccessInterface;
        this.addRestrictionPresenter = addRestrictionOutputBoundary;
    }

    @Override
    public void execute(AddRestrictionInputData addRestrictionInputData) {
    }
}