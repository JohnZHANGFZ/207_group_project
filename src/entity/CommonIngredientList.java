package entity;

import java.util.ArrayList;

public class CommonIngredientList {
    private ArrayList<CommonIngredient> ingredients;

    public void ingredientsListAdd(CommonIngredient s) {
        this.ingredients.add(s);
    }

    public void addAll(ArrayList<CommonIngredient> s) {
        ingredients.addAll(s);
    }

    public ArrayList<CommonIngredient> getIngredients() {
        return ingredients;
    }
}
