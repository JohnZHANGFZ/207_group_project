package app;

import data_access.FileUserDataAccessObject;
import entity.CommonIngredientFactory;
import entity.CommonInventory;
import entity.CommonInventoryFactory;
import entity.IngredientFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_inventory.AddInventoryController;
import interface_adapter.add_inventory.AddInventoryPresenter;
import interface_adapter.add_inventory.AddInventoryViewModel;

import interface_adapter.delete_inventory.DeleteInventoryController;
import interface_adapter.delete_inventory.DeleteInventoryPresenter;
import interface_adapter.delete_inventory.DeleteInventoryViewModel;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.return_home.ReturnController;
import use_case.add_inventory.AddInventoryDataAccessInterface;
import use_case.add_inventory.AddInventoryInputBoundary;
import use_case.add_inventory.AddInventoryInteractor;
import use_case.delete_inventory.DeleteInventoryDataAccessInterface;
import use_case.delete_inventory.DeleteInventoryInputBoundary;
import use_case.delete_inventory.DeleteInventoryInteractor;
import view.InventoryView;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryUseCaseFactory {

    /** Prevent instantiation. */
    private InventoryUseCaseFactory() {}

    //TODO: InventoryDataAccessInterface need to be implemented later
    public static InventoryView create(InventoryViewModel inventoryViewModel,
                                       ViewManagerModel viewManagerModel,
                                       AddInventoryViewModel addInventoryViewModel,
                                       LoggedInViewModel loggedInViewModel,
                                       DeleteInventoryViewModel deleteInventoryViewModel,
                                       FileUserDataAccessObject userDataAccessObject,
                                       ReturnController returnController) {

            try {
                IngredientFactory ingredientFactory = new CommonIngredientFactory();
                CommonInventory inventoryFactory = new CommonInventoryFactory().create(new ArrayList<String>());
                AddInventoryController addInventoryController = createAddItemUseCase(viewManagerModel, addInventoryViewModel,
                        loggedInViewModel, userDataAccessObject, ingredientFactory);

                DeleteInventoryController deleteInventoryController = createDeleteItemUseCase(viewManagerModel,
                        deleteInventoryViewModel, loggedInViewModel, userDataAccessObject, ingredientFactory);


                return new InventoryView(inventoryViewModel, addInventoryViewModel, addInventoryController,
                        deleteInventoryViewModel, deleteInventoryController, returnController);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Could not open inventory data file.");
            }

            return null;
    }

    public static AddInventoryController createAddItemUseCase(
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

    public static DeleteInventoryController createDeleteItemUseCase(
            ViewManagerModel viewManagerModel,
            DeleteInventoryViewModel deleteInventoryViewModel,
            LoggedInViewModel loggedInViewModel,
            DeleteInventoryDataAccessInterface deleteItemDataAccessObject,
            IngredientFactory ingredientFactory) throws IOException {

        DeleteInventoryPresenter deleteItemPresenter = new DeleteInventoryPresenter(deleteInventoryViewModel,
                viewManagerModel);

        DeleteInventoryInputBoundary deleteItemInteractor = new DeleteInventoryInteractor(
                deleteItemDataAccessObject, deleteItemPresenter, ingredientFactory);

        return new DeleteInventoryController(deleteItemInteractor);
    }
}
