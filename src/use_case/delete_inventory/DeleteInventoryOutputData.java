package use_case.delete_inventory;

import java.util.ArrayList;
import java.util.List;

public class DeleteInventoryOutputData {

    private final ArrayList<String> successItems;

    private final ArrayList<String> failItem;

    public DeleteInventoryOutputData(ArrayList<String> successItems, ArrayList<String> failItem) {
        this.successItems = successItems;
        this.failItem = failItem;
    }


    public ArrayList<String> getSuccessDeletedItem() { return successItems; }

    public ArrayList<String> getFailDeletedItem() { return failItem; }

}
