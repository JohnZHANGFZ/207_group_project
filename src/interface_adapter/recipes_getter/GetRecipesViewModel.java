package interface_adapter.recipes_getter;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetRecipesViewModel extends ViewModel {

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
