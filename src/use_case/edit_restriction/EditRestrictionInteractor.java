package use_case.edit_restriction;

public class EditRestrictionInteractor implements EditRestrictionInputBoundary {
    final EditRestrictionOutputBoundary restrictionPresenter;

    public EditRestrictionInteractor(EditRestrictionOutputBoundary restrictionPresenter) {
        this.restrictionPresenter = restrictionPresenter;
    }

    @Override
    public void execute() {
        restrictionPresenter.prepareSuccessView();
    }
}
