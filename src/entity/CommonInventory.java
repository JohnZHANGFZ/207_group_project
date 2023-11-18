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
        for (int i=0; i < ingredient.size(); i++) {
            inventory.add(ingredient.get(i));
        }
    }

    @Override
    public void deleteItems(List<Ingredient> ingredient) {

    }
}
