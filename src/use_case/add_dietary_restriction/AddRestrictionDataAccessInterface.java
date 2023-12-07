package use_case.add_dietary_restriction;
import entity.Ingredient;

public interface AddRestrictionDataAccessInterface {

    void addRestriction(Ingredient restriction);

    boolean restrictionExists(String itemName);
}
