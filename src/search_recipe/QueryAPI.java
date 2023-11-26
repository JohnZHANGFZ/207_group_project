package search_recipe;
import com.google.gson.*;
import use_case.recipes_getter.GetRecipeDataAccessInterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class QueryAPI implements GetRecipeDataAccessInterface {
    /*
    This calls the API for recipes with the passed in arraylist of ingredients and the number of results you want to return
     */
    public JsonArray getResults(ArrayList<String> ingredients, int number) {
        try {
            // Spoonacular
            String api_key = getAPIKey("APIKey.txt");
            String uri_string = createRequest(ingredients, number);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri_string))
                    .header("X-RapidAPI-Key", api_key)
                    .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return ParseString(response.body());
        }
        catch (Exception e) {
            System.out.println("API query failed");
            return new JsonArray();
        }
    }

    /*
    This calls the API endpoint for recipe information for the recipe object specified
     */
    public static JsonObject getRecipeInformation(JsonObject recipe){
        String id = recipe.get("id").getAsString();
        try {
            // Spoonacular
            String api_key = getAPIKey("APIKey.txt");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(String.format("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/%s/information", id)))
                    .header("X-RapidAPI-Key", api_key)
                    .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return ParseStringToObject(response.body());
        }
        catch (Exception e) {
            System.out.println("API query failed");
            return new JsonObject();
        }
    }

    /*
    overloading to make it easier to use
    This calls the API endpoint for recipe information for the string id specified
     */
    public static JsonObject getRecipeInformation(String id){
        try {
            // Spoonacular
            String api_key = getAPIKey("APIKey.txt");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(String.format("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/%s/information", id)))
                    .header("X-RapidAPI-Key", api_key)
                    .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return ParseStringToObject(response.body());
        }
        catch (Exception e) {
            System.out.println("API query failed");
            return new JsonObject();
        }
    }

    /*
    helper method

    This creates the string for the request uri
     */
    public static String createRequest(ArrayList<String> ingredients, int number) {
        String uri = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?ingredients=";
        uri += ingredients.get(0);
        if (ingredients.size() > 1) {
            for (int i = 1; i < ingredients.size(); i++) {
                uri += "%2C" + ingredients.get(i);
            }
        }
        uri += "&ranking=2&ignorePantry=true&number=";
        uri += number;
        return uri;
    }

    /*
    helper method

    This parses the string that is returned and converts it into a jsonarray
     */
    public static JsonArray ParseString(String response) {
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
        //System.out.println(jsonArray);
        return jsonArray;

    }

    /*
    helper method

    This parses the string that is returned and converts it into a json object
 */
    public static JsonObject ParseStringToObject(String response) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(response);
        //System.out.println(jsonArray);
        return jsonObject;

    }

    /*
    helper method

    Returns the api key given in a file stored in the root
     */
    public static String getAPIKey(String filename) throws IOException {
        String APIKey = "";
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(filename));
            APIKey = reader.readLine();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Filename specified not found");
            throw new FileNotFoundException();
        }
        if (APIKey == null) {
            System.out.println("No API key found in file specified");
            throw new IOException();
        }
        return APIKey;
    }

    public static void main(String[] args) {
//        ArrayList<String> ingredients = new ArrayList<>(); //this is creating an arraylist of ingredients
//        ingredients.add("egg"); //adding in an example ingredient
//        int number = 2; //telling the api to return 2 recipes
//        JsonArray recipes = getResults(ingredients, number); //an array of json objects which are recipes
////        for (int i = 0; i < recipes.size(); i++) {
////            JsonObject recipe = recipes.get(i).getAsJsonObject();
////            String id = recipe.get("id").getAsString();
////            String title = recipe.get("title").getAsString();
////            String image = recipe.get("image").getAsString();
////            System.out.println(id + ", "+ title + ", " + image);
////        }
//        JsonObject recipe = recipes.get(0).getAsJsonObject(); //getting the json recipe object at a specific index
//        System.out.println(recipe);
//        JsonObject recipeInfo = getRecipeInformation(recipe.get("id").getAsString());
//        System.out.println(recipeInfo.get("summary"));
//        System.out.println(recipeInfo.get("instructions"));

    }
}

