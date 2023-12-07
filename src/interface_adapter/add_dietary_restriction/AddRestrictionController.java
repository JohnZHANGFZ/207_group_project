package interface_adapter.add_dietary_restriction;

import use_case.add_dietary_restriction.AddRestrictionInputBoundary;
import use_case.add_dietary_restriction.AddRestrictionInputData;

import java.util.List;

public class AddRestrictionController {
    final AddRestrictionInputBoundary addRestrictionUseCaseInteractor;

    public AddRestrictionController(AddRestrictionInputBoundary addRestrictionUseCaseInteractor) {
        this.addRestrictionUseCaseInteractor = addRestrictionUseCaseInteractor;
    }

    public void execute(List<String> ingredients) {
        AddRestrictionInputData addInventoryInputData = new AddRestrictionInputData(ingredients);

        addRestrictionUseCaseInteractor.execute(addInventoryInputData);
    }
}
