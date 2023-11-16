package entity;

import java.util.List;

public interface InventoryFactory {
    Inventory create(List<String> inventory);
}
