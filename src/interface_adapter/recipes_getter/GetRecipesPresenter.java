package interface_adapter.recipes_getter;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_item.AddItemViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.recipes_getter.GetRecipeOutputBoundary;
import use_case.recipes_getter.GetRecipeOutputData;

public class GetRecipesPresenter implements GetRecipeOutputBoundary {

    private final GetRecipesViewModel getRecipesViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private ViewManagerModel viewManagerModel;

    public GetRecipesPresenter(GetRecipesViewModel getRecipesViewModel, LoggedInViewModel loggedInViewModel) {
        this.getRecipesViewModel = getRecipesViewModel;
        this.loggedInViewModel = loggedInViewModel;
    }
    @Override
    public void prepareSuccessView(GetRecipeOutputData results) {
        GetRecipesState getRecipesState = getRecipesViewModel.getState();
        getRecipesState.setRecipes(results.ReturnRecipe());
        this.getRecipesViewModel.setState(getRecipesState);
        this.getRecipesViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(getRecipesViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        GetRecipesState getRecipesState = getRecipesViewModel.getState();
        getRecipesState.setGetRecipeError(error);
        this.getRecipesViewModel.firePropertyChanged();
    }
}
