package use_case.delete_account;

public class DeleteAccountInteractor implements DeleteAccountInputBoundary {
    final DeleteAccountDataAccessInterface userDataAccessObject;
    final DeleteAccountOutputBoundary deleteAccountPresenter;

    public DeleteAccountInteractor(DeleteAccountDataAccessInterface userDataAccessInterface,
                                   DeleteAccountOutputBoundary deleteAccountPresenter) {
        this.userDataAccessObject = userDataAccessInterface;
        this.deleteAccountPresenter = deleteAccountPresenter;
    }
    @Override
    public void execute(DeleteAccountInputData deleteAccountInputData) {
        if (userDataAccessObject.deleteUser(deleteAccountInputData.getUsername())) {
            deleteAccountPresenter.prepareSuccessView();
        } else {
            deleteAccountPresenter.prepareFailureView("Unable to delete account.");
        }
    }
}
