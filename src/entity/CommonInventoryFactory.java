package entity;

import java.util.ArrayList;
import java.util.List;

public class CommonInventoryFactory implements CollectionFactory {
    private IngredientFactory factory = new CommonIngredientFactory();

    @Override
    // instantiates blank Inventory, iterates list items, creates each String into Ingredient object, appends to empty
    // list, then adds list of Ingredient objects to blank inventory
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
