package interface_adapter.logout;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LogoutViewModel extends ViewModel {

    private LogoutState state = new LogoutState();
    public LogoutViewModel() {super("logout");}

    public void setState(LogoutState state) {this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LogoutState getState() {return state;}
}
