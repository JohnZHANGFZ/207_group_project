import interface_adapter.ViewManagerModel;
import interface_adapter.delete_inventory.DeleteInventoryController;
import interface_adapter.delete_account.DeleteAccountPresenter;
import interface_adapter.delete_inventory.DeleteInventoryController;
import interface_adapter.delete_inventory.DeleteInventoryPresenter;
import interface_adapter.delete_inventory.DeleteInventoryState;
import interface_adapter.delete_inventory.DeleteInventoryViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import org.junit.Test;
import use_case.delete_inventory.DeleteInventoryInputBoundary;
import use_case.delete_inventory.DeleteInventoryInputData;
import use_case.delete_inventory.DeleteInventoryOutputData;
import use_case.delete_account.DeleteAccountInputBoundary;

import static org.mockito.Mockito.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class DeleteItemTest {
    @Test
    public void presenterTest() {
        DeleteInventoryViewModel deleteItemViewModel = new DeleteInventoryViewModel("test");
        DeleteInventoryPresenter deleteItemPresenter = new DeleteInventoryPresenter(deleteItemViewModel, new LoggedInViewModel("bla"), new ViewManagerModel());
        DeleteInventoryOutputData deleteItemOutputData = new DeleteInventoryOutputData(new ArrayList<>(), new ArrayList<>());
        deleteItemOutputData.getFailDeletedItem();
        deleteItemOutputData.getSuccessDeletedItem();
        deleteItemPresenter.prepareSuccessView(deleteItemOutputData);
        deleteItemPresenter.prepareFailView("fail");
        DeleteInventoryState deleteItemState = new DeleteInventoryState(deleteItemViewModel.getState());
        deleteItemState.setDeleteItemError("bla");
        deleteItemState.getIngredients();
        deleteItemState.setIngredients(new ArrayList<>());

        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        deleteItemViewModel.addPropertyChangeListener(propertyChangeListener);
    }

    @Test
    public void controllerTest() {
        DeleteInventoryInputBoundary deleteItemInputBoundary = mock(DeleteInventoryInputBoundary.class);
        DeleteInventoryController deleteItemController = new DeleteInventoryController(deleteItemInputBoundary);
        deleteItemController.execute("eiqp", new ArrayList<>());
    }
}
