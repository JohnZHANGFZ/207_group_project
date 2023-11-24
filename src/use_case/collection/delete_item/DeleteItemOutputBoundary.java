package use_case.collection.delete_item;

public interface DeleteItemOutputBoundary {
    void prepareFailView(String error);

    void prepareSuccessView(DeleteItemOutputData items);
}
