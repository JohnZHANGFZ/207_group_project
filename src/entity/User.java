package entity;
import java.util.List;

public interface User {
    String getName();

    Integer getPassword();

    List<String> getAllergies();

    Inventory getInventory();
}
