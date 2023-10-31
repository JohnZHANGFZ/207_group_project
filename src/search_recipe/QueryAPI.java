package search_recipe;

import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class QueryAPI {
    /*
    This calls the API with the passed in arraylist of ingredients and the number of results you want to return
     */
    public static JsonArray getResults(ArrayList<String> ingredients, int number) throws Exception {
        try {
            // Spoonacular
            String uri_string = createRequest(ingredients, number);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri_string))
                    .header("X-RapidAPI-Key", "44234e2dc8msh68e094b9e0960c7p1932dfjsn65fa819dc540") //may need to be hidden later
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

    public static void main(String[] args) throws Exception {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("egg");
        int number = 2;
        JsonArray recipes = getResults(ingredients, number);
        System.out.println(recipes.get(1).getAsJsonObject());
    }
}
