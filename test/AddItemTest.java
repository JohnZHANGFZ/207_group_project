import app.Main;
import data_access.FileUserDataAccessObject;
import entity.Collection;
import entity.CommonInventory;
import interface_adapter.inventory.InventoryViewModel;
import use_case.collection.add_item.AddItemDataAccessInterface;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;
import view.InventoryView;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class AddItemTest {

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

        return (JButton) buttons.getComponent(num); // this should be the clear button
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


    public void testAddInventoryOneItem() {


    }
}
