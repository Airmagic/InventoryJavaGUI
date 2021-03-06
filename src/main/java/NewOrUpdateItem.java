import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
    private JButton cancelBtn;

    //    Setting the contents of the panels parameters
    NewOrUpdateItem(Item item) {

        setContentPane(newOrUpdateform);
        setPreferredSize(new Dimension(500, 700));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        This is to open the main screen when the button on the
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();

            }
        });
        pack();
        setVisible(false);

        if (item != null) {
            itemsUpdated(item); //getting the item if one it sent
        }
        else{
//            to put text in the enter button
            addNewItemform();
        }
//        Creating a listener for the enter button
        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean update;

                if (item == null){
                    update = false;
                }
                else{
                    update = true;
                }
                enterItemInfo(update, item);
            }
        });


        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });


    }

//    This is for the cancel button
    private void exit(){
        ItemsGUI gui = new ItemsGUI();
        this.dispose();
    }

//    This function is to add or update information when user is done entering
    private void enterItemInfo(boolean update, Item item){
//    make it so the user can enter and save information to the API
        if (update == false){
            addNewItem();
        }
        else{
            updateItem(item);
        }
        ItemsGUI gui = new ItemsGUI();
        this.dispose();


    }



    private  void getItem(Item item){
//  Make it so you can get information on one items and it is put into all the fields
            ItemsClient.getOneItem(this, item);
            }

// This is for the text in the enter button
    private void addNewItemform(){
        enterBtn.setText("Add New Item");
    }

//  This Function is to send a new item to the API
    private void addNewItem() {
        Item item = new Item(ownersNameTxFd.getText(), itemsNameTxFd.getText(), locationTxFd.getText(), whereBoughtTxFd.getText(), whenBoughtTxFd.getText(), costTxFd.getText(), websiteTxFd.getText(), whoBarrowedTxFd.getText(), whenBarrowedTxFd.getText(), returnTxFd.getText(), barrowedLocationTxFd.getText());
        ItemsClient.addItem(this, item);

    }

//    This function is to send updates to the API
    public void itemsUpdated(Item item){

        enterBtn.setText("Update - " + item.getItemName());
        idNumberResult.setText(String.valueOf(item.getId()));
        ownersNameTxFd.setText(item.getUser());
        itemsNameTxFd.setText(item.getItemName());
        locationTxFd.setText(item.getLocation());
        whereBoughtTxFd.setText(item.getWhereBought());
        whenBoughtTxFd.setText(item.getWhenBought());
        costTxFd.setText(item.getCost());
        websiteTxFd.setText(item.getWebsite());
        whoBarrowedTxFd.setText(item.getWhoBarrowed());
        whenBarrowedTxFd.setText(item.getWhenBarrowed());
        returnTxFd.setText(item.getWhenReturned());
        barrowedLocationTxFd.setText(item.getWhenBarrowed());

    }


    private void updateItem(Item item){
        item.setId(Long.parseLong(idNumberResult.getText()));
        item.setUser(ownersNameTxFd.getText());
        item.setItemName(itemsNameTxFd.getText());
        item.setLocation(locationTxFd.getText());
        item.setWhenBought(whenBoughtTxFd.getText());
        item.setCost(costTxFd.getText());
        item.setWebsite(websiteTxFd.getText());
        item.setWhoBarrowed(whoBarrowedTxFd.getText());
        item.setWhenBarrowed(whenBarrowedTxFd.getText());
        item.setWhenReturned(returnTxFd.getText());
        item.setWhereBarrowed(barrowedLocationTxFd.getText());


        ItemsClient.updateItem(this, item);

    }
//    This is for errors
    public void itemError(Exception e) {
        System.err.println(e);
        new ItemsGUI().setVisible(true);
    }
}
