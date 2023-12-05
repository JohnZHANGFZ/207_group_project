package interface_adapter.recipes_getter;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetRecipesViewModel extends ViewModel {
    public final String TITLE_LABEL = "Recipe Result View";
    public final String ITEM_LABLE = "Enter Recipe ID: ";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String SEARCHID_BUTTON_LABEL = "Search ID";


    private GetRecipesState state = new GetRecipesState();

    public GetRecipesViewModel(String viewName) {
        super(viewName);
    }

    public void setState(GetRecipesState state) {
        this.state = state;
    }

    public GetRecipesState getState() {
        return state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
