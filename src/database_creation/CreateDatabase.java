package database_creation;
import search_recipe.DeprecatedQueryAPI;
import search_recipe.QueryAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;

/*
This code solely exists to create the database and will never be run in the program
 */

public class CreateDatabase {
    final ArrayList<String> ingredients;
    final int number;

    public CreateDatabase(ArrayList<String> ingredients, int number) {
        this.ingredients = ingredients;
        this.number = number;
    }

    /*
    Adds more recipes to the database
     */
    public void addToCsv(String filepath) throws Exception {
        JsonArray recipes = DeprecatedQueryAPI.getResults(this.ingredients, this.number);
        //String filePath = "src/data_access/resources/database.csv";
        File file = new File(filepath);

        boolean append = file.length() > 0; //checks to see if file is empty

        // create FileWriter object with file as parameter
        FileWriter outputFile = new FileWriter(file, append);

        // create CSVWriter object filewriter object as parameter
        CSVWriter writer = new CSVWriter(outputFile);

        if (!append) {
            // adding header to csv
            String[] header = {"id", "title", "image", "ingredients"};
            writer.writeNext(header);
        }

        ArrayList<Integer> records = loadId(filepath);
        // add data to csv
        for (int i = 0; i < recipes.size(); i++) {
            JsonObject recipe = recipes.get(i).getAsJsonObject();
            String id = recipe.get("id").getAsString();
            String title = recipe.get("title").getAsString();
            String image = recipe.get("image").getAsString();
            String ingredients = String.valueOf(getIngredients(recipe));
            String[] data = {id, title, image , String.valueOf(ingredients)};
            if (!records.contains(Integer.valueOf(id))) {
                writer.writeNext(data);
            }
        }
        // closing writer connection
        writer.close();
    }

    /*
    Returns an arraylist of ID's of recipes inside the .csv
     */
    public static ArrayList<Integer> loadId(String fileName) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            String DELIMITER = ",";
            ArrayList<Integer> records = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                records.add(Integer.valueOf(values[0].replace("\"", "")));
            }
            return records;
        }
        catch (IOException e){
            throw new IOException();
        }

    }
    /*
    Converts a json recipe object into a list of ingredients so that we can store it in the database
     */
    public ArrayList<String> getIngredients(JsonObject recipe) {
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

    public static void main(String[] args) throws Exception {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("peanut");
        int number = 200;
        CreateDatabase database = new CreateDatabase(ingredients, number);
        String filepath = "src/data_access/resources/database.csv";
        database.addToCsv(filepath);
    }
}
