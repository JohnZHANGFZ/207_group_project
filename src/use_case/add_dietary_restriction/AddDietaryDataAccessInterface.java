package use_case.add_dietary_restriction;

import entity.User;

public interface AddDietaryDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

}
