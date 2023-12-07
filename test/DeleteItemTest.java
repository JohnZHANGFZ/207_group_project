import interface_adapter.ViewManagerModel;
import interface_adapter.delete_account.DeleteAccountPresenter;
import interface_adapter.delete_item.DeleteItemController;
import interface_adapter.delete_item.DeleteItemPresenter;
import interface_adapter.delete_item.DeleteItemState;
import interface_adapter.delete_item.DeleteItemViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import org.junit.Test;
import use_case.collection.delete_item.DeleteItemInputBoundary;
import use_case.collection.delete_item.DeleteItemInputData;
import use_case.collection.delete_item.DeleteItemOutputData;
import use_case.delete_account.DeleteAccountInputBoundary;

import static org.mockito.Mockito.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class DeleteItemTest {
    @Test
    public void presenterTest() {
        DeleteItemViewModel deleteItemViewModel = new DeleteItemViewModel("test");
        DeleteItemPresenter deleteItemPresenter = new DeleteItemPresenter(deleteItemViewModel, new LoggedInViewModel("bla"), new ViewManagerModel());
        DeleteItemOutputData deleteItemOutputData = new DeleteItemOutputData(new ArrayList<>(), new ArrayList<>());
        deleteItemOutputData.getFailDeletedItem();
        deleteItemOutputData.getSuccessDeletedItem();
        deleteItemPresenter.prepareSuccessView(deleteItemOutputData);
        deleteItemPresenter.prepareFailView("fail");
        DeleteItemState deleteItemState = new DeleteItemState(deleteItemViewModel.getState());
        deleteItemState.setDeleteItemError("bla");
        deleteItemState.getIngredients();
        deleteItemState.setIngredients(new ArrayList<>());

        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        deleteItemViewModel.addPropertyChangeListener(propertyChangeListener);
    }

    @Test
    public void controllerTest() {
        DeleteItemInputBoundary deleteItemInputBoundary = mock(DeleteItemInputBoundary.class);
        DeleteItemController deleteItemController = new DeleteItemController(deleteItemInputBoundary);
        deleteItemController.execute(new ArrayList<>());
    }
}
