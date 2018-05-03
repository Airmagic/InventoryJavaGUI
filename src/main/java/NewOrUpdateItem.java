import javax.swing.*;
import java.awt.*;

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

//    Packing the window and setting up so vari
    NewOrUpdateItem() {

        setContentPane(newOrUpdateform);
        setPreferredSize(new Dimension(500, 700));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(false);

        getItem(); //getting the item if one it sent
    }



    private  void getItem(){

    }


    private void addNewItem() {
        Item item = new Item(ownersNameTxFd.getText(), itemsNameTxFd.getText(), locationTxFd.getText(), whereBoughtTxFd.getText(), whenBoughtTxFd.getText(), costTxFd.getText(), websiteTxFd.getText(), whoBarrowedTxFd.getText(), whenBarrowedTxFd.getText(), returnTxFd.getText(), barrowedLocationTxFd.getText());
        ItemsClient.addItem(this, item);
    }

    public void itemsUpdated(){

    }
    public void itemError(Exception e) {
        System.err.println(e);
        new ItemsGUI().setVisible(true);
    }
}
