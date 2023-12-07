package use_case.remove_dietary_restriction;


import use_case.delete_inventory.DeleteInventoryOutputData;

public interface RemoveRestrictionOutputBoundary {
    void prepareFailView(String error);

    void prepareSuccessView(DeleteInventoryOutputData items);
}
