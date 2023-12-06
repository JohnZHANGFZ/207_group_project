import app.Main;
import entity.CommonIngredientFactory;
import interface_adapter.add_item.AddItemPresenter;
import interface_adapter.add_item.AddItemViewModel;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.collection.add_item.*;
import use_case.login.LoginOutputBoundary;
import view.InventoryView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class AddItemTest {
    private AddItemViewModel addItemViewModel;
    private LoggedInViewModel loggedInViewModel;

    public void addOneToInventory() {
        InventoryViewModel inventoryViewModel = new InventoryViewModel("mock Inventory");
        AddItemDataAccessInterface addItemDataAccess = mock(AddItemDataAccessInterface.class);
        LoginOutputBoundary outputBoundary = mock(LoginOutputBoundary.class);

    }


    public JButton getButton(int num) {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        InventoryView sv = (InventoryView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(4);

        return (JButton) buttons.getComponent(num); // this should be the button we want
    }

    @org.junit.Test
    public void testAddButtonPresent() {
        Main.main(null);
        JButton button = getButton(1);
        assert(button.getText().equals("Add"));
    }

    @org.junit.Test
    public void testDeleteButtonPresent() {
        Main.main(null);
        JButton button = getButton(2);
        assert(button.getText().equals("Delete"));
    }

    @org.junit.Test
    public void testCancelButtonPresent() {
        Main.main(null);
        JButton button = getButton(3);
        assert(button.getText().equals("Cancel"));
    }


    public void successAddItemTest() {
        AddItemDataAccessInterface addDataAccess = mock(AddItemDataAccessInterface.class);

        AddItemOutputBoundary successPresenter = new AddItemOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                assertEquals();
            }

            @Override
            public void prepareFailView(String error) {

            }
        };

        ArrayList ingredients = new ArrayList<>();
        ingredients.add("Apple");
        ingredients.add("Banana");
        AddItemInputData inputData = new AddItemInputData(ingredients);

        AddItemInputBoundary interactor = new AddItemInteractor(addDataAccess, successPresenter,
                new CommonIngredientFactory());
        interactor.execute(inputData);
    }
}
