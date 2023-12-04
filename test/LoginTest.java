import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;
import use_case.login.*;
public class LoginTest {
    @Test
    public void testSuccessfulLogin() {
        LoginUserDataAccessInterface userDataAccess = mock(LoginUserDataAccessInterface.class);
        LoginOutputBoundary outputBoundary = mock(LoginOutputBoundary.class);
        when(userDataAccess.existsByName("validUser")).thenReturn(true);
        when(userDataAccess.getUser("validUser")).thenReturn(new User("validUser", "password123"));

        LoginInteractor loginInteractor = new LoginInteractor(userDataAccess, outputBoundary);
        loginInteractor.execute(new LoginInputData("validUser", "password123"));

        verify(outputBoundary).prepareSuccessView(any(LoginOutputData.class));
    }

    @Test
    public void testLoginWithWrongPassword() {
        LoginUserDataAccessInterface userDataAccess = mock(LoginUserDataAccessInterface.class);
        LoginOutputBoundary outputBoundary = mock(LoginOutputBoundary.class);
        when(userDataAccess.existsByName("validUser")).thenReturn(true);
        when(userDataAccess.getUser("validUser")).thenReturn(new User("validUser", "password123"));

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

}
