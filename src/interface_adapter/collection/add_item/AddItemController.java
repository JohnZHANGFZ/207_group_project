package interface_adapter.collection.add_item;

import use_case.collection.AddItem.AddItemInputBoundary;
import use_case.collection.AddItem.AddItemInputData;

import java.util.List;

public class AddItemController {
    final AddItemInputBoundary addItemUseCaseInteractor;

    public AddItemController(AddItemInputBoundary addItemUseCaseInteractor) {
        this.addItemUseCaseInteractor = addItemUseCaseInteractor;
    }

    void execute(List<String> ingredients) {
        AddItemInputData addItemInputData = new AddItemInputData(ingredients);

        addItemUseCaseInteractor.execute(addItemInputData);
    }
}
