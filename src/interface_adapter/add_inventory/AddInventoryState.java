package interface_adapter.add_inventory;

import java.util.ArrayList;
import java.util.List;

public class AddInventoryState {

    private String addItemError = null;

    private List<String> ingredients = new ArrayList<>();

    public AddInventoryState(AddInventoryState copy) {
        addItemError = copy.addItemError;
        ingredients = copy.ingredients;
    }

    public AddInventoryState() {}

    public List<String> getIngredients() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public void setAddItemError(String error) {this.addItemError = addItemError; }
}
