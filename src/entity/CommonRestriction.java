package entity;

import java.util.List;

public class CommonRestriction implements Restriction{
    private List<Ingredient> allergies;
    public CommonRestriction(List<Ingredient> allergies){
        this.allergies = allergies;
    }
    @Override
    public List<Ingredient> getAllergies() {
        return this.allergies;
    }

    @Override
    public void addAllergies(List<Ingredient> ingredient) {
        this.allergies.addAll(ingredient);
    }

    @Override
//    public void deleteAllergies(List<Ingredient> ingredient) {
//        for (Integer i = 0; i < ingredient.size(); i++){
//            Ingredient TargetIngredient = ingredient.get(i);
//            for (Integer cur_inx = 0; cur_inx < this.allergies.size(); cur_inx ++){
//                if (this.allergies.get(cur_inx).getName() == TargetIngredient.getName()) {
//                    this.allergies.remove(cur_inx);
//                }
//            }
//        }
//    }
    public void deleteAllergies(List<Ingredient> ingredient) {
        for (Ingredient TargetIngredient : ingredient) {
            this.allergies.removeIf(cur_ingredient -> cur_ingredient == TargetIngredient);
        }
    }
}
