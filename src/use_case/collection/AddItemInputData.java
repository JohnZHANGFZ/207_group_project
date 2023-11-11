package use_case.collection;

import java.util.List;

public class AddItemInputData {
    final private List<String> items;

    public AddItemInputData(List<String> items) {
        this.items = items;
    }

    List<String> getItems() { return items; }
}
