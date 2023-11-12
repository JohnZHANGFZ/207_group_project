package use_case.collection.AddItem;

public interface AddItemOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
}
