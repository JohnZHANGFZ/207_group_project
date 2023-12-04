package view;

import entity.CommonInventory;
import interface_adapter.add_item.AddItemController;
import interface_adapter.add_item.AddItemState;
import interface_adapter.add_item.AddItemViewModel;
import interface_adapter.delete_item.DeleteItemController;
import interface_adapter.delete_item.DeleteItemState;
import interface_adapter.delete_item.DeleteItemViewModel;
import interface_adapter.inventory.InventoryState;
import interface_adapter.inventory.InventoryViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InventoryView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Inventory";
    private final InventoryViewModel inventoryViewModel;
    private final AddItemViewModel addItemViewModel;
    private final AddItemController addItemController;
    private final DeleteItemViewModel deleteItemViewModel;
    private final DeleteItemController deleteItemController;

    //TODO am I allowed to do this????
    private final CommonInventory inventory;

    private final JTextField itemInputField = new JTextField(15);

    final JButton add;
    final JButton delete;
    final JButton cancel;


    public InventoryView(InventoryViewModel inventoryViewModel,
                         AddItemViewModel addItemViewModel,
                         AddItemController addItemController,
                         DeleteItemViewModel deleteItemViewModel,
                         DeleteItemController deleteItemController,
                         CommonInventory inventory) {
        this.inventoryViewModel = inventoryViewModel;
        this.addItemViewModel = addItemViewModel;
        this.addItemController = addItemController;
        this.deleteItemViewModel = deleteItemViewModel;
        this.deleteItemController = deleteItemController;
        this.inventory = inventory;

        JLabel title = new JLabel("Inventory Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Enter Items: "), itemInputField);

        //TODO not sure if this is correct way to display inventory info
        JLabel inventoryInfo = new JLabel(String.valueOf(inventory.getItems()));


        //Add buttons
        JPanel buttons = new JPanel();

        add = new JButton(InventoryViewModel.ADD_BUTTON_LABEL);
        buttons.add(add);
        delete = new JButton(InventoryViewModel.DELETE_BUTTON_LABEL);
        buttons.add(delete);
        cancel = new JButton(InventoryViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);


        add.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(add)) {
                            AddItemState currentState = addItemViewModel.getState();

                            addItemController.execute(currentState.getIngredients());
                            //a popup window telling the user what has been added
                            JOptionPane.showMessageDialog(null, currentState.getIngredients());
                        }
                    }
                }
        );

        delete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(delete)) {
                            DeleteItemState currentState = deleteItemViewModel.getState();

                            deleteItemController.execute(currentState.getIngredients());
                            //a popup window telling the user what has been deleted
                            JOptionPane.showMessageDialog(null, currentState.getIngredients());
                        }
                    }
                }
        );

        //TODO: implemented action listener method for 'cancel' buttons
        cancel.addActionListener(this);


        //a typing box for users to type what they want to add or delete
        itemInputField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                InventoryState currentState = inventoryViewModel.getState();
                currentState.setInventory(itemInputField.getText() + e.getKeyChar());
                inventoryViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        InventoryState state = (InventoryState) evt.getNewValue();
        if (state.getInventoryError() != null) {
            JOptionPane.showMessageDialog(this, state.getInventoryError());
        }
    }
}
