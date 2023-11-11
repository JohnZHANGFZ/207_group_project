package use_case.input_new_ingredient;

import java.util.List;

public class InputIngredientInputData {

    final private List<String> item;

    public InputIngredientInputData(List<String> item) {
        this.item = item;
    }

    List<String> getIngredients() { return item; }
}
