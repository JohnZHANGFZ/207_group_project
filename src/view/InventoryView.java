package view;

import interface_adapter.add_item.AddItemController;
import interface_adapter.add_item.AddItemState;
import interface_adapter.add_item.AddItemViewModel;
import interface_adapter.inventory.InventoryViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InventoryView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Inventory";
    private final InventoryViewModel inventoryViewModel;
    private final AddItemViewModel addItemViewModel;
    private final AddItemController addItemController;

    final JButton add;
    final JButton delete;
    final JButton cancel;


    public InventoryView(InventoryViewModel inventoryViewModel,
                         AddItemViewModel addItemViewModel,
                         AddItemController addItemController) {
        this.inventoryViewModel = inventoryViewModel;
        this.addItemViewModel = addItemViewModel;
        this.addItemController = addItemController;

        JLabel title = new JLabel("Inventory Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //TODO: add inventory info

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
                        }
                    }
                }
        );

        delete.addActionListener(
                // TODO: implemented actionPerformed for 'delete' button after merged interface adapter for delete_item
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );

        //TODO: implemented action listener method for 'cancel' buttons
        cancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
