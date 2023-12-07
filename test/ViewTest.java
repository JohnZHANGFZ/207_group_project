import interface_adapter.ViewManagerModel;
import interface_adapter.inventory.InventoryController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.recipe_info_result.ResultInfoViewModel;
import interface_adapter.recipe_information_getter.RecipeInfoController;
import interface_adapter.recipe_information_getter.RecipeInfoViewModel;
import interface_adapter.recipe_result.ResultViewModel;
import interface_adapter.recipes_getter.GetRecipesController;
import interface_adapter.recipes_getter.GetRecipesViewModel;
import interface_adapter.restriction.RestrictionController;
import interface_adapter.return_home.ReturnController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;
import org.junit.Test;
import use_case.edit_inventory.EditInventoryInputBoundary;
import use_case.edit_restriction.EditRestrictionInputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutOutputBoundary;
import use_case.recipe_information_getter.RecipeInfoInputBoundary;
import use_case.recipes_getter.GetRecipeInputBoundary;
import use_case.return_home.ReturnInputBoundary;
import use_case.signup.SignupInputBoundary;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ViewTest {

    @Test
    public void testDetailsView() {
        ResultInfoViewModel resultInfoViewModel = new ResultInfoViewModel("testing");
        DetailsView detailsView = new DetailsView(resultInfoViewModel);
        ActionEvent actionEvent = mock(ActionEvent.class);
        detailsView.actionPerformed(actionEvent);
    }

    @Test
    public void viewManagerTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.getActiveView();
        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        viewManagerModel.addPropertyChangeListener(propertyChangeListener);
    }

    @Test
    public void loggedInViewTest() {
        LogoutInputBoundary logoutInputBoundary = mock(LogoutInputBoundary.class);
        EditInventoryInputBoundary editInventoryInputBoundary = mock(EditInventoryInputBoundary.class);
        EditRestrictionInputBoundary editRestrictionInputBoundary = mock(EditRestrictionInputBoundary.class);
        GetRecipeInputBoundary getRecipeInputBoundary = mock(GetRecipeInputBoundary.class);
        LoggedInView loggedInView = new LoggedInView(new LoggedInViewModel("fqf"), new LogoutController(logoutInputBoundary),
                new InventoryController(editInventoryInputBoundary), new RestrictionController(editRestrictionInputBoundary),
                new GetRecipesController(getRecipeInputBoundary));

        ActionEvent actionEvent = mock(ActionEvent.class);
        PropertyChangeEvent propertyChangeEvent = mock(PropertyChangeEvent.class);

        loggedInView.actionPerformed(actionEvent);
        loggedInView.propertyChange(propertyChangeEvent);

    }

    @Test
    public void logInViewTest() {
        LoginViewModel loginViewModel = new LoginViewModel("hfhqpf");
        LoginInputBoundary loginInputBoundary = mock(LoginInputBoundary.class);
        LoginController loginController = new LoginController(loginInputBoundary);
        LoginView loginView = new LoginView(loginViewModel, loginController);

        ActionEvent actionEvent = mock(ActionEvent.class);
        PropertyChangeEvent propertyChangeEvent = mock(PropertyChangeEvent.class);

        loginView.actionPerformed(actionEvent);
        loginView.propertyChange(propertyChangeEvent);
    }

    @Test
    public void resultViewTest() {
        RecipeInfoInputBoundary recipeInfoInputBoundary = mock(RecipeInfoInputBoundary.class);
        ReturnInputBoundary returnInputBoundary = mock(ReturnInputBoundary.class);
        GetRecipesViewModel getRecipesViewModel = new GetRecipesViewModel("fqfw");
        RecipeInfoViewModel recipeInfoViewModel = new RecipeInfoViewModel("fqwfq");
        RecipeInfoController recipeInfoController = new RecipeInfoController(recipeInfoInputBoundary);
        ReturnController returnController = new ReturnController(returnInputBoundary);

        ResultView resultView = new ResultView(getRecipesViewModel, recipeInfoViewModel, recipeInfoController, returnController);
        ActionEvent actionEvent = mock(ActionEvent.class);
        PropertyChangeEvent propertyChangeEvent = mock(PropertyChangeEvent.class);

        resultView.actionPerformed(actionEvent);
        resultView.propertyChange(propertyChangeEvent);
    }

    @Test
    public void signUpView() {
        SignupInputBoundary signupInputBoundary = mock(SignupInputBoundary.class);
        ReturnInputBoundary returnInputBoundary = mock(ReturnInputBoundary.class);

        SignupController signupController = new SignupController(signupInputBoundary);
        SignupViewModel signupViewModel = new SignupViewModel();
        ReturnController returnController = new ReturnController(returnInputBoundary);
        SignupView signupView = new SignupView(signupController, signupViewModel, returnController);

        ActionEvent actionEvent = mock(ActionEvent.class);
        PropertyChangeEvent propertyChangeEvent = mock(PropertyChangeEvent.class);

        signupView.actionPerformed(actionEvent);
        signupView.propertyChange(propertyChangeEvent);
    }

    @Test
    public void viewManager2Test() {
        ViewManager viewManager = new ViewManager(new JPanel(), new CardLayout(), new ViewManagerModel());
        PropertyChangeEvent propertyChangeEvent = mock(PropertyChangeEvent.class);
        viewManager.propertyChange(propertyChangeEvent);
    }

}
