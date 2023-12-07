package entity;

import java.util.ArrayList;
import java.util.List;

public class CommonRestriction implements Collection {
    private ArrayList<Ingredient> allergies;
    public CommonRestriction(){
        this.allergies = new ArrayList();
    }
    @Override
    public ArrayList<Ingredient> getItems() {
        return this.allergies;
    }

    public String toString() {
        String result = "";
        for (int i=0; i < allergies.size(); i++) {
            result += allergies.get(i).getName();
            result += ", ";
        }
        return result;
    }

    // Given list of Ingredient objects, adds all to allergies
    @Override
    public void addItems(List<Ingredient> ingredient) {
        this.allergies.addAll(ingredient);
    }

    // Given list of Ingredient objects, checks if each matches Ingredients in allergies, deletes if matched
    @Override
    public void deleteItems(List<Ingredient> ingredient) {
        for (int i = 0; i < ingredient.size(); i++){
            Ingredient TargetIngredient = ingredient.get(i);
            for (int cur_inx = 0; cur_inx < this.allergies.size(); cur_inx ++){
                if (this.allergies.get(cur_inx).getName().equalsIgnoreCase(TargetIngredient.getName())) {
                    this.allergies.remove(cur_inx);
                }
            }
        }
    }

    @Override
    public boolean itemExists(String item) {
        for (int i = 0; i< allergies.size(); i++) {
            if (item.equalsIgnoreCase(allergies.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

}
