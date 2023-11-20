package entity;

import java.util.ArrayList;
import java.util.List;

public class CommonInventory implements Collection {

    private List<Ingredient> inventory;

    CommonInventory() { this.inventory = new ArrayList(); }

    @Override
    public List<Ingredient> getItems() { return inventory; }

    @Override
    public void addItems(List<Ingredient> ingredient) {
        for (int i=0; i < ingredient.size(); i++) {
            inventory.add(ingredient.get(i));
        }
    }

    @Override
    // Used Joe's implementation of CommonRestriction's deleteItems
    public void deleteItems(List<Ingredient> ingredient) {
        for (int i = 0; i < ingredient.size(); i++){
            Ingredient TargetIngredient = ingredient.get(i);
            for (int cur_inx = 0; cur_inx < this.inventory.size(); cur_inx ++){
                if (this.inventory.get(cur_inx).getName().equalsIgnoreCase(TargetIngredient.getName())) {
                    this.inventory.remove(cur_inx);
                }
            }
        }
    }
}
