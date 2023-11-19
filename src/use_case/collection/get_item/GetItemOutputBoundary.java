package use_case.collection.get_item;

public interface GetItemOutputBoundary {
    void prepareSuccessView(GetItemOutputData getItemOutputData);

    void prepareFailView(String error);
}
