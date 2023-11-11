package use_case.input_new_ingredient;

import entity.Ingredient;

public interface InputIngredientDataAccessInterface {
    boolean existsByName(String itemName);

    void save(Ingredient ingredient);
}
