package use_case.collection.get_item;

import java.util.List;

public interface GetItemDataAccessInterface {

    boolean existByName(String itemName);
    List<String> getItem();
}
