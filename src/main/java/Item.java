public class Item {
    private Long id;
    private String text;
    private boolean urgent;
    private boolean loaned = false;

    public Item() {}

    public Item(String text, boolean urgent) {
        this.text = text;
        this.urgent = urgent;
    }   // empty constructor, you need this

    public Item(String text, boolean urgent, boolean loaned) {
        this.text = text;
        this.urgent = urgent;
        this.loaned = loaned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public boolean isLoaned() {
        return loaned;
    }

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }


    @Override
    public String toString() {
        return (urgent ? "URGENT! " : " ") +
                text +
                ", loaned? " + (loaned ? "Loaned Out" : "Not Loaned");
    }
}
