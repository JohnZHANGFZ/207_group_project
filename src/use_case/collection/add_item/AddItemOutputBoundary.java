package use_case.collection.add_item;

public interface AddItemOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
}
