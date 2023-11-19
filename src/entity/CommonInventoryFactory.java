package entity;

import java.util.ArrayList;
import java.util.List;

public class CommonInventoryFactory implements InventoryFactory {
    private IngredientFactory factory = new CommonIngredientFactory();

    @Override
    public CommonInventory create(List<String> items) {
        CommonInventory inventory = new CommonInventory();
        List listIngredient = new ArrayList<CommonIngredient>();
        for (int i = 0; i < items.size(); i++) {
            Ingredient item = factory.create(items.get(i));
            listIngredient.add(item);
        }
        inventory.addItems(listIngredient);
        return inventory;
    }
}
