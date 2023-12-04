package interface_adapter.delete_item;

import use_case.collection.delete_item.DeleteItemInputBoundary;
import use_case.collection.delete_item.DeleteItemInputData;

import java.util.List;

public class DeleteItemController {
    final DeleteItemInputBoundary deleteItemUseCaseInteractor;

    public DeleteItemController(DeleteItemInputBoundary deleteItemUseCaseInteractor) {
        this.deleteItemUseCaseInteractor = deleteItemUseCaseInteractor;
    }

    public void execute(List<String> ingredients) {
        DeleteItemInputData deleteItemInputData = new DeleteItemInputData(ingredients);

        deleteItemUseCaseInteractor.execute(deleteItemInputData);
    }
}
