package process_allergy;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class process_allergy {
    public static JsonArray processAllergies(JsonArray recipes, ArrayList<String> allergies) {
        JsonArray new_recipe = new JsonArray();
        for (int i = 0; i < recipes.size(); i++) { //allows us to loop through the list of recipe json objects
            JsonObject recipe = recipes.get(i).getAsJsonObject();
            ArrayList<String> ingredients = getIngredients(recipe);
            boolean isIn = false;
            for (int k = 0; k < ingredients.size(); k ++) {
                if (checkAllergy(ingredients.get(k), allergies)) {
                    isIn = true;
                }
            }
            if (!isIn) {
                new_recipe.add(recipe);
            }
        }
        return new_recipe;
    }

    /*
    Checks to see if the ingredient is in the arraylist of allergy ingredients
     */
    public static boolean checkAllergy(String ingredient, ArrayList<String> allergies) {
        String ing = ingredient.toLowerCase();
        for (int j = 0; j < allergies.size(); j++) {
            String aller = allergies.get(j).toLowerCase();
            if (aller.contains(ing) | ing.contains(aller)){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> getIngredients(JsonObject recipe) {
        ArrayList <String> ingredients = new ArrayList<>();
        JsonArray usedIngredients = (JsonArray) recipe.get("usedIngredients");
        JsonArray missedIngredients = (JsonArray) recipe.get("missedIngredients");
        for (int i = 0; i < usedIngredients.size(); i++) {
            ingredients.add(usedIngredients.get(i).getAsJsonObject().get("name").getAsString());
        }
        for (int i = 0; i < missedIngredients.size(); i++) {
            ingredients.add(missedIngredients.get(i).getAsJsonObject().get("name").getAsString());
        }
        return ingredients;
    }
}
