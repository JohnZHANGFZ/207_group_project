package use_case.add_dietary_restriction;

import use_case.login.LoginOutputData;

public interface AddRestrictionOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
