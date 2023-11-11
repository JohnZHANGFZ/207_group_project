package interface_adapter.input_ingredient;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InputIngredientViewModel extends ViewModel {

    private InputIngredientState state = new InputIngredientState();

    public InputIngredientViewModel(String viewName) { super(viewName); }

    public void setState(InputIngredientState state) { this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() { support.firePropertyChange("state", null, this.state); }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public InputIngredientState getState() { return state; }

}
