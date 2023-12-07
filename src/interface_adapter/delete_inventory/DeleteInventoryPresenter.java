package interface_adapter.delete_inventory;

import interface_adapter.ViewManagerModel;
import interface_adapter.inventory.InventoryState;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.delete_inventory.DeleteInventoryOutputBoundary;
import use_case.delete_inventory.DeleteInventoryOutputData;

public class DeleteInventoryPresenter implements DeleteInventoryOutputBoundary {

    private final InventoryViewModel inventoryViewModel;

    private ViewManagerModel viewManagerModel;

    public DeleteInventoryPresenter(InventoryViewModel inventoryViewModel, ViewManagerModel viewManagerModel) {
        this.inventoryViewModel = inventoryViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareFailView(String error) {
        InventoryState inventoryState = inventoryViewModel.getState();
        inventoryState.setInventoryError(error);
        inventoryViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(DeleteInventoryOutputData items) {
        //Stay in Current View
        // DeleteInventoryState deleteInventoryState = deleteInventoryViewModel.getState();
        InventoryState inventoryState = inventoryViewModel.getState();
        this.inventoryViewModel.setState(inventoryState);
        this.inventoryViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(inventoryViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
