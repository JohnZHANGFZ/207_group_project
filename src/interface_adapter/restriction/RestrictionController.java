package interface_adapter.restriction;

import use_case.edit_restriction.EditRestrictionInputBoundary;

public class RestrictionController {

    final EditRestrictionInputBoundary restrictionInteractor;

    public RestrictionController(EditRestrictionInputBoundary restrictionInteractor) {
        this.restrictionInteractor = restrictionInteractor;
    }

    public void execute() {
        restrictionInteractor.execute();
    }
}
