package interface_adapter.add_dietary_restriction;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.add_inventory.AddItemOutputBoundary;

public class AddRestrictionPresenter implements AddItemOutputBoundary {

    private final AddRestrictionViewModel addRestrictionViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private ViewManagerModel viewManagerModel;

    public AddRestrictionPresenter(AddRestrictionViewModel addRestrictionViewModel, LoggedInViewModel loggedInViewModel) {
        this.addRestrictionViewModel = addRestrictionViewModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView() {
        //Stay in current view
        AddRestrictionState addRestrictionState = addRestrictionViewModel.getState();
        this.addRestrictionViewModel.setState(addRestrictionState);
        this.addRestrictionViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(addRestrictionViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String error) {
        AddRestrictionState addRestrictionState = addRestrictionViewModel.getState();
        addRestrictionState.setAddRestrictionError(error);
        addRestrictionViewModel.firePropertyChanged();
    }
}
