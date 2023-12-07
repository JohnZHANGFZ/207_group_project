package interface_adapter.delete_item;

import use_case.delete_inventory.DeleteInventoryInputBoundary;
import use_case.delete_inventory.DeleteInventoryInputData;

import java.util.List;

public class DeleteItemController {
    final DeleteInventoryInputBoundary deleteItemUseCaseInteractor;

    public DeleteItemController(DeleteInventoryInputBoundary deleteItemUseCaseInteractor) {
        this.deleteItemUseCaseInteractor = deleteItemUseCaseInteractor;
    }

    public void execute(List<String> ingredients) {
        DeleteInventoryInputData deleteInventoryInputData = new DeleteInventoryInputData(ingredients);

        deleteItemUseCaseInteractor.execute(deleteInventoryInputData);
    }
}
