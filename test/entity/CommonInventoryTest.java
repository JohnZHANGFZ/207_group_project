package entity;

import junit.framework.TestCase;

import java.util.ArrayList;


public class CommonInventoryTest extends TestCase {
    private CommonInventory inventory;

    public void testGetItems() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Ingredient apple = new CommonIngredient("Apple");
        ingredients.add(apple);
        inventory.addItems(ingredients);
        assertEquals(ingredients, inventory.getItems());
    }


    public void testAddItems() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Ingredient apple = new CommonIngredient("Apple");
        Ingredient banana = new CommonIngredient("Banana");
        ingredients.add(apple);
        ingredients.add(banana);
        inventory.addItems(ingredients);
        assertEquals(ingredients, inventory.getItems());
    }

    public void testDeleteItems() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Ingredient apple = new CommonIngredient("Apple");
        Ingredient banana = new CommonIngredient("Banana");
        ingredients.add(apple);
        ingredients.add(banana);
        inventory.addItems(ingredients);

        ArrayList<Ingredient> deleteIngredients = new ArrayList<>();
        deleteIngredients.add(banana);
        inventory.deleteItems(deleteIngredients);

        ArrayList<Ingredient> updatedIngredients = new ArrayList<>();
        updatedIngredients.add(apple);

        assertEquals(updatedIngredients, inventory.getItems());
    }
}