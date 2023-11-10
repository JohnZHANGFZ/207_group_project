package entity;

import java.util.List;

public interface Restriction {
    List<Ingredient> getAllergies();

    void addAllergies(List<Ingredient> ingredients);

    void deleteAllergies(List<Ingredient> ingredients);
}
