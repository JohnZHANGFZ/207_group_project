package interface_adapter.restriction;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RestrictionViewModel extends ViewModel {
    public final String TITLE_LABEL = "Restriction View";
    public final String ITEM_LABLE = "Enter Items: ";
    public static final String ADD_BUTTON_LABEL = "Add";
    public static final String DELETE_BUTTON_LABEL = "Delete";

    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private RestrictionState state = new RestrictionState();

    public void setState(RestrictionState state) {this.state = state; }



    public RestrictionViewModel(String viewName) {
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

    public RestrictionState getState() {return state; }
}
