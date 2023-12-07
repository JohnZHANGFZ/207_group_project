package use_case.remove_dietary_restriction;

import java.util.List;

public class RemoveRestrictionOutputData {
    private final List<String> successRestrictions;

    private final List<String> failRestrictions;

    public RemoveRestrictionOutputData(List<String> successRestrictions, List<String> failRestrictions) {
        this.successRestrictions = successRestrictions;
        this.failRestrictions = failRestrictions;
    }

    public List<String> getSuccessRemovedRestrictions() { return successRestrictions; }

    public List<String> getFailRemovedRestrictions() { return failRestrictions; }
}
