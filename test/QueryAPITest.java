import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.Test;
import search_recipe.DeprecatedQueryAPI;
import search_recipe.QueryAPI;
import process_allergy.process_allergy;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class QueryAPITest {

    @Test
    public void testMainRuns() {
        DeprecatedQueryAPI.main(new String[]{});
    }

    @Test
    public void testGetResultReturnsFailedRuns(){
        ArrayList<String> empty = new ArrayList<>();
        assertEquals(new JsonArray(), DeprecatedQueryAPI.getResults(empty, 1));
    }

    @Test
    public void testGetResultReturnsResultsRuns(){
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("egg");
        ingredients.add("apple");
        JsonArray results = DeprecatedQueryAPI.getResults(ingredients, 1);
        assertNotEquals(results, new JsonArray());
        JsonObject recipe = results.get(0).getAsJsonObject();
        JsonObject recipeInfo = DeprecatedQueryAPI.getRecipeInformation(recipe.get("id").getAsString());
        assertNotEquals(recipeInfo.get("instructions").getAsString(), "");

    }

    @Test
    public void testProcessAllergy(){
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("egg");
        ArrayList<String> allergy = new ArrayList<>();
        allergy.add("date");
        allergy.add("rice");
        allergy.add("chocolate");
        JsonArray results = DeprecatedQueryAPI.getResults(ingredients, 5);
        System.out.println(results);
        System.out.println(allergy);
        JsonArray processed_results = process_allergy.processAllergies(results, allergy);
        System.out.println(processed_results);
        assertNotEquals(results, new JsonArray());

        JsonObject recipe = results.get(0).getAsJsonObject();
        JsonObject recipeInfo = DeprecatedQueryAPI.getRecipeInformation(recipe.get("id").getAsString());
        assertNotEquals(recipeInfo.get("instructions").getAsString(), "");

    }

    @Test
    public void testAPIKeyThrowsFileException(){
        try {
            DeprecatedQueryAPI.getAPIKey("qfiqpf.txt");
            fail("Expected filenotfound but did not get one.");
        }
        catch (FileNotFoundException e) {
            //caught the exception
        } catch (IOException e) {
            fail("Expected Filenotfound but got IO exception instead");
        }
    }

    @Test
    public void testAPIKeyThrowsIOException(){
        try {
            DeprecatedQueryAPI.getAPIKey("EmptyAPITest.txt");
            fail("Expected IOException but did not get one.");
        }
        catch (IOException e) {
            //caught the exception
        }
    }

    @Test
    public void testRecipeInfoFailed() {
        assertEquals(new JsonObject(), DeprecatedQueryAPI.getRecipeInformation("1510110715717-1"));
    }
}
