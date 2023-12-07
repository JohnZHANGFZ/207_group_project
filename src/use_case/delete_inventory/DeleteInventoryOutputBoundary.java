package use_case.delete_inventory;

public interface DeleteInventoryOutputBoundary {
    void prepareFailView(String error);

    void prepareSuccessView(DeleteInventoryOutputData items);
}
