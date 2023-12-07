package interface_adapter.inventory;

public class InventoryState {
    private String inventoryError = null;
    private String currentInventory = "";
    private String input = "";
    private String user = "";

    public InventoryState(InventoryState copy) {
        inventoryError = copy.inventoryError;
        currentInventory = copy.currentInventory;
        user = copy.user;
        input = copy.input;
    }

    public InventoryState() {}
    public String getInventory() { return currentInventory; }
    public String getInventoryError() { return inventoryError;}
    public void setInventoryError(String inventoryError) {this.inventoryError = inventoryError;}
    public void setInventory(String currentInventory) {this.currentInventory = currentInventory; }
    public void setInput(String input) {this.input = input;}
    public String getInput() {return input;}
    public String getUser() {return user;}
    public void setUser(String user) {this.user = user;}
}
