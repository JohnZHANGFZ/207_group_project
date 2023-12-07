package interface_adapter.delete_inventory;

import java.util.ArrayList;
import java.util.List;

public class DeleteInventoryState {
    private String deleteItemError = null;

    private List<String> ingredients = new ArrayList<>();

    public DeleteInventoryState(DeleteInventoryState copy) {
        deleteItemError = copy.deleteItemError;
        ingredients = copy.ingredients;
    }

    public DeleteInventoryState() {}

    public List<String> getIngredients() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public void setDeleteItemError(String error) {this.deleteItemError = error; }
}
