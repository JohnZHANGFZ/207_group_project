package interface_adapter.input_ingredient;

import java.util.ArrayList;
import java.util.List;

public class InputIngredientState {

    private String inputIngredientError = null;

    private List<String> ingredients = new ArrayList<>();

    public InputIngredientState(InputIngredientState copy) {
        inputIngredientError = copy.inputIngredientError;
        ingredients = copy.ingredients;
    }

    public InputIngredientState() {}

    public List<String> getIngredient() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public void setInputIngredientError(String error) { this.inputIngredientError = inputIngredientError; }
}
