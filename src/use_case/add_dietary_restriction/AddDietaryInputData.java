package use_case.add_dietary_restriction;

import java.util.List;

public class AddDietaryInputData {

    private List<String> items;
    public AddDietaryInputData(List<String> items){
        this.items = items;
    }

    public List<String> getItems(){
        return this.items;
    }
}
