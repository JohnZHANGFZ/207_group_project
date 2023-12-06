package interface_adapter.logged_in;

public class LoggedInState {
    private String username = "";
    private String userInventory = "";
    private String userRestrictions = "";
    private String ingredients = "";
    // leaving numRecipes stored in state as a String so that textbox can be updated regardless of what is typed
    private String numRecipes = "";
    private String deleteAccountError = null;

    public LoggedInState(LoggedInState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserInventory() {return userInventory;} // for user's stored inventory

    public void setUserInventory(String userInventory) {this.userInventory = userInventory;} // for user's stored inventory

    public String getUserRestrictions() {return userRestrictions;} // for user's stored allergies

    public void setUserRestrictions(String userRestrictions) {this.userRestrictions = userRestrictions;} // for user's stored allergies

    public String getIngredients() {return ingredients;} // for ingredient text box input

    public void setIngredients(String ingredients) {this.ingredients = ingredients;} // for ingredient text box input

    public String getNumRecipes() {return numRecipes;} // for numRecipe textbox input

    public void setNumRecipes(String numRecipes) {this.numRecipes = numRecipes;} // for numRecipe textbox input

    public void setDeleteAccountError(String error) {this.deleteAccountError = error;}
    public String getDeleteAccountError() {return deleteAccountError;}
}
