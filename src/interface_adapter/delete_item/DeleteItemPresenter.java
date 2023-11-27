package interface_adapter.delete_item;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_item.AddItemViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.collection.delete_item.DeleteItemOutputBoundary;
import use_case.collection.delete_item.DeleteItemOutputData;

public class DeleteItemPresenter implements DeleteItemOutputBoundary {

    private final AddItemViewModel addItemViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private ViewManagerModel viewManagerModel;

    public DeleteItemPresenter(AddItemViewModel addItemViewModel, LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel) {
        this.addItemViewModel = addItemViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareFailView(String error) {

    }

    @Override
    public void prepareSuccessView(DeleteItemOutputData items) {

    }
}
