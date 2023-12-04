package interface_adapter.delete_item;

import java.util.ArrayList;
import java.util.List;

public class DeleteItemState {
    private String deleteItemError = null;

    private List<String> ingredients = new ArrayList<>();

    public DeleteItemState(DeleteItemState copy) {
        deleteItemError = copy.deleteItemError;
        ingredients = copy.ingredients;
    }

    public DeleteItemState() {}

    public List<String> getIngredients() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public void setDeleteItemError(String error) {this.deleteItemError = error; }
}
