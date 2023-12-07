package use_case.remove_dietary_restriction;

import java.util.List;

public class RemoveRestrictionOutputData {
    private final List<String> successItems;

    private final List<String> failItem;

    public RemoveRestrictionOutputData(List<String> successItems, List<String> failItem) {
        this.successItems = successItems;
        this.failItem = failItem;
    }

    public List<String> getSuccessDeletedItem() { return successItems; }

    public List<String> getFailDeletedItem() { return failItem; }
}
