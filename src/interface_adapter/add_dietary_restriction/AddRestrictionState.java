package interface_adapter.add_dietary_restriction;

import java.util.ArrayList;
import java.util.List;

public class AddRestrictionState {

    private String addRestrictionError = null;

    private List<String> ingredients = new ArrayList<>();

    public AddRestrictionState(AddRestrictionState copy) {
        addRestrictionError = copy.addRestrictionError;
        ingredients = copy.ingredients;
    }

    public AddRestrictionState() {}

    public List<String> getIngredients() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public void setAddRestrictionError(String error) {this.addRestrictionError = addRestrictionError; }
}