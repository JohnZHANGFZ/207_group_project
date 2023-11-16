package entity;

import java.util.ArrayList;
import java.util.List;

public class CommonInventory implements Inventory {

    private List<Ingredient> inventory;

    CommonInventory() {
        this.inventory = new ArrayList();
    }

    @Override
    public List<Ingredient> getItems() {
        return inventory;
    }

    @Override
    public void addItems(List<Ingredient> ingredient) {

    }

    @Override
    public void deleteItems(List<Ingredient> ingredient) {

    }
}
