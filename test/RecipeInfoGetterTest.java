import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_info_result.ResultInfoState;
import interface_adapter.recipe_info_result.ResultInfoViewModel;
import interface_adapter.recipe_information_getter.RecipeInfoController;
import interface_adapter.recipe_information_getter.RecipeInfoPresenter;
import interface_adapter.recipe_information_getter.RecipeInfoState;
import interface_adapter.recipe_information_getter.RecipeInfoViewModel;
import interface_adapter.recipe_result.ResultState;
import interface_adapter.recipe_result.ResultViewModel;
import interface_adapter.recipes_getter.GetRecipesPresenter;
import interface_adapter.recipes_getter.GetRecipesState;
import interface_adapter.recipes_getter.GetRecipesViewModel;
import org.junit.Test;
import search_recipe.DeprecatedQueryAPI;
import search_recipe.QueryAPI;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import use_case.recipe_information_getter.RecipeInfoInputBoundary;
import use_case.recipe_information_getter.RecipeInfoInputData;
import use_case.recipe_information_getter.RecipeInfoInteractor;
import use_case.recipes_getter.*;

import javax.xml.transform.Result;

import static org.junit.Assert.*;

public class RecipeInfoGetterTest {
    QueryAPI queryAPI = new QueryAPI();
    RecipeInfoViewModel recipeInfoViewModel = new RecipeInfoViewModel("tester");
    ResultInfoViewModel resultViewModel = new ResultInfoViewModel("testing");
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    RecipeInfoPresenter recipeInfoPresenter = new RecipeInfoPresenter(recipeInfoViewModel, resultViewModel, viewManagerModel);
    RecipeInfoInteractor recipeInfoInteractor = new RecipeInfoInteractor(queryAPI, recipeInfoPresenter);

    @Test
    public void testRecipeInfoRuns() {
        RecipeInfoInputData recipeInfoInputData = new RecipeInfoInputData("675955");
        recipeInfoInteractor.execute(recipeInfoInputData);

    }

    @Test
    public void testRecipeInfoFails() {
        RecipeInfoInputData recipeInfoInputData = new RecipeInfoInputData("uboqbq");
        recipeInfoInteractor.execute(recipeInfoInputData);
    }

    @Test
    public void testRecipeInfoViewModel() {
        RecipeInfoState recipeInfoState = new RecipeInfoState();
        RecipeInfoState recipeInfoState1 = new RecipeInfoState(recipeInfoState);
        assertNull(recipeInfoState1.getRecipe());
        recipeInfoState1.setRecipe(new JsonObject());
        recipeInfoState1.getID();
        assertEquals(new JsonObject(), recipeInfoState1.getRecipe());
        recipeInfoViewModel.setState(recipeInfoState1);
    }

    @Test
    public void resultStateTests() {
        ResultInfoState resultInfoState = new ResultInfoState();
        ResultInfoState resultInfoState1 = new ResultInfoState(resultInfoState);
        assertNull(resultInfoState1.getRecipe());
        resultInfoState1.setRecipe(new JsonObject());
        assertEquals(new JsonObject(), resultInfoState1.getRecipe());
        resultInfoState1.setResultError("this error is a test");
    }

    @Test
    public void propertychange() {
        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        resultViewModel.addPropertyChangeListener(propertyChangeListener);
        recipeInfoViewModel.addPropertyChangeListener(propertyChangeListener);
    }

    @Test
    public void controller() {
        RecipeInfoInputBoundary recipeInfoInputBoundary = mock(RecipeInfoInputBoundary.class);
        RecipeInfoController recipeInfoController = new RecipeInfoController(recipeInfoInputBoundary);
        recipeInfoController.execute("147");
    }

    @Test
    public void apiKeyTest() {
        try {
            QueryAPI.getAPIKey("hqpfpfq");
        }
        catch (IOException e) {
        }
    }
}

