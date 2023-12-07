package use_case.add_inventory;

public interface AddItemOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
