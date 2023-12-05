package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.ReturnToPreviousView.ViewChangeObserver;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Stack;

public class ViewManager implements PropertyChangeListener, ViewChangeObserver {
    private final CardLayout cardLayout;
    private final JPanel views;
    private ViewManagerModel viewManagerModel;
    private Stack<String> viewHistory = new Stack<>();



    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);

            // Push the new view onto the stack
            if (!viewHistory.isEmpty() && !viewHistory.peek().equals(viewModelName)) {
                viewHistory.push(viewModelName);
            }
        }
    }

    public void goBack() {
        if (!viewHistory.isEmpty()) {
            // Pop the current view
            viewHistory.pop();

            if (!viewHistory.isEmpty()) {
                // Show the previous view
                String previousView = viewHistory.peek();
                cardLayout.show(views, previousView);
            }
        }
    }
    public void onViewChange(String viewName) {
        cardLayout.show(views, viewName);
        // might need to update view history stack
    }
}
