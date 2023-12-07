import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_info_result.ResultInfoViewModel;
import interface_adapter.recipe_result.ResultViewModel;
import org.junit.Test;
import view.DetailsView;

import java.beans.PropertyChangeListener;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ViewTest {

    @Test
    public void testDetailsView() {
        ResultInfoViewModel resultInfoViewModel = new ResultInfoViewModel("testing");
        DetailsView detailsView = new DetailsView(resultInfoViewModel);
    }

    @Test
    public void viewManagerTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.getActiveView();
        PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
        viewManagerModel.addPropertyChangeListener(propertyChangeListener);
    }
}
