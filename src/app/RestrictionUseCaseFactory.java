package app;

import data_access.FileUserDataAccessObject;
import entity.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_inventory.AddInventoryController;
import interface_adapter.add_inventory.AddInventoryPresenter;
import interface_adapter.add_inventory.AddInventoryViewModel;
import interface_adapter.delete_item.DeleteItemController;
import interface_adapter.delete_item.DeleteInventoryPresenter;
import interface_adapter.delete_item.DeleteItemViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.restriction.RestrictionViewModel;
import use_case.add_inventory.AddInventoryDataAccessInterface;
import use_case.add_inventory.AddInventoryInputBoundary;
import use_case.add_inventory.AddInventoryInteractor;
import use_case.delete_inventory.DeleteInventoryDataAccessInterface;
import use_case.delete_inventory.DeleteInventoryInputBoundary;
import use_case.delete_inventory.DeleteInventoryInteractor;
import view.RestrictionView;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class RestrictionUseCaseFactory {

    /** Prevent instantiation. */
    private RestrictionUseCaseFactory() {}

    public static RestrictionView create(ViewManagerModel viewManagerModel,
                                       AddInventoryViewModel addInventoryViewModel,
                                       LoggedInViewModel loggedInViewModel,
                                       DeleteItemViewModel deleteItemViewModel,
                                       RestrictionViewModel restrictionViewModel,
                                       FileUserDataAccessObject userDataAccessObject) {

        try {
            IngredientFactory ingredientFactory = new CommonIngredientFactory();
            // CollectionFactory inventoryFactory = new CommonInventoryFactory();
            CommonRestrictionFactory restrictionFactory = new CommonRestrictionFactory();
            CommonRestriction restriction = restrictionFactory.create(new ArrayList<String>());
            AddInventoryController addInventoryController = createAddItemUseCase(viewManagerModel, addInventoryViewModel,
                    loggedInViewModel, userDataAccessObject, ingredientFactory);

            DeleteItemController deleteItemController = createDeleteItemUseCase(viewManagerModel,
                    deleteItemViewModel, loggedInViewModel, userDataAccessObject, ingredientFactory);

            return new RestrictionView(restrictionViewModel, addInventoryViewModel, addInventoryController,
                    deleteItemViewModel, deleteItemController);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open inventory data file.");
        }

        return null;
    }

    private static AddInventoryController createAddItemUseCase(
            ViewManagerModel viewManagerModel,
            AddInventoryViewModel addInventoryViewModel,
            LoggedInViewModel loggedInViewModel,
            AddInventoryDataAccessInterface addItemDataAccessObject,
            IngredientFactory ingredientFactory) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        AddInventoryPresenter addInventoryPresenter = new AddInventoryPresenter(addInventoryViewModel, loggedInViewModel);

        AddInventoryInputBoundary addItemInteractor = new AddInventoryInteractor(
                addItemDataAccessObject, addInventoryPresenter, ingredientFactory);

        return new AddInventoryController(addItemInteractor);
    }

    private static DeleteItemController createDeleteItemUseCase(
            ViewManagerModel viewManagerModel,
            DeleteItemViewModel deleteItemViewModel,
            LoggedInViewModel loggedInViewModel,
            DeleteInventoryDataAccessInterface deleteItemDataAccessObject,
            IngredientFactory ingredientFactory) throws IOException {

        DeleteInventoryPresenter deleteItemPresenter = new DeleteInventoryPresenter(deleteItemViewModel,
                loggedInViewModel, viewManagerModel);

        DeleteInventoryInputBoundary deleteItemInteractor = new DeleteInventoryInteractor(
                deleteItemDataAccessObject, deleteItemPresenter, ingredientFactory);

        return new DeleteItemController(deleteItemInteractor);
    }
}
