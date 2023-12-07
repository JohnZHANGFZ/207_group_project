package interface_adapter.delete_inventory;

import use_case.delete_inventory.DeleteInventoryInputBoundary;
import use_case.delete_inventory.DeleteInventoryInputData;

import java.util.ArrayList;
import java.util.List;

public class DeleteInventoryController {
    final DeleteInventoryInputBoundary deleteItemUseCaseInteractor;

    public DeleteInventoryController(DeleteInventoryInputBoundary deleteItemUseCaseInteractor) {
        this.deleteItemUseCaseInteractor = deleteItemUseCaseInteractor;
    }

    public void execute(String user, ArrayList<String> ingredients) {
        DeleteInventoryInputData deleteInventoryInputData = new DeleteInventoryInputData(user, ingredients);

        deleteItemUseCaseInteractor.execute(deleteInventoryInputData);
    }
}
