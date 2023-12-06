package use_case.delete_account;

public class DeleteAccountOutputData {
    private boolean useCaseFailed;

    public DeleteAccountOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }
}
