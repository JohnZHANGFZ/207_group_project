package entity;

import java.util.List;

public interface Inventory {
    List<Ingredient> getRecipes();

    void addRecipes(List<Ingredient> ingredient);

    void deleteRecipes(List<Ingredient> ingredient);
}
