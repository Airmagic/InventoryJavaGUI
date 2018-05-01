import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ItemsGUI extends JFrame {
    private JPanel mainPanel;
    private JList itemList;
    private JButton addNewItemBtn;

    private DefaultListModel<Item> listModel;

    private int rightClickTaskIndex;  // To keep track of which list item was right-clicked on.

    ItemsGUI() {

        setContentPane(mainPanel);
        setPreferredSize(new Dimension(500, 1000));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

//        This is the button for adding task to the list
        addNewItemBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewItem();
            }
        });

        configureList();  // Bunch of JList setup

        getAllItems();  // And get initial list of tasks

    }

    private void configureList() {

        // When a item is clicked on, toggle between complete and not complete.
        itemList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                updateItemIsLoaned();
            }
        });

        // The model contains a list of Task objects to be displayed in the list
        listModel = new DefaultListModel<>();
        itemList.setModel(listModel);

        // Only want to select one item at a time.
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Create pop-up menu, with one menu item.
        JPopupMenu rightClickMenu = new JPopupMenu();
        JMenuItem deleteTask = new JMenuItem("Update");
        JMenuItem urgentTask = new JMenuItem("Delete");

        // Add the action listener for clicking on the Delete menu option.
        deleteTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemList.setSelectedIndex(e.getID());
                deleteitem();
            }
        });

        urgentTask.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                itemList.setSelectedIndex(e.getID());
                urgentTask();

            }
        });

        rightClickMenu.add(updateItem);
        rightClickMenu.add(deleteItem);


        itemList.setComponentPopupMenu(rightClickMenu);

        // A lot of code to remember which item the user right-clicked on
        itemList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rightClickTaskIndex = itemList.locationToIndex(e.getPoint());
                //rightClickTaskIndex =
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }


            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    // Used to disable the task list while updates are in progress.
    private void enableGUI(boolean enabled) {
        itemList.setEnabled(enabled);
    }

    //    This function sets the gui to false and sends to taskclient getall task
    private void getAllTasks() {
        enableGUI(false);
        ItemsClient.getAllItems(this);
    }


    private void addNewItem() {
        enableGUI(false);
        Item item = new Item(newItemText.getText(), urgentCheckBox.isSelected());
        newItemText.setText("");
        urgentCheckBox.setSelected(false);
        TaskClient.addTask(this, task);
    }


    private void updateItemIsLoaned() {
        enableGUI(false);
        Item item = itemList.getSelectedValue();
        if (item != null) {
            item.setLoaned(!item.isLoaned());
            itemClient.updateItem(this, item);
        }

    }

    private void deleteTask() {
        enableGUI(false);
        try {
            Item item = listModel.elementAt(rightClickTaskIndex);
            if (item != null)  { itemsClient.deleteItem(this, item); }

        } catch (Exception e) {
            System.out.println(e);
            enableGUI(true);
        }
    }

    private void urgentTask() {
        enableGUI(false);
        Item item = listModel.elementAt(rightClickTaskIndex);
        if (item != null) {
            item.setUrgent(!item.isUrgent());
            ItemsClient.urgentTask(this, item);
        }
    }

    //    This goes to the function to get all task
    protected void tasksUpdated() {
        getAllItems();
    }



    protected void newTaskList(Item[] items) {

        System.out.println(items.length + " NEW Items");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                listModel = new DefaultListModel<>();
                for (Item i : items) {
                    listModel.addElement(i);
                }
                itemList.setModel(listModel);
                enableGUI(true);
            }
        });
    }


    public void taskError(Exception e) {
        System.err.println(e);
        enableGUI(true);
    }

}
