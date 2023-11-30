package use_case.add_dietary_restriction;

public interface AddDietaryOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
