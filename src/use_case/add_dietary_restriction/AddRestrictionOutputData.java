package use_case.add_dietary_restriction;
import java.util.List;

public class AddRestrictionOutputData {

    private final List<String> ingredientList;
    private boolean useCaseFailed;

    public AddRestrictionOutputData(List<String> ingredientList, boolean useCaseFailed) {
        this.ingredientList = ingredientList;

        this.useCaseFailed = useCaseFailed;
    }

    public List<String> getgredient() {
        return this.ingredientList;
    }

}