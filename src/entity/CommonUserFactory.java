package entity;

public class CommonUserFactory implements UserFactory {

    @Override
    public User create(String name, String password) {
        return new CommonUser(name, password);
    }

    public User create(String name, String password, CommonInventory inventory) {
        CommonUser user = new CommonUser(name, password);
        return user;
    }
}
