package interface_adapter.inventory;

import interface_adapter.ViewManagerModel;
import use_case.edit_inventory.EditInventoryOutputBoundary;

public class InventoryPresenter implements EditInventoryOutputBoundary {

    private final InventoryViewModel inventoryViewModel;
    private ViewManagerModel viewManagerModel;

    public InventoryPresenter(ViewManagerModel viewManagerModel, InventoryViewModel inventoryViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.inventoryViewModel = inventoryViewModel;
    }

    @Override
    public void prepareSuccessView() {
        this.viewManagerModel.setActiveView(inventoryViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
