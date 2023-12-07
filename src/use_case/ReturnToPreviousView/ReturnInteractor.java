package use_case.ReturnToPreviousView;

import interface_adapter.ReturnToPreviousView.ViewChangeObserver;
import java.util.ArrayList;
import java.util.List;

public class ReturnInteractor implements ReturnInputBoundary {
    private ReturnStateInterface returnState;
    private List<ViewChangeObserver> observers = new ArrayList<>();

    public ReturnInteractor(ReturnStateInterface returnState) {
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
