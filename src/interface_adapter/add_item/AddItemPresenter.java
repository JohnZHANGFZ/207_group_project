package interface_adapter.add_item;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.collection.add_item.AddItemOutputBoundary;

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
        //switch to LoggedIn view
        LoggedInState loggedInState = loggedInViewModel.getState();
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String error) {
        AddItemState addItemState = addItemViewModel.getState();
        addItemState.setAddItemError(error);
        addItemViewModel.firePropertyChanged();
    }
}
