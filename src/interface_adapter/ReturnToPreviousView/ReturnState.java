package interface_adapter.ReturnToPreviousView;

import use_case.ReturnToPreviousView.ReturnStateInterface;
import java.util.Stack;

public class ReturnState implements ReturnStateInterface {
    private Stack<String> viewHistory = new Stack<>();

    public void addView(String viewName) {
        if (viewHistory.isEmpty() || !viewHistory.peek().equals(viewName)) {
            viewHistory.push(viewName);
        }
    }

    public boolean canGoBack() {
        return viewHistory.size() > 1;
    }

    public String getPreviousView() {
        if (canGoBack()) {
            viewHistory.pop(); // current view
            return viewHistory.peek(); // last view
        }
        return null;
    }

    public void goBack() {
        if (canGoBack()) {
            viewHistory.pop(); // remove current view
        }
    }
}