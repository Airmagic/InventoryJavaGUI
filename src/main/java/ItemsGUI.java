import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//this class is a extention of the ItemsGUI form
public class ItemsGUI extends JFrame {
    private JPanel mainPanel;
    private JList itemList;
    private JButton addNewItemBtn;

//    Making a list model to use for the jlist
    private DefaultListModel<Item> listModel;

    private boolean clickedItem;
    private int rightClickIndex;  // To keep track of which list item was right-clicked on.

//    Setting the contents of the panels parameters
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

        // Create pop-up menu, with  menu items.
        JPopupMenu rightClickMenu = new JPopupMenu();
        JMenuItem updateItem = new JMenuItem("Update");
        JMenuItem deleteItem = new JMenuItem("Delete");

        // Add the action listener for clicking on the Delete menu option.
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemList.setSelectedIndex(e.getID());
//                made a method
                deleteitem();
            }
        });
//          Added a listener for update in the menu
        updateItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                itemList.setSelectedIndex(e.getID());
//                Made a method to call
                updateItem();

            }
        });

//        adding these to the right click menu
        rightClickMenu.add(updateItem);
        rightClickMenu.add(deleteItem);

//        making the rightclick when it is on the list
        itemList.setComponentPopupMenu(rightClickMenu);

        // A lot of code to remember which item the user right-clicked on
        itemList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rightClickIndex = itemList.locationToIndex(e.getPoint());
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


    // Used to disable the items list while updates are in progress.
    public void enableGUI(boolean enabled) {
        itemList.setEnabled(enabled);
    }

    //    This function sets the gui to false and sends to itemsclient getall task
    public void getAllItems() {
        enableGUI(false);
        ItemsClient.getAllItems(this);
    }

//        This function opens the other gui
    private void addNewItem() {
        Item item = null;
//            this.setVisible(false);
            new NewOrUpdateItem(item).setVisible(true); // Main Form to show after the Login Form..
            ItemsClient.getAllItems(this);

    }

//    This function gets the items opens the other gui
    private void updateItem(){
//    TODO: get item and send it to the form so it can fill in and update
        Item item = listModel.elementAt(rightClickIndex);
        if (item != null){
            new NewOrUpdateItem(item).setVisible(true);
        }
        getAllItems();
    }

//        This function is to delete an item when right clicked on
    private void deleteitem() {
//        enableGUI(false);
        try {
            Item item = listModel.elementAt(rightClickIndex);
            if (item != null)  { ItemsClient.deleteItem(this, item); }

            getAllItems();

        } catch (Exception e) {
            System.out.println(e);
            enableGUI(true);
        }
    }


    //    This goes to the function to get all Items
    protected void itemsUpdated() {
        getAllItems();
    }


// This function is to add new items to the list
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


//    This is to print out errors
    public void itemError(Exception e) {
        System.err.println(e);
        enableGUI(true);
    }

}
