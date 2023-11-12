package interface_adapter.collection.add_item;

import java.util.ArrayList;
import java.util.List;

public class AddItemState {

    private String addItemError = null;

    private List<String> ingredients = new ArrayList<>();

    public AddItemState(AddItemState copy) {
        addItemError = copy.addItemError;
        ingredients = copy.ingredients;
    }

    public AddItemState() {}

    public List<String> getIngredients() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public void setAddItemError(String error) {this.addItemError = addItemError; }
}
