import interface_adapter.ViewManagerModel;
import interface_adapter.delete_account.DeleteAccountController;
import interface_adapter.delete_account.DeleteAccountPresenter;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import org.junit.Test;
import use_case.collection.delete_item.DeleteItemInputBoundary;
import use_case.collection.delete_item.DeleteItemInputData;
import use_case.delete_account.DeleteAccountInputBoundary;

import static org.mockito.Mockito.*;
import java.awt.*;

public class DeleteAccountTest {
    @Test
    public void deleteTest() {
        DeleteAccountInputBoundary deleteAccountInputBoundary = mock(DeleteAccountInputBoundary.class);
        DeleteAccountController deleteAccountController = new DeleteAccountController(deleteAccountInputBoundary);
        deleteAccountController.execute("mike");
    }

    @Test
    public void presenterTest() {
        DeleteAccountPresenter deleteAccountPresenter = new DeleteAccountPresenter(new ViewManagerModel(), new LoggedInViewModel("bla"), new LoginViewModel("bla"));
        deleteAccountPresenter.prepareSuccessView();
        deleteAccountPresenter.prepareFailureView("fail");
    }
}
