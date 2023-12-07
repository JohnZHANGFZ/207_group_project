package use_case.ReturnToPreviousView;

public interface ReturnStateInterface {
    void addView(String viewName);
    boolean canGoBack();
    String getPreviousView();
    void goBack();
}