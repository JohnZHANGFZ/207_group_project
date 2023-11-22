package entity;

import java.util.ArrayList;

public class CommonUser implements User {
    private final String username;
    private final String password;
    private Collection inventory;
    private Collection allergies;
    private CollectionFactory inventoryFactory = new CommonInventoryFactory();
    private CollectionFactory restrictionFactory = new CommonRestrictionFactory();

    public CommonUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.inventory = inventoryFactory.create(new ArrayList<>());
        this.allergies = restrictionFactory.create(new ArrayList<>());
    }

    public void setInventory(CommonInventory inventory) { this.inventory = inventory; }

    public void setRestriction(CommonRestriction restriction) { this.allergies = restriction; }

    @Override
    public String getName() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Collection getAllergies() {
        return this.allergies;
    }

    public Collection getInventory() { return this.inventory; }
}