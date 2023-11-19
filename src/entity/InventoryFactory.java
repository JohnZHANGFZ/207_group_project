package entity;

import java.util.List;

public interface InventoryFactory {
    CommonInventory create(List<String> inventory);
}
