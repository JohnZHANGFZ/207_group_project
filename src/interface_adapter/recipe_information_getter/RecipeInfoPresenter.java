package interface_adapter.recipe_information_getter;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_info_result.ResultInfoState;
import interface_adapter.recipe_info_result.ResultInfoViewModel;
import use_case.recipe_information_getter.RecipeInfoInputBoundary;
import use_case.recipe_information_getter.RecipeInfoInputData;
import use_case.recipe_information_getter.RecipeInfoOutputBoundary;
import use_case.recipe_information_getter.RecipeInfoOutputData;

public class RecipeInfoPresenter implements RecipeInfoOutputBoundary {

    private final RecipeInfoViewModel recipeInfoViewModel;
    private final ResultInfoViewModel resultInfoViewModel;
    private ViewManagerModel viewManagerModel;

    public RecipeInfoPresenter(RecipeInfoViewModel recipeInfoViewModel, ResultInfoViewModel resultInfoViewModel, ViewManagerModel viewManagerModel) {
        this.recipeInfoViewModel = recipeInfoViewModel;
        this.resultInfoViewModel = resultInfoViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    //switches to result info view model
    @Override
    public void prepareSuccessView(RecipeInfoOutputData recipe) {
        ResultInfoState resultInfoState = resultInfoViewModel.getState();
        resultInfoState.setRecipe(recipe.ReturnRecipe());
        this.resultInfoViewModel.setState(resultInfoState);
        this.resultInfoViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(resultInfoViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        RecipeInfoState recipeInfoState = recipeInfoViewModel.getState();
        recipeInfoState.setRecipeInfoError(error);
        this.recipeInfoViewModel.firePropertyChanged();
    }
}
