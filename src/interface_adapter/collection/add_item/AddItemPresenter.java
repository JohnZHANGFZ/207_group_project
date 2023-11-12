package interface_adapter.collection.add_item;

import interface_adapter.ViewManagerModel;
import use_case.collection.add_item.AddItemOutputBoundary;
import view.LoggedInView;

public class AddItemPresenter implements AddItemOutputBoundary {

    private final AddItemViewModel addItemViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private ViewManagerModel viewManagerModel;

    public AddItemPresenter(AddItemViewModel addItemViewModel) {
        this.addItemViewModel = addItemViewModel;
    }

    @Override
    public void prepareSuccessView() {
        //switch to LoggedIn view

    }


    @Override
    public void prepareFailView(String error) {
        AddItemState addItemState = addItemViewModel.getState();
        addItemState.setAddItemError(error);
        addItemViewModel.firePropertyChanged();
    }
}
