package interface_adapter.restriction;

import interface_adapter.ViewManagerModel;
import use_case.edit_restriction.EditRestrictionOutputBoundary;
import view.RestrictionView;

public class RestrictionPresenter implements EditRestrictionOutputBoundary {

    private final RestrictionViewModel restrictionViewModel;
    private ViewManagerModel viewManagerModel;

    public RestrictionPresenter(ViewManagerModel viewManagerModel, RestrictionViewModel restrictionViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.restrictionViewModel = restrictionViewModel;
    }

    // switches to edit restriction page
    @Override
    public void prepareSuccessView() {
        this.viewManagerModel.setActiveView(restrictionViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
