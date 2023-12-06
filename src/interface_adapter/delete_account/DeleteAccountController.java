package interface_adapter.delete_account;

import use_case.delete_account.DeleteAccountInputBoundary;
import use_case.delete_account.DeleteAccountInputData;
import use_case.login.LoginInputBoundary;

public class DeleteAccountController {
    final DeleteAccountInputBoundary deleteAccountInteractor;

    public DeleteAccountController(DeleteAccountInputBoundary deleteAccountInteractor) {
        this.deleteAccountInteractor = deleteAccountInteractor;
    }

    public void execute(String username) {
        DeleteAccountInputData deleteAccountInputData = new DeleteAccountInputData(username);
        deleteAccountInteractor.execute(deleteAccountInputData);
    }
}
