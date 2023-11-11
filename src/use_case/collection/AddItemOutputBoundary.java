package use_case.collection;

public interface AddItemOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
}
