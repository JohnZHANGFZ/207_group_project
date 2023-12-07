package use_case.return_home;

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
