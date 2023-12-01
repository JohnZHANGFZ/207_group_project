package use_case.add_dietary_restriction;
import entity.Ingredient;

public interface AddRestrictionUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Ingredient restriction);

    Ingredient get(String gradient);
}
