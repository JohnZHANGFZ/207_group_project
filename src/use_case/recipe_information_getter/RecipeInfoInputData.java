package use_case.recipe_information_getter;

public class RecipeInfoInputData {
    final private String id;

    public RecipeInfoInputData(String id) {
        this.id = id;
    }

    String getId() {
        return id;
    }
}
