package interface_adapter.add_item;

import use_case.add_inventory.AddInventoryInputBoundary;
import use_case.add_inventory.AddInventoryInputData;

import java.util.List;

public class AddItemController {
    final AddInventoryInputBoundary addItemUseCaseInteractor;

    public AddItemController(AddInventoryInputBoundary addItemUseCaseInteractor) {
        this.addItemUseCaseInteractor = addItemUseCaseInteractor;
    }

    public void execute(List<String> ingredients) {
        AddInventoryInputData addInventoryInputData = new AddInventoryInputData(ingredients);

        addItemUseCaseInteractor.execute(addInventoryInputData);
    }
}
