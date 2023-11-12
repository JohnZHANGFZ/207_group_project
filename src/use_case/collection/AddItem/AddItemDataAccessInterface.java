package use_case.collection.AddItem;

import entity.Ingredient;

public interface AddItemDataAccessInterface {
    boolean existsByName(String itemName);

    void save(Ingredient ingredient);

}
