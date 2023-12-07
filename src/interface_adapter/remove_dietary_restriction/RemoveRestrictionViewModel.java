package interface_adapter.remove_dietary_restriction;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RemoveRestrictionViewModel extends ViewModel {
    private RemoveRestrictionState state = new RemoveRestrictionState();

    public RemoveRestrictionViewModel(String viewName) {
        super(viewName);
    }

    public void setState(RemoveRestrictionState state) { this.state = state;}

    public RemoveRestrictionState getState() { return state; }

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
