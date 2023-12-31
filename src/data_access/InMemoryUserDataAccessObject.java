package data_access;

import entity.*;
import use_case.add_dietary_restriction.AddRestrictionDataAccessInterface;
import use_case.add_inventory.AddInventoryDataAccessInterface;
import use_case.delete_account.DeleteAccountDataAccessInterface;
import use_case.delete_inventory.DeleteInventoryDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.remove_dietary_restriction.RemoveRestrictionDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface,
        DeleteAccountDataAccessInterface, AddRestrictionDataAccessInterface, RemoveRestrictionDataAccessInterface,
        AddInventoryDataAccessInterface, DeleteInventoryDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public boolean deleteUser(String username) {
        if (existsByName(username)) {
            users.remove(username);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }

    public boolean isEmpty() { return users.isEmpty(); }

    @Override
    public void addRestriction(Ingredient restriction) {

    }

    @Override
    public boolean restrictionExists(String itemName) {
        return false;
    }

    @Override
    public String removeRestriction(Ingredient ingredient) {
        return null;
    }


    // does not check if exists here bc it is already checked before deleteInventory method is called in interactor
    @Override
    public String deleteInventory(String user, Ingredient ingredient) {
        User target = users.get(user);
        Collection targetInventory = target.getInventory();
        ArrayList deleteList = new ArrayList();
        deleteList.add(ingredient);
        targetInventory.deleteItems(deleteList);
        return ingredient.getName();
    }

    @Override
    public void addInventory(String user, Ingredient ingredient) {

    }

    @Override
    public boolean inventoryExists(String user, String itemName) {
        User target = users.get(user);
        return target.getInventory().itemExists(itemName);

    }
}
