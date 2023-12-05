package use_case.ReturnToPreviousView;
import interface_adapter.ReturnToPreviousView.ReturnState;

public class ReturnInteractor implements ReturnInputBoundary{
    private ReturnState returnState;


    public ReturnInteractor(ReturnState returnState) {
        this.returnState = returnState;

    }

    @Override
    public void navigateBack() {
        if (returnState.canGoBack()) {
            String previousView = returnState.getPreviousView();
            returnState.goBack();
            // TODO: need a mechanism to notify the view layer that it needs to switch views
            notifyViewChange(previousView);
        }
    }
}
