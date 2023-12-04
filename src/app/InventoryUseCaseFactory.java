package app;

import entity.*;

import interface_adapter.ViewManagerModel;
import interface_adapter.inventory.InventoryViewModel;

import interface_adapter.add_item.AddItemController;
import interface_adapter.add_item.AddItemPresenter;
import interface_adapter.add_item.AddItemViewModel;

import interface_adapter.delete_item.DeleteItemController;
import interface_adapter.delete_item.DeleteItemPresenter;
import interface_adapter.delete_item.DeleteItemViewModel;

import interface_adapter.logged_in.LoggedInViewModel;
import use_case.collection.add_item.AddItemInputBoundary;
import use_case.collection.add_item.AddItemInteractor;
import use_case.collection.add_item.AddItemDataAccessInterface;

import use_case.collection.delete_item.DeleteItemInputBoundary;
import use_case.collection.delete_item.DeleteItemInteractor;
import use_case.collection.delete_item.DeleteItemDataAccessInterface;

import view.InventoryView;
import view.ViewManager;

import javax.swing.*;
import java.io.IOException;

public class InventoryUseCaseFactory {

    /** Prevent instantiation. */
    private InventoryUseCaseFactory() {}

    //TODO: InventoryDataAccessInterface need to be implemented later
    public static InventoryView create(InventoryViewModel inventoryViewModel,
                                       ViewManagerModel viewManagerModel,
                                       AddItemViewModel addItemViewModel,
                                       LoggedInViewModel loggedInViewModel,
                                       DeleteItemViewModel deleteItemViewModel,
                                       InventoryDataAccessInterface IventoryDataAccessObject) {

            try {
                IngredientFactory ingredientFactory = new CommonIngredientFactory();
                CollectionFactory inventoryFactory = new CommonInventoryFactory();
                AddItemController addItemController = createAddItemUseCase(viewManagerModel, addItemViewModel,
                        loggedInViewModel, InventoryDataAccessObject, ingredientFactory);

                DeleteItemController deleteItemController = createDeleteItemUseCase(viewManagerModel,
                        deleteItemViewModel, loggedInViewModel, InventoryDataAccessObject, ingredientFactory);

                return new InventoryView(inventoryViewModel, addItemViewModel,addItemController,
                        deleteItemViewModel, deleteItemController, inventoryFactory);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Could not open inventory data file.");
            }

            return null;
    }

    public static AddItemController createAddItemUseCase(
            ViewManagerModel viewManagerModel,
            AddItemViewModel addItemViewModel,
            LoggedInViewModel loggedInViewModel,
            AddItemDataAccessInterface addItemDataAccessObject,
            IngredientFactory ingredientFactory) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        AddItemPresenter addItemPresenter = new AddItemPresenter(addItemViewModel, loggedInViewModel);

        AddItemInputBoundary addItemInteractor = new AddItemInteractor(
                addItemDataAccessObject, addItemPresenter, ingredientFactory);

        return new AddItemController(addItemInteractor);
    }

    public static DeleteItemController createDeleteItemUseCase(
            ViewManagerModel viewManagerModel,
            DeleteItemViewModel deleteItemViewModel,
            LoggedInViewModel loggedInViewModel,
            DeleteItemDataAccessInterface deleteItemDataAccessObject,
            IngredientFactory ingredientFactory) throws IOException {

        DeleteItemPresenter deleteItemPresenter = new DeleteItemPresenter(deleteItemViewModel,
                loggedInViewModel, viewManagerModel);

        DeleteItemInputBoundary deleteItemInteractor = new DeleteItemInteractor(
                deleteItemDataAccessObject, deleteItemPresenter, ingredientFactory);

        return new DeleteItemController(deleteItemInteractor);
    }
}
