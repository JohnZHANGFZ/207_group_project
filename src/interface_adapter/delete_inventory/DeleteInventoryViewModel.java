package interface_adapter.delete_inventory;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteInventoryViewModel extends ViewModel {

    private DeleteInventoryState state = new DeleteInventoryState();

    public DeleteInventoryViewModel(String viewName) {
        super(viewName);
    }

    public void setState(DeleteInventoryState state) { this.state = state;}

    public DeleteInventoryState getState() { return state; }

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
