package interface_adapter.delete_account;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.LoginState;
import use_case.delete_account.DeleteAccountOutputBoundary;

public class DeleteAccountPresenter implements DeleteAccountOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteAccountPresenter(ViewManagerModel viewManagerModel,
                                  LoggedInViewModel loggedInViewModel,
                                  LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView() {
        this.viewManagerModel.setActiveView(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailureView(String error) {
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setDeleteAccountError(error);
        loggedInViewModel.firePropertyChanged();
    }
}
