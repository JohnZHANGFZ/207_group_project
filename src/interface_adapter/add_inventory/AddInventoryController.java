package interface_adapter.add_inventory;

import use_case.add_inventory.AddInventoryInputBoundary;
import use_case.add_inventory.AddInventoryInputData;

import java.util.List;

public class AddInventoryController {
    final AddInventoryInputBoundary addItemUseCaseInteractor;

    public AddInventoryController(AddInventoryInputBoundary addItemUseCaseInteractor) {
        this.addItemUseCaseInteractor = addItemUseCaseInteractor;
    }

    public void execute(List<String> ingredients) {
        AddInventoryInputData addInventoryInputData = new AddInventoryInputData(ingredients);

        addItemUseCaseInteractor.execute(addInventoryInputData);
    }
}
