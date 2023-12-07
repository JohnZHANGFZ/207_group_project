import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import org.junit.Test;
import use_case.edit_inventory.EditInventoryInputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginOutputData;

import static org.mockito.Mockito.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class LoginTest {
    @Test
    public void presenterTest() {
        LoginState loginState = new LoginState();
        loginState.setUsernameError("bla");
        loginState.setUsername("ha");
        loginState.setPassword("what");
        loginState.setPasswordError("dad");
        loginState.getUsername();
        loginState.getPasswordError();
        loginState.getPassword();
        loginState.getUsernameError();
        LoginState loginState1 = new LoginState(loginState);

        LoginViewModel loginViewModel = new LoginViewModel("yss");
        loginViewModel.setState(loginState1);
        loginState.getUsernameError();
        loginViewModel.firePropertyChanged();
        loginViewModel.getState();
        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        loginViewModel.addPropertyChangeListener(propertyChangeListener);

        LoginPresenter loginPresenter = new LoginPresenter(new ViewManagerModel(), new LoggedInViewModel("ha"), loginViewModel);
        loginPresenter.prepareFailView("bla");
        LoginOutputData loginOutputData = new LoginOutputData("mike", false, "none", "none");
        loginPresenter.prepareSuccessView(loginOutputData);
    }

    @Test
    public void controllerTest() {
        LoginInputBoundary loginInputBoundary = mock(LoginInputBoundary.class);
        LoginController loginController = new LoginController(loginInputBoundary);
        loginController.execute("hla", "fhowhf");
    }
}
