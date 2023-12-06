package use_case.delete_account;

public interface DeleteAccountOutputBoundary {
    void prepareSuccessView();
    void prepareFailureView(String error);
}
