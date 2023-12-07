import interface_adapter.return_home.ReturnController;
import interface_adapter.return_home.ReturnPresenter;
import org.junit.Test;
import use_case.return_home.ReturnInputBoundary;
import use_case.edit_inventory.EditInventoryInputBoundary;
import use_case.return_home.ReturnInteractor;
import use_case.return_home.ReturnOutputBoundary;

import static org.mockito.Mockito.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class PreviousViewTest {
    @Test
    public void presenterTest() {
        ReturnOutputBoundary returnOutputBoundary = mock(ReturnOutputBoundary.class);
        ReturnInteractor interactor = new ReturnInteractor(returnOutputBoundary);
        interactor.execute();
    }

    @Test
    public void controllerTest() {
        ReturnInputBoundary returnInputBoundary = mock(ReturnInputBoundary.class);
        ReturnController returnController = new ReturnController(returnInputBoundary);
        returnController.execute();
    }
}
