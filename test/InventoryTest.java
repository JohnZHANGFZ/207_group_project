import interface_adapter.ViewManagerModel;
import interface_adapter.inventory.InventoryController;
import interface_adapter.inventory.InventoryPresenter;
import interface_adapter.inventory.InventoryState;
import interface_adapter.inventory.InventoryViewModel;
import org.junit.Test;
import use_case.edit_inventory.EditInventoryInputBoundary;
import use_case.edit_inventory.EditInventoryInteractor;
import use_case.edit_inventory.EditInventoryOutputBoundary;

import static org.mockito.Mockito.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class InventoryTest {
    @Test
    public void presenterTest() {
        InventoryViewModel inventoryViewModel = new InventoryViewModel("bla");
        inventoryViewModel.firePropertyChanged();
        InventoryState inventoryState = inventoryViewModel.getState();
        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        inventoryViewModel.addPropertyChangeListener(propertyChangeListener);

        inventoryState.getInventoryError();
        inventoryState.setInventory("carrot");
        inventoryState.getInventory();
        InventoryState inventoryState1 = new InventoryState(inventoryState);

        inventoryViewModel.setState(inventoryState1);

        InventoryPresenter inventoryPresenter = new InventoryPresenter(new ViewManagerModel(), inventoryViewModel);
        inventoryPresenter.prepareSuccessView();
    }

    @Test
    public void editInventory() {
        EditInventoryOutputBoundary editInventoryOutputBoundary = mock(EditInventoryOutputBoundary.class);
        EditInventoryInteractor editInventoryInteractor = new EditInventoryInteractor(editInventoryOutputBoundary);
        editInventoryInteractor.execute();
    }
    @Test
    public void controllerTest() {
        EditInventoryInputBoundary editInventoryInputBoundary = mock(EditInventoryInputBoundary.class);
        InventoryController inventoryController = new InventoryController(editInventoryInputBoundary);
        inventoryController.execute();
    }
}
