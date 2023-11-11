package use_case.input_new_ingredient;

import java.util.List;

public class InputIngredientOutputData {
    final private List<String> item;

    public InputIngredientOutputData(List<String> item) {
        this.item = item;
    }

    List<String> getIngredients() { return item; }

}
