package use_case.signup;

import entity.User;
import entity.UserFactory;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class SignupInteractor implements SignupInputBoundary{

    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.existByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("Username already taken.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match, please try again.");
        } else {

            try {
                User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword());
                userDataAccessObject.save(user);
                SignupOutputData signupOutputData = new SignupOutputData(user.getName(), false);
                userPresenter.prepareSuccessView(signupOutputData);
            } catch (FileNotFoundException e) {
                userPresenter.prepareFailView("File error, unable to save.");
            }
        }
    }
}
