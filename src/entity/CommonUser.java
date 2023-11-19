package entity;

import java.util.ArrayList;
import java.util.List;

public class CommonUser implements User {
    private final String username;
    private final String password;
    private CommonInventory inventory;
    private List<String> allergies;
    private InventoryFactory inventoryFactory = new CommonInventoryFactory();

     CommonUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.inventory = inventoryFactory.create(new ArrayList<>());
        this.allergies = null;
    }

    @Override
    public String getName() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public List<String> getAllergies() {
        return this.allergies;
    }

    public CommonInventory getInventory() { return this.inventory; }
}
