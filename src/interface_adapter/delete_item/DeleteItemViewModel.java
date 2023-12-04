package interface_adapter.delete_item;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteItemViewModel extends ViewModel {

    private DeleteItemState state = new DeleteItemState();

    public DeleteItemViewModel(String viewName) {
        super(viewName);
    }

    public void setState(DeleteItemState state) { this.state = state;}

    public DeleteItemState getState() { return state; }

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
