

public class Item {

//Variable for name of Item
    private String name;

//Item Creation
    public Item(String name) {
        this.name = name;
    }

//Getter
    public String getName() {
        return name;
    }

//Setter (Just in case for renaming for whatever reason)
    public void setName(String name) {
        this.name = name;
    }

//Returns Item name
    @Override
    public String toString() {
        return "Item: " + name;
    }
}