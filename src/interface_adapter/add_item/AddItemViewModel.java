package interface_adapter.add_item;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddItemViewModel extends ViewModel {

    private AddItemState state = new AddItemState();

    public AddItemViewModel(String viewName) {
        super(viewName);
    }

    public void setState(AddItemState state) { this.state = state;}

    public AddItemState getState() { return state; }

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
