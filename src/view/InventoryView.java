package view;

import interface_adapter.add_inventory.AddInventoryController;
import interface_adapter.add_inventory.AddInventoryState;
import interface_adapter.add_inventory.AddInventoryViewModel;
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
import java.util.ArrayList;

public class InventoryView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Inventory";
    private final InventoryViewModel inventoryViewModel;
    private final AddInventoryViewModel addInventoryViewModel;
    private final AddInventoryController addInventoryController;
    private final DeleteItemViewModel deleteItemViewModel;
    private final DeleteItemController deleteItemController;

    JTextArea inventoryInfo;

    private final JTextField itemInputField = new JTextField(15);

    final JButton add;
    final JButton delete;
    final JButton cancel;


    public InventoryView(InventoryViewModel inventoryViewModel,
                         AddInventoryViewModel addInventoryViewModel,
                         AddInventoryController addInventoryController,
                         DeleteItemViewModel deleteItemViewModel,
                         DeleteItemController deleteItemController) {
        this.inventoryViewModel = inventoryViewModel;
        this.addInventoryViewModel = addInventoryViewModel;
        this.addInventoryController = addInventoryController;
        this.deleteItemViewModel = deleteItemViewModel;
        this.deleteItemController = deleteItemController;

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
                            InventoryState currentState = inventoryViewModel.getState();
                            String stringIngredient = currentState.getInput();
                            ArrayList<String> listIngredient = new ArrayList<>();


                            addInventoryController.execute(currentState.getUser(), listIngredient);
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
        inventoryInfo.setText(state.getInventory());
    }
}
