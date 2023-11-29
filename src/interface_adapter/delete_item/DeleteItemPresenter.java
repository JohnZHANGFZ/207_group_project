package interface_adapter.delete_item;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.collection.delete_item.DeleteItemOutputBoundary;
import use_case.collection.delete_item.DeleteItemOutputData;

public class DeleteItemPresenter implements DeleteItemOutputBoundary {

    private final DeleteItemViewModel deleteItemViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private ViewManagerModel viewManagerModel;

    public DeleteItemPresenter(DeleteItemViewModel deleteItemViewModel, LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel) {
        this.deleteItemViewModel = deleteItemViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareFailView(String error) {
        DeleteItemState deleteItemState = deleteItemViewModel.getState();
        deleteItemState.setDeleteItemError(error);
        deleteItemViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(DeleteItemOutputData items) {
        //Stay in Current View
        DeleteItemState deleteItemState = deleteItemViewModel.getState();
        this.deleteItemViewModel.setState(deleteItemState);
        this.deleteItemViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(deleteItemViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
