package entity;

import java.util.List;

public class CommonInventory implements Inventory{
    private final List<Ingredient> ingredients;

    public CommonInventory(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public void addIngredients(List<Ingredient> ingredients) {
        this.ingredients.addAll(ingredients);
    }

    @Override
    public void deleteIngredients(List<Ingredient> ingredients) {
        for (Ingredient TargetIngredient : ingredients) {
            this.ingredients.removeIf(cur_ingredient -> cur_ingredient == TargetIngredient);
    }
}
