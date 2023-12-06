package use_case.collection.add_item;

import entity.Ingredient;

public interface AddItemDataAccessInterface {
    boolean existsByName(String itemName);

    void add(Ingredient ingredient);

}
