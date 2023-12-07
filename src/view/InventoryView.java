package view;

import interface_adapter.add_item.AddItemController;
import interface_adapter.add_item.AddItemState;
import interface_adapter.add_item.AddItemViewModel;
import interface_adapter.delete_inventory.DeleteInventoryController;
import interface_adapter.delete_inventory.DeleteInventoryState;
import interface_adapter.delete_inventory.DeleteInventoryViewModel;
import interface_adapter.inventory.InventoryState;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.return_home.ReturnController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;

public class InventoryView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Inventory";
    private final InventoryViewModel inventoryViewModel;
    private final AddItemViewModel addItemViewModel;
    private final AddItemController addItemController;
    private final DeleteInventoryViewModel deleteInventoryViewModel;
    private final DeleteInventoryController deleteInventoryController;


    private final ReturnController returnController;


    JTextArea inventoryInfo;

    private final JTextField itemInputField = new JTextField(15);

    final JButton add;
    final JButton delete;
    final JButton cancel;


    public InventoryView(InventoryViewModel inventoryViewModel,
                         AddItemViewModel addItemViewModel,
                         AddItemController addItemController,
                         DeleteInventoryViewModel deleteInventoryViewModel,
                         DeleteInventoryController deleteInventoryController,
                         ReturnController returnController) {
        this.inventoryViewModel = inventoryViewModel;
        this.addItemViewModel = addItemViewModel;
        this.addItemController = addItemController;
        this.deleteInventoryViewModel = deleteInventoryViewModel;
        this.deleteInventoryController = deleteInventoryController;
        this.returnController = returnController;


        JLabel title = new JLabel("Inventory Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel itemInfo = new LabelTextPanel(
                new JLabel("Enter Items: "), itemInputField);



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
                            InventoryState currentState = inventoryViewModel.getState();
                            // DeleteInventoryState currentState = deleteInventoryViewModel.getState();

                            ArrayList currentInventory = new ArrayList();
                            currentInventory.addAll(Arrays.asList(currentState.getInventory().split(",")));
                            deleteInventoryController.execute(currentState.getUser(), currentInventory);
                            //a popup window telling the user what has been deleted
                            // JOptionPane.showMessageDialog(null, currentState.getIngredients());

                        }
                    }
                }
        );

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(cancel)) {
                    DeleteInventoryState deleteInventoryState = deleteInventoryViewModel.getState();
                    returnController.execute();
                    // TODO: display output here
                    JOptionPane.showMessageDialog(null, deleteInventoryState.getDeleteItemError());
                }
            }
        });


        //a typing box for users to type what they want to add or delete
        itemInputField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                InventoryState currentState = inventoryViewModel.getState();
                currentState.setInput(itemInputField.getText() + e.getKeyChar());
                inventoryViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        //TODO: this should be initialized properly
        JTextArea inventoryInfo = new JTextArea();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(inventoryInfo);
        this.add(itemInfo);
        this.add(buttons);
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
        inventoryInfo.setText(state.getInventory()); // current inventory info
    }
}
