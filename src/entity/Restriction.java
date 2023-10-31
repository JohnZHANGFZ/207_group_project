package entity;

import java.util.List;

public interface Restriction {
    List<Ingredient> getAllergies();

    void addAllergies(List<Ingredient> ingredient);

    void deleteAllergies(List<Ingredient> ingredient);
}
