package app;

import data_access.FileUserDataAccessObject;
import entity.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_item.AddItemController;
import interface_adapter.add_item.AddItemPresenter;
import interface_adapter.add_item.AddItemViewModel;
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
                                       AddItemViewModel addItemViewModel,
                                       LoggedInViewModel loggedInViewModel,
                                       DeleteItemViewModel deleteItemViewModel,
                                       RestrictionViewModel restrictionViewModel,
                                       FileUserDataAccessObject userDataAccessObject) {

        try {
            IngredientFactory ingredientFactory = new CommonIngredientFactory();
            // CollectionFactory inventoryFactory = new CommonInventoryFactory();
            CommonRestrictionFactory restrictionFactory = new CommonRestrictionFactory();
            CommonRestriction restriction = restrictionFactory.create(new ArrayList<String>());
            AddItemController addItemController = createAddItemUseCase(viewManagerModel, addItemViewModel,
                    loggedInViewModel, userDataAccessObject, ingredientFactory);

            DeleteItemController deleteItemController = createDeleteItemUseCase(viewManagerModel,
                    deleteItemViewModel, loggedInViewModel, userDataAccessObject, ingredientFactory);

            return new RestrictionView(restrictionViewModel, addItemViewModel,addItemController,
                    deleteItemViewModel, deleteItemController);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open inventory data file.");
        }

        return null;
    }

    private static AddItemController createAddItemUseCase(
            ViewManagerModel viewManagerModel,
            AddItemViewModel addItemViewModel,
            LoggedInViewModel loggedInViewModel,
            AddInventoryDataAccessInterface addItemDataAccessObject,
            IngredientFactory ingredientFactory) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        AddItemPresenter addItemPresenter = new AddItemPresenter(addItemViewModel, loggedInViewModel);

        AddInventoryInputBoundary addItemInteractor = new AddInventoryInteractor(
                addItemDataAccessObject, addItemPresenter, ingredientFactory);

        return new AddItemController(addItemInteractor);
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
