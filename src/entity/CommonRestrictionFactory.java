package entity;

import java.util.ArrayList;
import java.util.List;

public class CommonRestrictionFactory implements CollectionFactory {
    private IngredientFactory factory = new CommonIngredientFactory();
    @Override
    public CommonRestriction create(List<String> items) {
        CommonRestriction allergies = new CommonRestriction();
        List listIngredient = new ArrayList<CommonIngredient>();
        for (int i = 0; i < items.size(); i++) {
            Ingredient item = factory.create(items.get(i));
            listIngredient.add(item);
        }
        allergies.addItems(listIngredient);
        return allergies;
    }
}
