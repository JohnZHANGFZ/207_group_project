package use_case.return_home;

import interface_adapter.return_home.ReturnPresenter;
import interface_adapter.return_home.ViewChangeObserver;

public class ReturnInteractor implements ReturnInputBoundary {
    final ReturnOutputBoundary returnPresenter;

    public ReturnInteractor(ReturnOutputBoundary returnPresenter) {
        this.returnPresenter = returnPresenter;
    }

    @Override
    public void execute() {
        returnPresenter.prepareSuccessView();
    }
}
