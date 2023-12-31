package data_access;

import entity.*;
import entity.Collection;
import use_case.add_dietary_restriction.AddRestrictionDataAccessInterface;
import use_case.delete_account.DeleteAccountDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.remove_dietary_restriction.RemoveRestrictionDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;
import use_case.add_inventory.AddInventoryDataAccessInterface;
import use_case.delete_inventory.DeleteInventoryDataAccessInterface;

import java.io.*;
import java.util.*;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface,
        AddInventoryDataAccessInterface, DeleteInventoryDataAccessInterface, DeleteAccountDataAccessInterface,
        AddRestrictionDataAccessInterface, RemoveRestrictionDataAccessInterface {

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, User> accounts = new HashMap<>();
    private UserFactory userFactory;
    private CollectionFactory inventoryFactory;
    private CollectionFactory restrictionsFactory;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory, CollectionFactory inventoryFactory,
                                    CollectionFactory restrictionsFactory) throws IOException {
        this.userFactory = userFactory;
        this.inventoryFactory = inventoryFactory;
        this.restrictionsFactory = restrictionsFactory;

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("inventory", 2);
        headers.put("allergies", 3);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                assert header.equals("username;password;inventory;allergies");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(";");

                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);

                    List<String> inventoryList = Arrays.asList(col[headers.get("inventory")].split(",",-1));
                    Collection inventory = inventoryFactory.create(inventoryList);

                    List<String> allergiesList = Arrays.asList(col[headers.get("allergies")].split(",",-1));
                    Collection allergies = restrictionsFactory.create(allergiesList);

                    User user = userFactory.create(username, password, inventory, allergies);
                    accounts.put(username, user);
                }
            }
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s;%s;%s;%s",
                        user.getName(), user.getPassword(),
                        user.getInventory().getItems(), user.getAllergies().getItems());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public boolean deleteUser(String username) {

        if (existsByName(username)) {

            accounts.remove(username);

            try {
                File tempFile = new File("myTempFile.txt"); // creates new file to rewrite data into

                BufferedReader reader = new BufferedReader(new FileReader(csvFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String lineToRemove = username;
                int nameLength = username.length();
                String currentLine;

                // checkes if first nameLength of each length matches username to remove, skips over that line if matches
                while((currentLine = reader.readLine()) != null) {
                    String currentUser = currentLine.trim().substring(0, nameLength);
                    if(currentUser.equals(lineToRemove)) continue;
                    writer.write(currentLine + "/n");
                }

                writer.close();
                reader.close();

                csvFile.delete();
                tempFile.renameTo(csvFile); // renames new file to replace original

                return true;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            return false;
        }
    }

    @Override
    public User getUser(String username) { return accounts.get(username); }

    @Override
    public boolean inventoryExists(String user, String itemName) {
        User target = accounts.get(user);
        return target.getInventory().itemExists(itemName);
    }

    @Override
    public void addInventory(String user, Ingredient ingredient) {
        User theUser = accounts.get(user);
        Collection userInventory = theUser.getInventory();

        ArrayList<Ingredient> addedIngredient = new ArrayList<>();
        if (!inventoryExists(user, String.valueOf(ingredient))) {
            addedIngredient.add(ingredient);
            userInventory.addItems(addedIngredient);
            theUser.setInventory(userInventory);
            accounts.put(user, theUser);
            this.save();
        } else {
            System.out.println("Input exists");
        }
    }

    @Override
    public String deleteInventory(String user, Ingredient ingredient) {
        User target = accounts.get(user);
        Collection targetInventory = target.getInventory();
        ArrayList deleteList = new ArrayList();
        deleteList.add(ingredient);
        targetInventory.deleteItems(deleteList);

        accounts.put(user, target);
        this.save();
        return ingredient.getName();
    }

    @Override
    public boolean restrictionExists(String itemName) {
        return false;
    }

    @Override
    public void addRestriction(Ingredient restriction) {

    }

    @Override
    public String removeRestriction(Ingredient ingredient) {
        return null;
    }
}
