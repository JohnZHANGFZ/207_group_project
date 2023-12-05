package interface_adapter.inventory;

import use_case.edit_inventory.EditInventoryInputBoundary;

public class InventoryController {
    final EditInventoryInputBoundary editInventoryInteractor;

    public InventoryController(EditInventoryInputBoundary editInventoryInteractor) {
        this.editInventoryInteractor = editInventoryInteractor;
    }

    public void execute() {
        editInventoryInteractor.execute();
    }
}
