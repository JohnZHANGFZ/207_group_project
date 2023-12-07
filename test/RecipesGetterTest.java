import com.google.gson.JsonArray;
import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_result.ResultState;
import interface_adapter.recipe_result.ResultViewModel;
import interface_adapter.recipes_getter.GetRecipesController;
import interface_adapter.recipes_getter.GetRecipesPresenter;
import interface_adapter.recipes_getter.GetRecipesState;
import interface_adapter.recipes_getter.GetRecipesViewModel;
import org.junit.Test;
import search_recipe.DeprecatedQueryAPI;
import search_recipe.QueryAPI;

import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import use_case.recipes_getter.*;

import javax.xml.transform.Result;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class RecipesGetterTest {
    QueryAPI queryAPI = new QueryAPI();
    GetRecipesViewModel getRecipesViewModel = new GetRecipesViewModel("tester");
    ResultViewModel resultViewModel = new ResultViewModel("testing");
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    GetRecipesPresenter getRecipesPresenter = new GetRecipesPresenter(getRecipesViewModel, resultViewModel, viewManagerModel);
    GetRecipeInteractor getRecipeInteractor = new GetRecipeInteractor(queryAPI, getRecipesPresenter);

    @Test
    public void testRecipesRuns(){
        int number = 20;
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("egg");
        ingredients.add("tomatoes");
        GetRecipeInputData getRecipeInputData = new GetRecipeInputData(ingredients, number);
        getRecipeInteractor.execute(getRecipeInputData);

    }

    @Test
    public void testRecipesFailsNumber() {
        int number = 200;
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("egg");
        ingredients.add("tomatoes");
        GetRecipeInputData getRecipeInputData = new GetRecipeInputData(ingredients, number);
        getRecipeInteractor.execute(getRecipeInputData);
    }

    @Test
    public void testRecipesFailsIngredients() {
        int number = 20;
        ArrayList<String> ingredients = new ArrayList<>();
        GetRecipeInputData getRecipeInputData = new GetRecipeInputData(ingredients, number);
        getRecipeInteractor.execute(getRecipeInputData);
    }

    @Test
    public void testGetRecipesViewModel() {
        GetRecipesState getRecipesState = new GetRecipesState();
        GetRecipesState getRecipesState1 = new GetRecipesState(getRecipesState);
        assertNull(getRecipesState1.getRecipes());
        getRecipesState1.setRecipes(new JsonArray());
        assertEquals(new JsonArray(), getRecipesState1.getRecipes());
        getRecipesViewModel.setState(getRecipesState1);
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

    @Test
    public void resultStateTests() {
        ResultState resultState = new ResultState();
        ResultState resultState1 = new ResultState(resultState);
        assertNull(resultState1.getRecipes());
        resultState1.setRecipes(new JsonArray());
        assertEquals(new JsonArray(), resultState1.getRecipes());
        resultState1.setGetRecipeError("this error is a test");
    }

    @Test
    public void testMainRuns() {
        QueryAPI.main(new String[]{});
    }

    @Test
    public void propertyChange() {
        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        resultViewModel.addPropertyChangeListener(propertyChangeListener);
        getRecipesViewModel.addPropertyChangeListener(propertyChangeListener);
    }

    @Test
    public void controllerTest() {
        GetRecipeInputBoundary getRecipeInputBoundary = mock(GetRecipeInputBoundary.class);
        GetRecipesController getRecipesController = new GetRecipesController(getRecipeInputBoundary);
        getRecipesController.execute(new ArrayList<>(), 1);
    }
}


