package entity;

public class CommonIngredient implements Ingredient{
    private final String ingredient;

    public CommonIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String getName() {
        return this.ingredient;
    }
}
