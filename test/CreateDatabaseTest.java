import database_creation.CreateDatabase;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CreateDatabaseTest {

    @Test
    public void testMainRuns(){
        try {
            CreateDatabase.main(new String[]{});
        }
        catch (Exception e){
            fail("IO Exception thrown");
        }
    }

    @Test
    public void testLoadIDThrowsException(){
        try {
            CreateDatabase.loadId("qghiqpgqp.txt");
            fail("Expected IO Exception but did not get one.");
        }
        catch (Exception e){
            //exception caught
        }
    }

    @Test
    public void testaddToCsvCreatesNewFile(){
        try {
            ArrayList<String> ingredients = new ArrayList<>();
            ingredients.add("carrot");
            int number = 2;
            CreateDatabase database = new CreateDatabase(ingredients, number);
            String filepath = "egqpighephgqp.csv";
            database.addToCsv(filepath);
        }
        catch (Exception e){
            fail("Exception thrown");
        }
    }

}
