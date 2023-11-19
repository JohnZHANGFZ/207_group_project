package use_case.collection.get_item;

public interface GetItemOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
