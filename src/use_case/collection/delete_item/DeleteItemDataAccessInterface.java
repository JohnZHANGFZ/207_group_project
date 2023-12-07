package use_case.collection.delete_item;

import entity.Ingredient;

public interface DeleteItemDataAccessInterface {
    boolean existsByName(String itemName);

    String delete(String entity, Ingredient ingredient);
}
