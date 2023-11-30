package use_case.add_dietary_restriction;

import java.util.List;

public class AddDietaryOutputData {
    private final List<String> ingredientList;
    private boolean useCaseFailed;

    public AddDietaryOutputData(List<String> ingredientList, boolean useCaseFailed) {
        this.ingredientList = ingredientList;
        this.useCaseFailed = useCaseFailed;
    }
}
