package interface_adapter.delete_inventory;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.delete_inventory.DeleteInventoryOutputBoundary;
import use_case.delete_inventory.DeleteInventoryOutputData;

public class DeleteInventoryPresenter implements DeleteInventoryOutputBoundary {

    private final DeleteInventoryViewModel deleteInventoryViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private ViewManagerModel viewManagerModel;

    public DeleteInventoryPresenter(DeleteInventoryViewModel deleteInventoryViewModel, LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel) {
        this.deleteInventoryViewModel = deleteInventoryViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareFailView(String error) {
        DeleteInventoryState deleteInventoryState = deleteInventoryViewModel.getState();
        deleteInventoryState.setDeleteItemError(error);
        deleteInventoryViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(DeleteInventoryOutputData items) {
        //Stay in Current View
        DeleteInventoryState deleteInventoryState = deleteInventoryViewModel.getState();
        this.deleteInventoryViewModel.setState(deleteInventoryState);
        this.deleteInventoryViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(deleteInventoryViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
