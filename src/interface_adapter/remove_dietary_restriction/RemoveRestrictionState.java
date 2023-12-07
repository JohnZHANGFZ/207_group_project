package interface_adapter.remove_dietary_restriction;

import java.util.ArrayList;
import java.util.List;

public class RemoveRestrictionState {
    private String removeRestrictionError = null;

    private List<String> ingredients = new ArrayList<>();

    public RemoveRestrictionState(RemoveRestrictionState copy) {
        removeRestrictionError = copy.removeRestrictionError;
        ingredients = copy.ingredients;
    }

    public RemoveRestrictionState() {}

    public List<String> getIngredients() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public void setRemoveRestrictionError(String error) {this.removeRestrictionError = error; }
}
