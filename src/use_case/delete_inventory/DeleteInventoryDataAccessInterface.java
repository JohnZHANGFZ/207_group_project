package use_case.delete_inventory;

import entity.Ingredient;

public interface DeleteInventoryDataAccessInterface {
    String deleteInventory(String user, Ingredient ingredient);

    boolean inventoryExists(String user, String itemName);
}
