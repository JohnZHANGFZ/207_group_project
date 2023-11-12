package interface_adapter.logged_in;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class LoggedInViewModel extends ViewModel {

    private LoggedInState state = new LoggedInState();
    public LoggedInViewModel(String viewName) {
        super(viewName);
    }

    public LoggedInState getState() { return state; }

    public void setState(LoggedInState state) {this.state = state; }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
