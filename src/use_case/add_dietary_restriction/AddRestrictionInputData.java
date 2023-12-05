package use_case.add_dietary_restriction;

import java.util.List;

public class AddRestrictionInputData {

    private List<String> items;

    public AddRestrictionInputData(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return this.items;
    }
}
