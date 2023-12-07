import entity.IngredientFactory;
import interface_adapter.add_item.AddItemController;
import interface_adapter.add_item.AddItemPresenter;
import interface_adapter.add_item.AddItemState;
import interface_adapter.add_item.AddItemViewModel;
import interface_adapter.delete_account.DeleteAccountController;
import interface_adapter.logged_in.LoggedInViewModel;
import org.junit.Test;
import use_case.add_inventory.*;
import use_case.delete_account.DeleteAccountInputBoundary;
import view.DetailsView;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AddItemTest {

    @Test
    public void addItemTest() {
        AddItemViewModel addItemViewModel = new AddItemViewModel("test");
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel("testing");
        AddItemPresenter addItemPresenter = new AddItemPresenter(addItemViewModel, loggedInViewModel);
        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);

        AddItemViewModel addItemViewModel1 = new AddItemViewModel("terror");
        addItemViewModel1.addPropertyChangeListener(propertyChangeListener);
        AddItemState addItemState = addItemViewModel.getState();

        addItemState.setAddItemError("teehee");
        addItemState.setIngredients(new ArrayList<>());

        addItemViewModel1.setState(addItemViewModel.getState());

        AddItemState addItemState1 = new AddItemState(addItemViewModel1.getState());
        addItemState1.getIngredients();
        addItemViewModel1.firePropertyChanged();
        addItemViewModel1.getViewName();

//        addItemPresenter.prepareFailView("failed");
//        addItemPresenter.prepareSuccessView();
    }

    @Test
    public void addInventory() {
        AddInventoryInputBoundary addInventoryInputBoundary = mock(AddInventoryInputBoundary.class);
        AddInventoryDataAccessInterface addInventoryDataAccessInterface = mock(AddInventoryDataAccessInterface.class);
        AddItemOutputBoundary addItemOutputBoundary = mock(AddItemOutputBoundary.class);
        IngredientFactory ingredientFactory = mock(IngredientFactory.class);

        AddInventoryInputData addInventoryInputData = new AddInventoryInputData(new ArrayList<>());
        addInventoryInputData.getItems();

        AddInventoryInteractor addInventoryInteractor = new AddInventoryInteractor(addInventoryDataAccessInterface, addItemOutputBoundary, ingredientFactory);
        addInventoryInteractor.execute(addInventoryInputData);

    }
    @Test
    public void controller() {
        AddInventoryInputBoundary addItemInputBoundary = mock(AddInventoryInputBoundary.class);
        AddItemController addItemController = new AddItemController(addItemInputBoundary);
        addItemController.execute(new ArrayList<>());
    }

}
