import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import org.junit.Test;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupOutputData;

import static org.mockito.Mockito.*;

import java.beans.PropertyChangeListener;

public class SignupTest {
    @Test
    public void presenterTest() {
        SignupState signupState = new SignupState();
        signupState.setRepeatPassword("fqfq");
        signupState.setUsername("qfq");
        signupState.setPassword("qfqwf");
        signupState.setUsernameError("qfqwfwq");
        signupState.setPasswordError("qwfqq");
        signupState.setRepeatPasswordError("qwfwqf");
        signupState.getUsername();
        signupState.getUsernameError();
        signupState.getPassword();
        signupState.getPasswordError();
        signupState.getRepeatPassword();
        signupState.getRepeatPasswordError();
        SignupState signupState1 = new SignupState(signupState);

        String hold = signupState1.toString();

        SignupViewModel signupViewModel = new SignupViewModel();
        signupViewModel.setState(signupState1);
        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        signupViewModel.addPropertyChangeListener(propertyChangeListener);
        signupViewModel.getState();
        signupViewModel.firePropertyChanged();

        SignupPresenter signupPresenter = new SignupPresenter(new ViewManagerModel(), signupViewModel, new LoginViewModel("fhqpf"));
        signupPresenter.prepareFailView("fqfqw");
        SignupOutputData signupOutputData = new SignupOutputData("qfqwfqw", false);
        signupPresenter.prepareSuccessView(signupOutputData);
    }

    @Test
    public void controllerTest() {
        SignupInputBoundary signupInputBoundary = mock(SignupInputBoundary.class);
        SignupController signupController = new SignupController(signupInputBoundary);
        signupController.execute("qfq", "fqwq", "wf");
    }
}
