import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This is the panel for viewing, updating, or making new item
public class NewOrUpdateItem extends JFrame{
    private JPanel newOrUpdateform;
    private JLabel idNumberLabel;
    private JTextField itemsNameTxFd;
    private JLabel idNumberResult;
    private JLabel nameLabel;
    private JLabel itemLabel;
    private JLabel LocationLabel;
    private JLabel whereBoughtLabel;
    private JLabel costLabel;
    private JLabel websitelabel;
    private JLabel boughtLable;
    private JLabel barrowedLabel;
    private JLabel dateBarrowed;
    private JLabel whenreturned;
    private JLabel wherebarrowed;
    private JTextField ownersNameTxFd;
    private JTextField locationTxFd;
    private JTextField whereBoughtTxFd;
    private JTextField whenBoughtTxFd;
    private JTextField costTxFd;
    private JTextField websiteTxFd;
    private JTextField whoBarrowedTxFd;
    private JTextField whenBarrowedTxFd;
    private JTextField returnTxFd;
    private JTextField barrowedLocationTxFd;
    private JButton enterBtn;

//    Setting the contents of the panels parameters
    NewOrUpdateItem() {

        setContentPane(newOrUpdateform);
        setPreferredSize(new Dimension(500, 700));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(false);

        getItem(); //getting the item if one it sent

//        Creating a listener for the enter button
        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterItemInfo();
            }
        });
    }

//    This function is to add or update information when user is done entering
    private void enterItemInfo(){
//    TODO: make it so the user can enter and save information to the API
    }


    private  void getItem(){
//  TODO: Make it so you can get information on one items and it is put into all the fields
    }

//  This Function is to send a new item to the API
    private void addNewItem() {
        Item item = new Item(ownersNameTxFd.getText(), itemsNameTxFd.getText(), locationTxFd.getText(), whereBoughtTxFd.getText(), whenBoughtTxFd.getText(), costTxFd.getText(), websiteTxFd.getText(), whoBarrowedTxFd.getText(), whenBarrowedTxFd.getText(), returnTxFd.getText(), barrowedLocationTxFd.getText());
        ItemsClient.addItem(this, item);
    }

//    This function is to send updates to the API
    public void itemsUpdated(){

    }

//    This is for errors
    public void itemError(Exception e) {
        System.err.println(e);
        new ItemsGUI().setVisible(true);
    }
}
