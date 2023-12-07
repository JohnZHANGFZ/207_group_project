package view;

import interface_adapter.add_inventory.AddInventoryController;
import interface_adapter.add_inventory.AddInventoryState;
import interface_adapter.add_inventory.AddInventoryViewModel;


import interface_adapter.delete_inventory.DeleteInventoryController;
import interface_adapter.delete_inventory.DeleteInventoryState;
import interface_adapter.delete_inventory.DeleteInventoryViewModel;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.restriction.RestrictionState;
import interface_adapter.restriction.RestrictionViewModel;
import interface_adapter.return_home.ReturnController;

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
    private final AddInventoryViewModel addInventoryViewModel;
    private final AddInventoryController addInventoryController;
   

    private final DeleteInventoryViewModel deleteInventoryViewModel;
    private final DeleteInventoryController deleteInventoryController;

    private final ReturnController returnController;

    final JButton add;
    final JButton delete;
    final JButton cancel;
    JTextArea restrictionInfo;

    public RestrictionView(RestrictionViewModel restrictionViewModel,
                           AddInventoryViewModel addInventoryViewModel,
                           AddInventoryController addInventoryController,
                           DeleteInventoryViewModel deleteInventoryViewModel,
                           DeleteInventoryController deleteInventoryController,
                           ReturnController returnController) {
        this.restrictionViewModel = restrictionViewModel;
        this.addInventoryViewModel = addInventoryViewModel;
        this.addInventoryController = addInventoryController;
        this.deleteInventoryViewModel = deleteInventoryViewModel;
        this.deleteInventoryController = deleteInventoryController;        
        this.returnController = returnController;

        JLabel title = new JLabel("Restriction Screen");
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
                            AddInventoryState currentState = addInventoryViewModel.getState();

                            addInventoryController.execute(currentState.getIngredients());
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
                            DeleteInventoryState currentState = deleteInventoryViewModel.getState();

                            deleteInventoryController.execute(currentState.getUsername(), currentState.getIngredients());
                            //a popup window telling the user what has been deleted
                            JOptionPane.showMessageDialog(null, currentState.getIngredients());
                        }
                    }
                }
        );

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(cancel)) {
                    returnController.execute();
                }
            }
        });


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

        //TODO: this should be initialized properly before adding to the panel
        JTextArea restrictionInfo = new JTextArea();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(restrictionInfo);
        this.add(itemInfo);
        this.add(buttons);
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
        restrictionInfo.setText(state.getRestriction());
    }
}
