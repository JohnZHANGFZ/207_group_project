package interface_adapter.recipe_info_result;

import com.google.gson.JsonObject;

public class ResultInfoState {

    private String resultError = null;
    private JsonObject recipe;

    public ResultInfoState(ResultInfoState copy) {
        this.resultError = copy.resultError;
        this.recipe = copy.recipe;
    }

    public ResultInfoState() {

    }

    public JsonObject getRecipe() {
        return recipe;
    }

    public void setRecipe(JsonObject recipe) {
        this.recipe = recipe;
    }

    public void setResultError(String error) {
        this.resultError = error;
    }
}
