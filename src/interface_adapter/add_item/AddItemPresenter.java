package interface_adapter.add_item;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.add_inventory.AddItemOutputBoundary;

public class AddItemPresenter implements AddItemOutputBoundary {

    private final AddItemViewModel addItemViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private ViewManagerModel viewManagerModel;

    public AddItemPresenter(AddItemViewModel addItemViewModel, LoggedInViewModel loggedInViewModel) {
        this.addItemViewModel = addItemViewModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView() {
        //Stay in current view
        AddItemState addItemState = addItemViewModel.getState();
        this.addItemViewModel.setState(addItemState);
        this.addItemViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(addItemViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String error) {
        AddItemState addItemState = addItemViewModel.getState();
        addItemState.setAddItemError(error);
        addItemViewModel.firePropertyChanged();
    }
}
