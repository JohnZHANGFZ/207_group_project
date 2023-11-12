package use_case.collection.AddItem;

import java.util.List;

public class AddItemInputData {
    final private List<String> items;

    public AddItemInputData(List<String> items) {
        this.items = items;
    }

    List<String> getItems() { return items; }
}
