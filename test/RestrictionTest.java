import entity.CommonRestriction;
import entity.Ingredient;
import entity.IngredientFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.restriction.RestrictionController;
import interface_adapter.restriction.RestrictionPresenter;
import interface_adapter.restriction.RestrictionState;
import interface_adapter.restriction.RestrictionViewModel;
import org.junit.Test;
import use_case.add_dietary_restriction.*;
import use_case.add_inventory.AddInventoryInputBoundary;
import use_case.add_inventory.AddInventoryInputData;
import use_case.edit_restriction.EditRestrictionInputBoundary;
import use_case.recipes_getter.GetRecipeOutputBoundary;
import use_case.remove_dietary_restriction.RemoveRestrictionInputData;

import static org.mockito.Mockito.*;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class RestrictionTest {

    @Test
    public void useCaseTest() {
        AddRestrictionInputData addRestrictionInputData = new AddRestrictionInputData(new ArrayList<>());
        addRestrictionInputData.getItems();

        AddRestrictionOutputData addRestrictionOutputData = new AddRestrictionOutputData(new ArrayList<>(), false);
        addRestrictionOutputData.GetIngredient();

        AddRestrictionDataAccessInterface addRestrictionUserDataAccessInterface = mock(AddRestrictionDataAccessInterface.class);

        AddRestrictionOutputBoundary addRestrictionOutputBoundary = mock(AddRestrictionOutputBoundary.class);

        IngredientFactory ingredientFactory = mock(IngredientFactory.class);

        AddRestrictionInteractor addRestrictionInteractor = new AddRestrictionInteractor(addRestrictionUserDataAccessInterface, addRestrictionOutputBoundary, ingredientFactory);

        addRestrictionInteractor.execute(addRestrictionInputData);

        AddRestrictionInputBoundary addInventoryInputBoundary = mock(AddRestrictionInputBoundary.class);
        addInventoryInputBoundary.execute(addRestrictionInputData);
    }

//    @Test
//    public void useCaseRemoveTest() {
//        RemoveRestrictionInputData removeRestrictionInputData = new RemoveRestrictionInputData()
//    }
    @Test
    public void presenterTest() {
        RestrictionState restrictionState = new RestrictionState();
        restrictionState.setRestriction("fhqipf");
        restrictionState.setRestrictionError("qfihqphfq");
        restrictionState.getRestriction();
        RestrictionState restrictionState1 = new RestrictionState(restrictionState);
        restrictionState1.getRestrictionError();

        RestrictionViewModel restrictionViewModel = new RestrictionViewModel("qhfip");
        restrictionViewModel.setState(restrictionState1);
        restrictionViewModel.firePropertyChanged();
        restrictionViewModel.getState();
        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        restrictionViewModel.addPropertyChangeListener(propertyChangeListener);

        RestrictionPresenter restrictionPresenter = new RestrictionPresenter(new ViewManagerModel(), restrictionViewModel);
        restrictionPresenter.prepareSuccessView();
    }

    @Test
    public void controllerTest() {
        EditRestrictionInputBoundary editRestrictionInputBoundary = mock(EditRestrictionInputBoundary.class);
        RestrictionController restrictionController = new RestrictionController(editRestrictionInputBoundary);
        restrictionController.execute();
    }

    @Test
    public void commonRestriction() {
        CommonRestriction commonRestriction = new CommonRestriction();
        commonRestriction.getItems();
        List<Ingredient> items = new ArrayList<>();
        Ingredient ingredient = mock(Ingredient.class);
        commonRestriction.addItems(items);
        items.add(ingredient);
        commonRestriction.itemExists("item");
        commonRestriction.deleteItems(items);

    }
}
