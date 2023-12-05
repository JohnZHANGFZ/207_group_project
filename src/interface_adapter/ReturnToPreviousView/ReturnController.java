package interface_adapter.ReturnToPreviousView;

import use_case.ReturnToPreviousView.ReturnInputBoundary;

public class ReturnController {
    private ReturnInputBoundary returnInputBoundary;

    public ReturnController(ReturnInputBoundary returnInputBoundary) {
        this.returnInputBoundary = returnInputBoundary;
    }

    public void onBackButtonClicked() {
        returnInputBoundary.navigateBack();
    }
}
