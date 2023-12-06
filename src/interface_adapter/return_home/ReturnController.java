package interface_adapter.return_home;

import use_case.return_home.ReturnInputBoundary;

public class ReturnController {
    private ReturnInputBoundary returnInputBoundary;

    public ReturnController(ReturnInputBoundary returnInputBoundary) {
        this.returnInputBoundary = returnInputBoundary;
    }

    public void onBackButtonClicked() {
        returnInputBoundary.navigateBack();
    }
}
