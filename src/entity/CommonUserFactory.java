package entity;

public class CommonUserFactory implements UserFactory {

    @Override
    public User create(String name, String password) {
        return new CommonUser(name, password);
    }

    public User create(String name, String password, Collection inventory, Collection allergies) {
        CommonUser user = new CommonUser(name, password);
        user.setInventory(inventory);
        user.setRestriction(allergies);
        return user;
    }
}
