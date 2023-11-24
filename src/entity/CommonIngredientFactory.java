package entity;

public class CommonIngredientFactory implements IngredientFactory {

    @Override
    public Ingredient create(String item) {
        return new CommonIngredient(item);
    }
}
