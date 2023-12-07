import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import org.junit.Test;
import use_case.edit_inventory.EditInventoryInputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;

import static org.mockito.Mockito.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class LogoutTest {
    @Test
    public void logout() {
        LogoutOutputBoundary logoutOutputBoundary = mock(LogoutOutputBoundary.class);
        LogoutInteractor logoutInteractor = new LogoutInteractor(logoutOutputBoundary);
        logoutInteractor.execute();
    }

    @Test
    public void presenterTest() {
        LogoutPresenter logoutPresenter = new LogoutPresenter(new ViewManagerModel(), new LoginViewModel("hi"));
        logoutPresenter.prepareSuccessView();
    }

    @Test
    public void controllerTest() {
        LogoutInputBoundary logoutInputBoundary = mock(LogoutInputBoundary.class);
        LogoutController logoutController = new LogoutController(logoutInputBoundary);
        logoutController.execute();
    }
}
