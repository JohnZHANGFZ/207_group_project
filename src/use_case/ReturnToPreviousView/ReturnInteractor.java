package use_case.ReturnToPreviousView;
import interface_adapter.ReturnToPreviousView.ReturnPresenter;
public class ReturnInteractor implements ReturnInputBoundary{
    private ReturnOutputBoundary ReturnPresenter;
    private ViewStack viewStack;

    public ReturnInteractor(ReturnOutputBoundary ReturnPresenter, ViewStack viewStack) {
        this.ReturnPresenter = ReturnPresenter;
        this.viewStack = viewStack;
    }

    @Override
    public void navigateBack() {
        String previousView = viewStack.pop();
        // check if the viewstack is empty and other necessary che

        outputBoundary.updateView(previousView);
    }
}
