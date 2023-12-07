package interface_adapter.delete_inventory;

import java.util.ArrayList;

public class DeleteInventoryState {
    private String username = "";
    private String deleteItemError = null;

    private ArrayList<String> ingredients = new ArrayList<>();

    public DeleteInventoryState(DeleteInventoryState copy) {
        deleteItemError = copy.deleteItemError;
        ingredients = copy.ingredients;
        username = copy.username;
    }

    public DeleteInventoryState() {}

    public ArrayList<String> getIngredients() { return ingredients; }

    public void setIngredients(ArrayList<String> ingredients) { this.ingredients = ingredients; }

    public void setDeleteItemError(String error) {this.deleteItemError = error; }

    public void setUsername(String username) {this.username = username;}

    public String getUsername() {return username;}
}
