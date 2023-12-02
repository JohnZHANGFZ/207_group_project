package interface_adapter.restriction;

import interface_adapter.inventory.InventoryState;

public class RestrictionState {
    private String restrictionError = null;

    private String restriction = "";

    public RestrictionState(RestrictionState copy) {
        restrictionError = copy.restrictionError;
        restriction = copy.restriction;
    }

    public RestrictionState() {}
    public String getRestriction() {return restriction; }
    public String getRestrictionError() {return restrictionError; }

    public void setRestriction(String ingredients) {this.restriction = ingredients; }
    public void setRestrictionError(String restrictionError) {this.restrictionError = restrictionError; }

}
