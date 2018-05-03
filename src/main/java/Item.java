//Creating a class to make item objects
//base was created by Clara James
public class Item {
//    creating the variables that will be use for the items
    private Long id;
    private String user;
    private String itemName;
    private String location;
    private String whereBought;
    private String whenBought;
    private String cost;
    private String website;
    private String whoBarrowed;
    private String whenBarrowed;
    private String whenReturned;
    private String whereBarrowed;

    public Item() {}// empty constructor, you need this

//    basic constructor when building the objects
    public Item(String user, String itemName, String location, String whereBought, String whenBought, String cost, String website, String whoBarrowed, String whenBarrowed, String whenReturned, String whereBarrowed) {
        this.user = user;
        this.itemName = itemName;
        this.location = location;
        this.whereBought = whereBought;
        this.whenBought = whenBought;
        this.cost = cost;
        this.website = website;
        this.whoBarrowed = whoBarrowed;
        this.whenBarrowed = whenBarrowed;
        this.whenReturned = whenReturned;
        this.whereBarrowed = whereBarrowed;
    }

//    getters and setter for all the variables so they are changible
    public void setWhenBought(String whenBought) {
        this.whenBought = whenBought;
    }



    public String getWhenBought() {

        return whenBought;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public String getItemName() {
        return itemName;
    }

    public String getLocation() {
        return location;
    }

    public String getWhereBought() {
        return whereBought;
    }

    public String getCost() {
        return cost;
    }

    public String getWebsite() {
        return website;
    }

    public String getWhoBarrowed() {
        return whoBarrowed;
    }

    public String getWhenBarrowed() {
        return whenBarrowed;
    }

    public String getWhenReturned() {
        return whenReturned;
    }

    public String getWhereBarrowed() {
        return whereBarrowed;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWhereBought(String whereBought) {
        this.whereBought = whereBought;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setWhoBarrowed(String whoBarrowed) {
        this.whoBarrowed = whoBarrowed;
    }

    public void setWhenBarrowed(String whenBarrowed) {
        this.whenBarrowed = whenBarrowed;
    }

    public void setWhenReturned(String whenReturned) {
        this.whenReturned = whenReturned;
    }

    public void setWhereBarrowed(String whereBarrowed) {
        this.whereBarrowed = whereBarrowed;
    }


//    This is a string of the each item when they are printed out as a dictionary
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", itemName='" + itemName + '\'' +
                ", location='" + location + '\'' +
                ", whereBought='" + whereBought + '\'' +
                ", cost='" + cost + '\'' +
                ", website='" + website + '\'' +
                ", whoBarrowed='" + whoBarrowed + '\'' +
                ", whenBarrowed='" + whenBarrowed + '\'' +
                ", whenReturned='" + whenReturned + '\'' +
                ", whereBarrowed='" + whereBarrowed + '\'' +
                '}';
    }

//    This is a string just so I can use for the Jlist
    public String listToString() {
        return "Item{" +
                "user='" + user + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
