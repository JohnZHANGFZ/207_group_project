package data_access;

import entity.User;
import entity.UserFactory;
import entity.CollectionFactory;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface {
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
    public boolean existByName(String identifier) {

    }

    @Override
    public void save(User user) {

    }
}
