package use_case.add_dietary_restriction;

import use_case.login.LoginOutputBoundary;

public class AddDietaryInteractor implements AddDietaryInputBoundary{

    final AddDietaryDataAccessInterface addDietaryDataAccessObject;
    final AddDietaryOutputBoundary addDietaryPresenter;

    public AddDietaryInteractor(AddDietaryDataAccessInterface addDietaryDataAccessInterface,
                                AddDietaryOutputBoundary addDietaryOutputBoundary){
        this.addDietaryDataAccessObject = addDietaryDataAccessInterface;
        this.addDietaryPresenter = addDietaryOutputBoundary;
    }

    @Override
    public void execute(AddDietaryInputData addDietaryInputData) {

    }
}
