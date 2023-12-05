package use_case.login;

import entity.Ingredient;

import java.util.ArrayList;

public class LoginOutputData {
    private final String user;
    private boolean failure;
    private final String userInventory;
    private final String userRestrictions;

    public LoginOutputData(String user, boolean failure, String userInventory, String userRestrictions) {
        this.user = user;
        this.failure = failure;
        this.userInventory = userInventory;
        this.userRestrictions = userRestrictions;
    }

    public String getUsername() { return user; }

    public String getUserInventory() {
        return userInventory;
    }

    public String getUserRestrictions() {
        return userRestrictions;
    }
}
