package use_case.delete_inventory;

import entity.Ingredient;

public interface DeleteInventoryDataAccessInterface {
    String deleteInventory(Ingredient ingredient);

    boolean inventoryExists(String itemName);
}
