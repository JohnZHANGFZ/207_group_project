package interface_adapter.logged_in;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoggedInViewModel extends ViewModel {

    public final String TITLE_LABEL = "Logged In View";

    private LoggedInState state = new LoggedInState();



    private String loggedInUser;

    public static final String LOGOUT_BUTTON_LABEL = "Log out";
    public static final String RECIPEGETTER_BUTTON_LABLE = "Get Recipe";
    public static final String INVENTORY_BUTTON_LABEL = "Add/Delete Items in Inventory";
    public static final String RESTRICTION_BUTTON_LABEL = "Add/Delete Items in Restriction";



    public LoggedInViewModel(String viewName) {
        super(viewName);
    }

    public LoggedInState getState() { return state; }

    public void setState(LoggedInState state) {this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
