package data_access;

import entity.User;
import use_case.delete_account.DeleteAccountDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface, DeleteAccountDataAccessInterface {

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
}
