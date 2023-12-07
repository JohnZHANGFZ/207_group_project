package use_case.delete_inventory;

import java.util.ArrayList;
import java.util.List;

public class DeleteInventoryInputData {
    final private ArrayList<String> items;
    final private String user;

    public DeleteInventoryInputData(String user, ArrayList<String> items) {
        this.items = items;
        this.user = user;
    }

    public String getUser() {return user;}
    public ArrayList<String> getItems() { return items;}
}
