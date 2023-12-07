import interface_adapter.ViewManagerModel;
import interface_adapter.restriction.RestrictionController;
import interface_adapter.restriction.RestrictionPresenter;
import interface_adapter.restriction.RestrictionState;
import interface_adapter.restriction.RestrictionViewModel;
import org.junit.Test;
import use_case.edit_inventory.EditInventoryInputBoundary;
import use_case.edit_restriction.EditRestrictionInputBoundary;

import static org.mockito.Mockito.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class RestrictionTest {
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
}
