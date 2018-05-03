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
        setPreferredSize(new Dimension(500, 700));
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


        // The model contains a list of Task objects to be displayed in the list
        listModel = new DefaultListModel<>();
        itemList.setModel(listModel);

        // Only want to select one item at a time.
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Create pop-up menu, with one menu item.
        JPopupMenu rightClickMenu = new JPopupMenu();
        JMenuItem updateItem = new JMenuItem("Update");
        JMenuItem deleteItem = new JMenuItem("Delete");

        // Add the action listener for clicking on the Delete menu option.
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemList.setSelectedIndex(e.getID());
                deleteitem();
            }
        });

        updateItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                itemList.setSelectedIndex(e.getID());
                updateItem();

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
    public void enableGUI(boolean enabled) {
        itemList.setEnabled(enabled);
    }

    //    This function sets the gui to false and sends to taskclient getall task
    private void getAllItems() {
        enableGUI(false);
        ItemsClient.getAllItems(this);
    }

    private void addNewItem() {
//            this.setVisible(false);
            new NewOrUpdateItem().setVisible(true); // Main Form to show after the Login Form..
    }

    private void updateItem(){

    }

    private void deleteitem() {
        enableGUI(false);
        try {
            Item item = listModel.elementAt(rightClickTaskIndex);
            if (item != null)  { ItemsClient.deleteItem(this, item); }

        } catch (Exception e) {
            System.out.println(e);
            enableGUI(true);
        }
    }


    //    This goes to the function to get all task
    protected void itemsUpdated() {
        getAllItems();
    }



    protected void newItemList(Item[] items) {

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


    public void itemError(Exception e) {
        System.err.println(e);
        enableGUI(true);
    }

}
