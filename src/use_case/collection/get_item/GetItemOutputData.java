package use_case.collection.get_item;

import java.util.List;

public class GetItemOutputData {
    private final List<String> items;

    public GetItemOutputData(List<String> items) {this.items = items; }

    public List<String> getItems() {return items; }
}
