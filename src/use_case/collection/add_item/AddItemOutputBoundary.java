package use_case.collection.add_item;

public interface AddItemOutputBoundary {
    void prepareSuccessView(String type);
    void prepareFailView(String error);
}
