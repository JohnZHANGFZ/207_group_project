package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.return_home.ReturnController;
import interface_adapter.return_home.ReturnPresenter;
import use_case.return_home.ReturnInputBoundary;
import use_case.return_home.ReturnInteractor;
import use_case.return_home.ReturnOutputBoundary;

public class ReturnUseCaseFactory {
    public static ReturnController create(ViewManagerModel viewManagerModel,
                                          LoggedInViewModel loggedInViewModel){

        ReturnOutputBoundary returnPresenter = new ReturnPresenter(viewManagerModel, loggedInViewModel);
        ReturnInputBoundary returnInteractor = new ReturnInteractor(returnPresenter);
        return new ReturnController(returnInteractor);
    }
}
