package use_case.remove_dietary_restriction;


public interface RemoveRestrictionOutputBoundary {
    void prepareFailView(String error);

    void prepareSuccessView(RemoveRestrictionOutputData items);
}
