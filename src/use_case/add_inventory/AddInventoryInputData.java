package use_case.add_inventory;

import java.util.List;

public class AddInventoryInputData {
    final private List<String> items;

    public AddInventoryInputData(List<String> items) {
        this.items = items;
    }

    List<String> getItems() { return items; }
}
