package interface_adapter.add_dietary_restriction;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddRestrictionViewModel extends ViewModel {

    private AddRestrictionState state = new AddRestrictionState();

    public AddRestrictionViewModel(String viewName) {
        super(viewName);
    }

    public void setState(AddRestrictionState state) { this.state = state;}

    public AddRestrictionState getState() { return state; }

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