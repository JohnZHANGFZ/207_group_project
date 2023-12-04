package interface_adapter.recipe_info_result;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ResultInfoViewModel extends ViewModel {
    private ResultInfoState state = new ResultInfoState();

    public ResultInfoViewModel(String viewName) {
        super(viewName);
    }

    public ResultInfoState getState() {
        return state;
    }
    public void setState(ResultInfoState state) {
        this.state = state;
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
