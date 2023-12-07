package use_case.add_inventory;

public interface AddInventoryOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
