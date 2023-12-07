package interface_adapter.remove_dietary_restriction;

import use_case.remove_dietary_restriction.RemoveRestrictionInputBoundary;
import use_case.remove_dietary_restriction.RemoveRestrictionInputData;

import java.util.List;

public class RemoveRestrictionController {
    final RemoveRestrictionInputBoundary removeRestrictionUseCaseInteractor;

    public RemoveRestrictionController(RemoveRestrictionInputBoundary removeRestrictionUseCaseInteractor) {
        this.removeRestrictionUseCaseInteractor = removeRestrictionUseCaseInteractor;
    }

    public void execute(List<String> ingredients) {
        RemoveRestrictionInputData removeRestrictionInputData = new RemoveRestrictionInputData(ingredients);

        removeRestrictionUseCaseInteractor.execute(removeRestrictionInputData);
    }
}