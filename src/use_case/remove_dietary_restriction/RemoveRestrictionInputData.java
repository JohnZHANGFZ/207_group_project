package use_case.remove_dietary_restriction;

import java.util.List;

public class RemoveRestrictionInputData {
    final private List<String> items;

    public RemoveRestrictionInputData(List<String> items) { this.items = items; }

    public List<String> getItems() { return items;}
}
