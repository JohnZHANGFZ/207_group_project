package use_case.add_inventory;

import entity.Ingredient;

public interface AddInventoryDataAccessInterface {
    void addInventory(String user, Ingredient ingredient);

    boolean inventoryExists(String user, String itemName);

}
