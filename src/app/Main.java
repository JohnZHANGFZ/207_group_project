package app;

import data_access.FileUserDataAccessObject;
import entity.CommonInventoryFactory;
import entity.CommonRestrictionFactory;
import entity.CommonUserFactory;
import interface_adapter.ReturnToPreviousView.ReturnState;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_item.AddItemViewModel;
import interface_adapter.delete_item.DeleteItemViewModel;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.recipe_info_result.ResultInfoViewModel;
import interface_adapter.recipe_information_getter.RecipeInfoViewModel;
import interface_adapter.recipe_result.ResultViewModel;
import interface_adapter.recipes_getter.GetRecipesViewModel;
import interface_adapter.restriction.RestrictionViewModel;
import interface_adapter.signup.SignupViewModel;
import search_recipe.QueryAPI;
import use_case.ReturnToPreviousView.ReturnInteractor;
import use_case.recipes_getter.GetRecipeDataAccessInterface;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
public class Main {

    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ReturnState returnState = new ReturnState();
        ReturnInteractor returnInteractor = new ReturnInteractor(returnState);
        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ViewManager viewManager = new ViewManager(views, cardLayout, viewManagerModel);
        returnInteractor.addObserver(viewManager);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel("Login");
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel("Logged In");
        SignupViewModel signupViewModel = new SignupViewModel();
        AddItemViewModel addItemViewModel = new AddItemViewModel("Add Item");
        DeleteItemViewModel deleteItemViewModel = new DeleteItemViewModel("Delete Item");
        InventoryViewModel inventoryViewModel = new InventoryViewModel("Inventory");
        RecipeInfoViewModel recipeInfoViewModel = new RecipeInfoViewModel("Recipe Info");
        ResultViewModel resultViewModel = new ResultViewModel("Result");
        GetRecipesViewModel getRecipesViewModel = new GetRecipesViewModel("Get Recipes");
        RestrictionViewModel restrictionViewModel = new RestrictionViewModel("Restriction");
        ResultInfoViewModel resultInfoViewModel = new ResultInfoViewModel("Result Info");
        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory(),
                    new CommonInventoryFactory(), new CommonRestrictionFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GetRecipeDataAccessInterface getRecipeDataAccessInterface = new QueryAPI();

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel,
                loggedInViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = LoggedInViewFactory.create(viewManagerModel,loggedInViewModel, loginViewModel,
                inventoryViewModel, restrictionViewModel, getRecipesViewModel, resultViewModel,
                getRecipeDataAccessInterface);
        views.add(loggedInView, loggedInView.viewName);

        InventoryView inventoryView = InventoryUseCaseFactory.create(inventoryViewModel, viewManagerModel,
                addItemViewModel, loggedInViewModel, deleteItemViewModel, userDataAccessObject);
        views.add(inventoryView, inventoryView.viewName);

        // TODO: detailsView waited to implement
//        DetailsView detailsView = new DetailsView();
//        views.add(detailsView, detailsView.viewName);

        RestrictionView restrictionView = RestrictionUseCaseFactory.create(viewManagerModel,
                addItemViewModel, loggedInViewModel, deleteItemViewModel, restrictionViewModel, userDataAccessObject);
        views.add(restrictionView, restrictionView.viewName);

        ResultView resultView = ResultViewFactory.create(getRecipesViewModel, recipeInfoViewModel,
                resultInfoViewModel, viewManagerModel);
        views.add(resultView, resultView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}