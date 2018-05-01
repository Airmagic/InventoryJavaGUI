import javax.swing.*;
import java.awt.*;

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

    NewOrUpdateItem() {

        setContentPane(newOrUpdateform);
        setPreferredSize(new Dimension(500, 1000));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(false);

        getItem(); //getting the item if one it sent
    }



    private  void getItem(){

    }

    private void addNewItem() {
        Item item = new Item(ownersNameTxFd.getText(), itemsNameTxFd.getText(), locationTxFd.getText(), whereBoughtTxFd.getText(), costTxFd.getText(), websiteTxFd.getText(), whoBarrowedTxFd.getText(), whenBarrowedTxFd.getText(), returnTxFd.getText(), wherebarrowed.getText());
        ItemsClient.addItem(this, item);
    }

}
