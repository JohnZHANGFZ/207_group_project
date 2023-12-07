package use_case.delete_inventory;

import java.util.List;

public class DeleteInventoryOutputData {

    private final List<String> successItems;

    private final List<String> failItem;

    public DeleteInventoryOutputData(List<String> successItems, List<String> failItem) {
        this.successItems = successItems;
        this.failItem = failItem;
    }


    public List<String> getSuccessDeletedItem() { return successItems; }

    public List<String> getFailDeletedItem() { return failItem; }

}
