package use_case.login;

import entity.User;

public class LoginInteractor implements LoginInputBoundary {
     private final LoginUserDataAccessInterface loginUserDataAccessInterface;
     private final LoginOutputBoundary loginOutputBoundary;

     public LoginInteractor(LoginUserDataAccessInterface loginUserDataAccessInterface,
                            LoginOutputBoundary loginOutputBoundary) {
         this.loginUserDataAccessInterface = loginUserDataAccessInterface;
         this.loginOutputBoundary = loginOutputBoundary;
     }

     @Override
     public void execute(LoginInputData loginInputData) {
         String username = loginInputData.getUsername();
         String password = loginInputData.getPassword();
         if (!loginUserDataAccessInterface.existsByName(username)) {
             loginOutputBoundary.prepareFailView(username + ": Account does not exist.");
         } else {
             String pwd = loginUserDataAccessInterface.get(username).getPassword();
             if (!password.equals(pwd)) {
                 loginOutputBoundary.prepareFailView("Incorrect password for " + username + ".");
             } else {

                 User user = loginUserDataAccessInterface.get(loginInputData.getUsername());

                 LoginOutputData loginOutputData = new LoginOutputData(user.getName(), false);
                 loginPresenter.prepareSuccessView(loginOutputData);
             }
         }
     }
 }