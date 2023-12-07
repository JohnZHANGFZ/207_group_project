package use_case.delete_inventory;

import java.util.List;

public class DeleteInventoryInputData {
    final private List<String> items;

    public DeleteInventoryInputData(List<String> items) { this.items = items; }

    List<String> getItems() { return items;}
}
