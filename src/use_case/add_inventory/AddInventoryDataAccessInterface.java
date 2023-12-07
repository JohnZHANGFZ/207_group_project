package use_case.add_inventory;

import entity.Ingredient;

public interface AddInventoryDataAccessInterface {
    void addInventory(Ingredient ingredient);

    boolean inventoryExists(String itemName);

}
