import com.google.gson.JsonArray;
import org.junit.Test;
import search_recipe.QueryAPI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class QueryAPITest {

    @Test
    public void testMainRuns() {
        QueryAPI.main(new String[]{});
    }

    @Test
    public void testGetResultReturnsFailedRuns(){
        ArrayList<String> empty = new ArrayList<>();
        assertEquals(new JsonArray(), QueryAPI.getResults(empty, 1));
    }

    @Test
    public void testGetResultReturnsResultsRuns(){
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("egg");
        ingredients.add("apple");
        assertNotEquals(QueryAPI.getResults(ingredients, 1), new JsonArray());
    }

    @Test
    public void testAPIKeyThrowsFileException(){
        try {
            QueryAPI.getAPIKey("qfiqpf.txt");
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
            QueryAPI.getAPIKey("EmptyAPITest.txt");
            fail("Expected IOException but did not get one.");
        }
        catch (IOException e) {
            //caught the exception
        }
    }
}
