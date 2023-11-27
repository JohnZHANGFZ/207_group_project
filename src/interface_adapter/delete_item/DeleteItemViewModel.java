package interface_adapter.delete_item;

import interface_adapter.ViewModel;
import interface_adapter.add_item.AddItemState;

import java.beans.PropertyChangeListener;

public class DeleteItemViewModel extends ViewModel {

    private DeleteItemState state = new DeleteItemState();

    public DeleteItemViewModel(String viewName) {
        super(viewName);
    }

    public void setState(DeleteItemState state) { this.state = state;}

    public DeleteItemState getState() { return state; }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
