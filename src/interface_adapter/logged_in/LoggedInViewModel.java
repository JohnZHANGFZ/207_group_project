package interface_adapter.logged_in;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class LoggedInViewModel extends ViewModel {

    private LoggedInState state = new LoggedInState();
    public static final String LOGOUT_BUTTON_LABEL = "Log out";
    public static final String RECIPEGETTER_BUTTON_LABLE = "Get Recipe";
    public static final String INVENTORY_BUTTON_LABEL = "Add/Delete Items in Inventory";
    public static final String RESTRICTION_BUTTON_LABEL = "Add/Delete Items in Restriction";


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
