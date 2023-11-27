package interface_adapter.login;

import interface_adapter.ViewModel;
import view.LoginView;

import java.beans.PropertyChangeListener;

public class LoginViewModel extends ViewModel {

    public final String TITLE_LABEL = "Log In View";
    public final String USERNAME_LABEL = "Enter username";
    public final String PASSWORD_LABEL = "Enter password";
    public static final String LOGIN_BUTTON_LABEL = "Log in";
    public static final String CREATE_BUTTON_LABEL = "Create New Account";

    private LoginState state = new LoginState();


    public LoginViewModel(String viewName) {
        super(viewName);
    }
    public void setState(LoginState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public LoginState getState() { return state; }
}
