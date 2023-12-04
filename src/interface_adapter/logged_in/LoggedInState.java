package interface_adapter.logged_in;

public class LoggedInState {
    private String username = "";
    private String ingredients = "";
    private int numRecipes;

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

    public int getNumRecipes() {return numRecipes;}

    public void setNumRecipes(int numRecipes) {this.numRecipes = numRecipes;}
}
