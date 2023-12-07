package interface_adapter.remove_dietary_restriction;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.remove_dietary_restriction.RemoveRestrictionOutputBoundary;
import use_case.remove_dietary_restriction.RemoveRestrictionOutputData;

public class RemoveRestrictionPresenter implements RemoveRestrictionOutputBoundary {

    private final RemoveRestrictionViewModel removeRestrictionViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private ViewManagerModel viewManagerModel;

    public RemoveRestrictionPresenter(RemoveRestrictionViewModel removeRestrictionViewModel, LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel) {
        this.removeRestrictionViewModel = removeRestrictionViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareFailView(String error) {
        RemoveRestrictionState removeRestrictionState = removeRestrictionViewModel.getState();
        removeRestrictionState.setRemoveRestrictionError(error);
        removeRestrictionViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(RemoveRestrictionOutputData items) {
        //Stay in Current View
        RemoveRestrictionState removeRestrictionState = removeRestrictionViewModel.getState();
        this.removeRestrictionViewModel.setState(removeRestrictionState);
        this.removeRestrictionViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(removeRestrictionViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
