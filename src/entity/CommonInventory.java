package entity;

import java.util.ArrayList;
import java.util.List;

public class CommonInventory implements Collection {

    private ArrayList<Ingredient> inventory;

    public CommonInventory() { this.inventory = new ArrayList(); }

    @Override
    public ArrayList<Ingredient> getItems() { return inventory; }

    // returns inventory as String, with each item separated by ','
    @Override
    public String toString() {
        String result = "";
        for (int i=0; i < inventory.size(); i++) {
            result += inventory.get(i).getName();
            result += ", ";
        }
        return result;
    }

    // Given list of Ingredient objects, adds each to inventory
    @Override
    public void addItems(List<Ingredient> ingredient) {
        for (int i=0; i < ingredient.size(); i++) {
            inventory.add(ingredient.get(i));
        }
    }

    @Override
    // Given list of Ingredient objects, checks if each matches Ingredients in inventory, deletes if matched
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
