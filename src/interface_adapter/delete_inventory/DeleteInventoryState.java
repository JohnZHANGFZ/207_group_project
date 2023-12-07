package interface_adapter.delete_inventory;

import java.util.ArrayList;
import java.util.List;

public class DeleteInventoryState {
    private String username = "";
    private String deleteItemError = null;

    private List<String> ingredients = new ArrayList<>();

    public DeleteInventoryState(DeleteInventoryState copy) {
        deleteItemError = copy.deleteItemError;
        ingredients = copy.ingredients;
        username = copy.username;
    }

    public DeleteInventoryState() {}

    public List<String> getIngredients() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public void setDeleteItemError(String error) {this.deleteItemError = error; }

    public void setUsername(String username) {this.username = username;}

    public String getUsername() {return username;}
}
