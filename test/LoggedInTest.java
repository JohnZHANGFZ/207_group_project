import static org.mockito.Mockito.*;

import entity.CommonUser;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import org.junit.Test;
import use_case.login.*;

import java.beans.PropertyChangeListener;

public class LoggedInTest {
    @Test
    public void testSuccessfulLogin() {
        LoginUserDataAccessInterface userDataAccess = mock(LoginUserDataAccessInterface.class);
        LoginOutputBoundary outputBoundary = mock(LoginOutputBoundary.class);
        when(userDataAccess.existsByName("validUser")).thenReturn(true);
        when(userDataAccess.getUser("validUser")).thenReturn(new CommonUser("validUser", "password123"));

        LoginInteractor loginInteractor = new LoginInteractor(userDataAccess, outputBoundary);
        loginInteractor.execute(new LoginInputData("validUser", "password123"));

        verify(outputBoundary).prepareSuccessView(any(LoginOutputData.class));
    }

    @Test
    public void testLoginWithWrongPassword() {
        LoginUserDataAccessInterface userDataAccess = mock(LoginUserDataAccessInterface.class);
        LoginOutputBoundary outputBoundary = mock(LoginOutputBoundary.class);
        when(userDataAccess.existsByName("validUser")).thenReturn(true);
        when(userDataAccess.getUser("validUser")).thenReturn(new CommonUser("validUser", "password123"));

        LoginInteractor loginInteractor = new LoginInteractor(userDataAccess, outputBoundary);
        loginInteractor.execute(new LoginInputData("validUser", "wrongPassword"));

        verify(outputBoundary).prepareFailView(contains("Incorrect password"));
    }

    @Test
    public void testLoginWithNonExistentUser() {
        LoginUserDataAccessInterface userDataAccess = mock(LoginUserDataAccessInterface.class);
        LoginOutputBoundary outputBoundary = mock(LoginOutputBoundary.class);
        when(userDataAccess.existsByName("nonExistentUser")).thenReturn(false);

        LoginInteractor loginInteractor = new LoginInteractor(userDataAccess, outputBoundary);
        loginInteractor.execute(new LoginInputData("nonExistentUser", "password123"));

        verify(outputBoundary).prepareFailView(contains("Account does not exist"));
    }

    @Test
    public void loggedin() {
        LoggedInState loggedInState = new LoggedInState();
        loggedInState.getDeleteAccountError();
        loggedInState.getIngredients();
        loggedInState.getNumRecipes();
        loggedInState.getUsername();
        loggedInState.getUserInventory();
        loggedInState.getUserRestrictions();
        loggedInState.setIngredients("apple");
        loggedInState.setUsername("mike");
        loggedInState.setNumRecipes("10");
        LoggedInState loggedInState1 = new LoggedInState(loggedInState);
        loggedInState1.setUserInventory("bla");
        loggedInState1.setUserRestrictions("ha");

        LoggedInViewModel loggedInViewModel = new LoggedInViewModel("bla");
        loggedInViewModel.setState(loggedInState1);

        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        loggedInViewModel.addPropertyChangeListener(propertyChangeListener);

        loggedInViewModel.getLoggedInUser();
        loggedInViewModel.setLoggedInUser("mike");
    }

}
