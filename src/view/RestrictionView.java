package view;

import entity.CommonRestriction;
import interface_adapter.add_item.AddItemController;
import interface_adapter.add_item.AddItemState;
import interface_adapter.add_item.AddItemViewModel;
import interface_adapter.delete_item.DeleteItemController;
import interface_adapter.delete_item.DeleteItemState;
import interface_adapter.delete_item.DeleteItemViewModel;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.restriction.RestrictionState;
import interface_adapter.restriction.RestrictionViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RestrictionView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Restriction";
    private final JTextField itemInputField = new JTextField(15);

    private final RestrictionViewModel restrictionViewModel;
    private final AddItemViewModel addItemViewModel;
    private final AddItemController addItemController;
    private final DeleteItemViewModel deleteItemViewModel;
    private final DeleteItemController deleteItemController;
    private final CommonRestriction restriction;

    final JButton add;
    final JButton delete;
    final JButton cancel;

    public RestrictionView(RestrictionViewModel restrictionViewModel,
                           AddItemViewModel addItemViewModel,
                           AddItemController addItemController,
                           DeleteItemViewModel deleteItemViewModel,
                           DeleteItemController deleteItemController,
                           CommonRestriction restriction) {
        this.restrictionViewModel = restrictionViewModel;
        this.addItemViewModel = addItemViewModel;
        this.addItemController = addItemController;
        this.deleteItemViewModel = deleteItemViewModel;
        this.deleteItemController = deleteItemController;
        this.restriction = restriction;

        JLabel title = new JLabel("Restriction Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Enter Items: "), itemInputField);

        //TODO: not sure if this is correct
        JLabel restrictionInfo = new JLabel(String.valueOf(restriction.getItems()));

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

        //a typing box for user to enter items
        itemInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                RestrictionState currentState = restrictionViewModel.getState();
                currentState.setRestriction(itemInputField.getText() + e.getKeyChar());
                restrictionViewModel.setState(currentState);
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
        RestrictionState state = (RestrictionState) evt.getNewValue();
        if (state.getRestrictionError() != null) {
            JOptionPane.showMessageDialog(this, state.getRestrictionError());
        }
    }
}
