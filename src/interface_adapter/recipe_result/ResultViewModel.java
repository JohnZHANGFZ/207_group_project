package interface_adapter.recipe_result;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ResultViewModel extends ViewModel {
    private ResultState state = new ResultState();

    public ResultViewModel(String viewName) {
        super(viewName);
    }

    public void setState(ResultState state) {
        this.state = state;
    }

    public ResultState getState() {
        return state;
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
}
