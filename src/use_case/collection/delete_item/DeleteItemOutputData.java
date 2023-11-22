package use_case.collection.delete_item;

import java.util.List;

public class DeleteItemOutputData {

    private final List<String> successItems;

    private final List<String> failItem;

    public DeleteItemOutputData(List<String> successItems, List<String> failItem) {
        this.successItems = successItems;
        this.failItem = failItem;
    }


    public List<String> getSuccessDeletedItem() { return successItems; }

    public List<String> getFailDeletedItem() { return failItem; }

}
