package use_case.remove_dietary_restriction;

import entity.Ingredient;

public interface RemoveRestrictionDataAccessInterface {
    boolean restrictionExists(String itemName);

    String removeRestriction(Ingredient ingredient);
}
