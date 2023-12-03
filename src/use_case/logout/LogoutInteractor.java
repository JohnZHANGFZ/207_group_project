package use_case.logout;

import entity.UserFactory;

public class LogoutInteractor implements LogoutInputBoundary {

    final LogoutOutputBoundary logoutPresenter;
    public LogoutInteractor(LogoutOutputBoundary logoutOutputBoundary) {
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {
        logoutPresenter.prepareSuccessView();
    }
}
