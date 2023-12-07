import interface_adapter.ReturnToPreviousView.ReturnController;
import interface_adapter.ReturnToPreviousView.ReturnState;
import org.junit.Test;
import use_case.ReturnToPreviousView.ReturnInputBoundary;
import use_case.edit_inventory.EditInventoryInputBoundary;

import static org.mockito.Mockito.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class PreviousViewTest {
    @Test
    public void presenterTest() {
        ReturnState returnState = new ReturnState();
        returnState.getPreviousView();
        returnState.addView("qhfwpqi");
        returnState.canGoBack();
        returnState.goBack();
    }

    @Test
    public void controllerTest() {
        ReturnInputBoundary returnInputBoundary = mock(ReturnInputBoundary.class);
        ReturnController returnController = new ReturnController(returnInputBoundary);
        returnController.onBackButtonClicked();
    }
}
