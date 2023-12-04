package interface_adapter.recipe_information_getter;

import interface_adapter.ViewModel;
import interface_adapter.recipe_info_result.ResultInfoState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RecipeInfoViewModel extends ViewModel {
    private RecipeInfoState state = new RecipeInfoState();

    public RecipeInfoViewModel(String viewName) {
        super(viewName);
    }

    public RecipeInfoState getState() {
        return state;
    }

    public void setState(RecipeInfoState state) {
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
