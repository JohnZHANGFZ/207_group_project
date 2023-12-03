package interface_adapter.inventory;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InventoryViewModel extends ViewModel {

    public final String TITLE_LABEL = "Inventory View";
    public final String ITEM_LABLE = "Enter Items: ";
    public static final String ADD_BUTTON_LABEL = "Add";
    public static final String DELETE_BUTTON_LABEL = "Delete";

    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private InventoryState state = new InventoryState();

    public void setState(InventoryState state) {this.state = state; }
    public InventoryViewModel(String viewName) {
        super(viewName);
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
    public InventoryState getState() {return state; }
}
