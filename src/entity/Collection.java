package entity;

import java.util.List;

public interface Collection {
    List<Ingredient> getItems();
    String toString();

    void addItems(List<Ingredient> ingredient);

    void deleteItems(List<Ingredient> ingredient);

    boolean itemExists(String item);
}
