package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.inventory.InventoryController;
import interface_adapter.inventory.InventoryPresenter;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.recipe_result.ResultViewModel;
import interface_adapter.recipes_getter.GetRecipesController;
import interface_adapter.recipes_getter.GetRecipesPresenter;
import interface_adapter.recipes_getter.GetRecipesViewModel;
import interface_adapter.restriction.RestrictionController;
import interface_adapter.restriction.RestrictionPresenter;
import interface_adapter.restriction.RestrictionViewModel;
import use_case.edit_inventory.EditInventoryInteractor;
import use_case.edit_restriction.EditRestrictionInteractor;
import use_case.logout.LogoutInteractor;
import use_case.recipes_getter.GetRecipeDataAccessInterface;
import use_case.recipes_getter.GetRecipeInteractor;
import view.LoggedInView;

import javax.swing.*;
import java.io.IOException;

public class LoggedInViewFactory {

        /** Prevent instantiation. */
        private LoggedInViewFactory() {}
        // necessary controller: LogoutController, InventoryController, RestrictionController
        public static LoggedInView create(
                ViewManagerModel viewManagerModel,
                LoggedInViewModel loggedInViewModel,
                LoginViewModel loginViewModel,
                InventoryViewModel inventoryViewModel,
                RestrictionViewModel restrictionViewModel,
                GetRecipesViewModel getRecipesViewModel,
                ResultViewModel resultViewModel,
                GetRecipeDataAccessInterface getRecipeDataAccessObject) {
            try {
                LogoutController logoutController = createLogoutUseCase(viewManagerModel, loginViewModel);
                InventoryController inventoryController = createInventoryUseCase(viewManagerModel, inventoryViewModel);
                RestrictionController restrictionController = createRestrictionUseCase(viewManagerModel,
                        restrictionViewModel);
                GetRecipesController getRecipesController = createGetRecipesUseCase(viewManagerModel,
                        getRecipesViewModel, resultViewModel, getRecipeDataAccessObject);
                return new LoggedInView(loggedInViewModel, logoutController,
                        inventoryController, restrictionController, getRecipesController);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Could not open APIKey file.");
            }
            return null;
        }
            private static LogoutController createLogoutUseCase(ViewManagerModel viewManagerModel,
                                                            LoginViewModel loginViewModel){
            LogoutPresenter logoutPresenter = new LogoutPresenter(viewManagerModel, loginViewModel);

            LogoutInteractor logoutInteractor = new LogoutInteractor(logoutPresenter);

            return new LogoutController(logoutInteractor);

        }

        private static InventoryController createInventoryUseCase(ViewManagerModel viewManagerModel,
                                                                  InventoryViewModel inventoryViewModel){
            InventoryPresenter inventoryPresenter = new InventoryPresenter(viewManagerModel, inventoryViewModel);

            EditInventoryInteractor inventoryInteractor = new EditInventoryInteractor(inventoryPresenter);

            return new InventoryController(inventoryInteractor);
        }

        private static RestrictionController createRestrictionUseCase(ViewManagerModel viewManagerModel,
                                                                      RestrictionViewModel restrictionViewModel){
            RestrictionPresenter restrictionPresenter = new RestrictionPresenter(viewManagerModel, restrictionViewModel);

            EditRestrictionInteractor restrictionInteractor = new EditRestrictionInteractor(restrictionPresenter);

            return new RestrictionController(restrictionInteractor);

        }

        private static GetRecipesController createGetRecipesUseCase(ViewManagerModel viewManagerModel,
                                                                    GetRecipesViewModel getRecipesViewModel,
                                                                    ResultViewModel resultViewModel,
                                                                    GetRecipeDataAccessInterface getRecipeDataAccessObject) throws IOException {
            GetRecipesPresenter getRecipesPresenter = new GetRecipesPresenter(getRecipesViewModel, resultViewModel,
                    viewManagerModel);

            GetRecipeInteractor getRecipesInteractor = new GetRecipeInteractor(getRecipeDataAccessObject,
                    getRecipesPresenter);

            return new GetRecipesController(getRecipesInteractor);

        }
}
