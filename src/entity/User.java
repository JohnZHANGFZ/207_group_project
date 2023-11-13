package entity;
import java.util.List;
import java.time.LocalDateTime;

public interface User {
    String getName();

    String getPassword();

    CommonRestriction getAllergies();

    CommonInventory getInventory();

}
