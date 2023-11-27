package entity;

import java.util.List;

public interface Recipe {
    String getRecipeName();
    List<Ingredient> getIngredients();
}
