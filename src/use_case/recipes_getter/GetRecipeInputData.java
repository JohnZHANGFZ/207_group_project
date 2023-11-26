package use_case.recipes_getter;
import java.util.ArrayList;
public class GetRecipeInputData {
    final private ArrayList<String> ingredients;
    final private int number;

    public GetRecipeInputData(ArrayList<String> ingredients, int number) {
        this.ingredients = ingredients;
        this.number = number;
    }

    ArrayList<String> getIngredients() {
        return ingredients;
    }

    int getNumber() {
        return number;
    }

}
