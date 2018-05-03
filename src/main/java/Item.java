public class Item {
    private Long id;
    private String user;
    private String itemName;
    private String location;
    private String whereBought;
    private String cost;
    private String website;
    private String whoBarrowed;
    private String whenBarrowed;
    private String whenReturned;
    private String whereBarrowed;

    public Item() {}// empty constructor, you need this


    public Item(String user, String itemName, String location, String whereBought, String cost, String website, String whobarrowed, String whenBarrowed, String whenReturned, String whereBarrowed) {
        this.user = user;
        this.itemName = itemName;
        this.location = location;
        this.whereBought = whereBought;
        this.cost = cost;
        this.website = website;
        this.whoBarrowed = whoBarrowed;
        this.whenBarrowed = whenBarrowed;
        this.whenReturned = whenReturned;
        this.whereBarrowed = whereBarrowed;
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
}
