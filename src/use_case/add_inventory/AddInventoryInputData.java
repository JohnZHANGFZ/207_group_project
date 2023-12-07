package use_case.add_inventory;

import java.util.List;

public class AddInventoryInputData {
    final private List<String> items;
    final private String user;

    public AddInventoryInputData(String user, List<String> items) {
        this.items = items;
        this.user = user;
    }
}
