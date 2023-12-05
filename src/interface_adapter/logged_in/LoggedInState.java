package interface_adapter.logged_in;

public class LoggedInState {
    private String username = "";
    private String ingredients = "";
    // leaving numRecipes stored in state as a String so that textbox can be updated regardless of what is typed
    private String numRecipes;

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

    public String getIngredients() {return ingredients;}

    public void setIngredients(String ingredients) {this.ingredients = ingredients;}

    public String getNumRecipes() {return numRecipes;}

    public void setNumRecipes(String numRecipes) {this.numRecipes = numRecipes;}
}
