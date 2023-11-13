package entity;

import java.util.List;

public class CommonUser implements User {
    private final String username;
    private final String password;
    private CommonInventory inventory = null;
    private CommonRestriction allergies = null;

    public CommonUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.inventory = null;
        this.allergies = null;
    }
    public CommonUser(String username, String password, CommonInventory inventory) {
        this.username = username;
        this.password = password;
        this.inventory = inventory;
        this.allergies = null;
    }
    public CommonUser(String username, String password, CommonRestriction allergies) {
        this.username = username;
        this.password = password;
        this.allergies = allergies;
        this.inventory = null;
    }
    public CommonUser(String username, String password, CommonInventory inventory, CommonRestriction allergies) {
        this.username = username;
        this.password = password;
        this.inventory = inventory;
        this.allergies = allergies;
    }

    @Override
    public String getName() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    // TODO: if this.allergies is null, should we raise exception?
    @Override
    public CommonRestriction getAllergies() {
        return this.allergies;
    }

    // TODO: if this.inventory is null, should we raise exception?
    public CommonInventory getInventory(){
        return this.inventory;
    }
}
