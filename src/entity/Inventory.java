package entity;

import java.util.List;

public interface Inventory {
    List<Ingredient> getItems();

    void addItems(List<Ingredient> ingredient);

    void deleteItems(List<Ingredient> ingredient);
}
