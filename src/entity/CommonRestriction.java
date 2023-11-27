package entity;

import java.util.ArrayList;
import java.util.List;

public class CommonRestriction implements Collection {
    private List<Ingredient> allergies;
    public CommonRestriction(){
        this.allergies = new ArrayList();
    }
    @Override
    public List<Ingredient> getItems() {
        return this.allergies;
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
}
