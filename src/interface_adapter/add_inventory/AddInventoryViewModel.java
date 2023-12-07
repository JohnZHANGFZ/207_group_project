package interface_adapter.add_inventory;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddInventoryViewModel extends ViewModel {

    private AddInventoryState state = new AddInventoryState();

    public AddInventoryViewModel(String viewName) {
        super(viewName);
    }

    public void setState(AddInventoryState state) { this.state = state;}

    public AddInventoryState getState() { return state; }

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
