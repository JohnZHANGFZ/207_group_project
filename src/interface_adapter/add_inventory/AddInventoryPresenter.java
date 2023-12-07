package interface_adapter.add_inventory;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.add_inventory.AddItemOutputBoundary;

public class AddInventoryPresenter implements AddItemOutputBoundary {

    private final AddInventoryViewModel addInventoryViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private ViewManagerModel viewManagerModel;

    public AddInventoryPresenter(AddInventoryViewModel addInventoryViewModel, LoggedInViewModel loggedInViewModel) {
        this.addInventoryViewModel = addInventoryViewModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView() {
        //Stay in current view
        AddInventoryState addInventoryState = addInventoryViewModel.getState();
        this.addInventoryViewModel.setState(addInventoryState);
        this.addInventoryViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(addInventoryViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String error) {
        AddInventoryState addInventoryState = addInventoryViewModel.getState();
        addInventoryState.setAddItemError(error);
        addInventoryViewModel.firePropertyChanged();
    }
}
