package data_access;

import entity.Ingredient;
import entity.User;
import use_case.collection.add_item.AddItemDataAccessInterface;
import use_case.collection.delete_item.DeleteItemDataAccessInterface;
import use_case.delete_account.DeleteAccountDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface,
        DeleteAccountDataAccessInterface, AddItemDataAccessInterface, DeleteItemDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Ingredient> inventory = new HashMap<>();

    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    //deleteItem
    @Override
    public String delete(Ingredient ingredient) {
        if (inventory.containsValue(ingredient)) {
            inventory.remove(ingredient);
            return String.valueOf(ingredient);
        } else{
            return "Ingredient does not exist.";
        }
    }

    //addItem
    @Override
    public void add(Ingredient ingredient) {
        inventory.put(String.valueOf(ingredient), ingredient);
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
}
