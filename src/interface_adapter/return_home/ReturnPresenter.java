package interface_adapter.return_home;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.return_home.ReturnOutputBoundary;

public class ReturnPresenter implements ReturnOutputBoundary {

    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public ReturnPresenter(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView() {
        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
