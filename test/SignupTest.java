import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import org.junit.Test;
import use_case.edit_inventory.EditInventoryOutputBoundary;
import use_case.edit_restriction.EditRestrictionInputBoundary;
import use_case.edit_restriction.EditRestrictionInteractor;
import use_case.edit_restriction.EditRestrictionOutputBoundary;
import use_case.signup.*;

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

        SignupUserDataAccessInterface signupUserDataAccessInterface = mock(SignupUserDataAccessInterface.class);
        SignupOutputBoundary signupOutputBoundary = mock(SignupOutputBoundary.class);
        UserFactory userFactory = mock(UserFactory.class);
        SignupInputData signupInputData = new SignupInputData("ff", "fw", "f");
        signupInputData.getRepeatPassword();
        SignupInteractor signupInteractor = new SignupInteractor(signupUserDataAccessInterface, signupOutputBoundary, userFactory);
        signupInteractor.execute(signupInputData);
    }

    @Test
    public void editRestriction() {
        EditRestrictionOutputBoundary editRestrictionInputBoundary = mock(EditRestrictionOutputBoundary.class);
        EditRestrictionInteractor editRestrictionInteractor = new EditRestrictionInteractor(editRestrictionInputBoundary);
        editRestrictionInteractor.execute();

    }
    @Test
    public void controllerTest() {
        SignupInputBoundary signupInputBoundary = mock(SignupInputBoundary.class);
        SignupController signupController = new SignupController(signupInputBoundary);
        signupController.execute("qfq", "fqwq", "wf");
    }
}
