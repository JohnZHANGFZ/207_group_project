package use_case.collection.delete_item;

import java.util.List;

public class DeleteItemInputData {
    final private List<String> items;

    public DeleteItemInputData(List<String> items) { this.items = items; }

    List<String> getItems() { return items;}
}
