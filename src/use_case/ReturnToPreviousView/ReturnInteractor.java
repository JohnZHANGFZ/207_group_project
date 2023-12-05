package use_case.ReturnToPreviousView;
import java.util.ArrayList;
import java.util.List;
import interface_adapter.ReturnToPreviousView.ReturnState;
import interface_adapter.ReturnToPreviousView.ViewChangeObserver;

public class ReturnInteractor implements ReturnInputBoundary {
    private ReturnState returnState;
    private List<ViewChangeObserver> observers = new ArrayList<>();

    public ReturnInteractor(ReturnState returnState) {
        this.returnState = returnState;
    }

    public void addObserver(ViewChangeObserver observer) {
        observers.add(observer);
    }

    private void notifyViewChange(String viewName) {
        for (ViewChangeObserver observer : observers) {
            observer.onViewChange(viewName);
        }
    }

    @Override
    public void navigateBack() {
        if (returnState.canGoBack()) {
            String previousView = returnState.getPreviousView();
            returnState.goBack();
            notifyViewChange(previousView);
        }
    }
}
