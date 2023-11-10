package entity;

import java.util.List;

public interface Inventory {
    List<Ingredient> getIngredients();

    void addIngredients(List<Ingredient> ingredients);

    void deleteIngredients(List<Ingredient> ingredients);
}
