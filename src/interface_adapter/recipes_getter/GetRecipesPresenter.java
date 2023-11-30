package interface_adapter.recipes_getter;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_item.AddItemViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.recipe_result.ResultState;
import interface_adapter.recipe_result.ResultViewModel;
import use_case.recipes_getter.GetRecipeOutputBoundary;
import use_case.recipes_getter.GetRecipeOutputData;

public class GetRecipesPresenter implements GetRecipeOutputBoundary {

    private final GetRecipesViewModel getRecipesViewModel;

    private final ResultViewModel resultViewModel;

    private ViewManagerModel viewManagerModel;

    public GetRecipesPresenter(GetRecipesViewModel getRecipesViewModel, ResultViewModel resultViewModel, ViewManagerModel viewManagerModel) {
        this.getRecipesViewModel = getRecipesViewModel;
        this.resultViewModel = resultViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(GetRecipeOutputData results) {
        ResultState resultViewModelState = resultViewModel.getState();
        resultViewModelState.setRecipes(results.ReturnRecipe());
        this.resultViewModel.setState(resultViewModelState);
        this.resultViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(resultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        GetRecipesState getRecipesState = getRecipesViewModel.getState();
        getRecipesState.setGetRecipeError(error);
        this.getRecipesViewModel.firePropertyChanged();
    }
}
