package use_case.collection.delete_item;

import entity.Ingredient;

public interface DeleteItemDataAccessInterface {
    boolean existByName(String itemName);

    String delete(Ingredient ingredient);
}
