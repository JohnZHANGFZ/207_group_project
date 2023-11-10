package entity;

import java.util.List;

public class CommonRecipe implements Recipe{
    private final Integer rank;
    private final String recipeName;
    private final List<Ingredient> ingredients;

    public CommonRecipe(Integer rank, String recipeName, List<Ingredient> ingredients) {
        this.rank = rank;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
    }

    public String getRecipeName(){
        return this.recipeName;
    }

    @Override

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
