package use_case.edit_inventory;

public class EditInventoryInteractor implements EditInventoryInputBoundary {

    final EditInventoryOutputBoundary editInventoryPresenter;

    public EditInventoryInteractor(EditInventoryOutputBoundary editInventoryOutputBoundary) {
        this.editInventoryPresenter = editInventoryOutputBoundary;
    }

    @Override
    public void execute() {
        editInventoryPresenter.prepareSuccessView();
    }
}
