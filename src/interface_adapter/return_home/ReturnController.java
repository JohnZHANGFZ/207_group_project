package interface_adapter.return_home;

import use_case.return_home.ReturnInputBoundary;

public class ReturnController {
    private ReturnInputBoundary returnInteractor;

    public ReturnController(ReturnInputBoundary returnInteractor) {
        this.returnInteractor = returnInteractor;
    }

    public void execute() {
        returnInteractor.execute();
    }
}
