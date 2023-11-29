package interface_adapter.inventory;

public class InventoryState {
    private String inventoryError = null;
    private String inventory = "";

    public InventoryState(InventoryState copy) {
        inventoryError = copy.inventoryError;
        inventory = copy.inventory;
    }

    public InventoryState() {}
    public String getInventory() { return inventory; }
    public String getInventoryError() { return inventoryError;}
}
