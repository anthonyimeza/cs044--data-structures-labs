import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Inventory {

    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
    //Adds the item to the ArrayList
        items.add(item);

    }

    public void combineItem(String name1, String name2) {
    //Items necessary for crafting
        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();;

//Search function
        while (iter.hasNext()) {

            Item current = iter.next();
        //Since this is checking for both, there needs to be individual checks for both item names.
            if (current.getName().equals(name1) || current.getName().equals(name2)) {
                //1st Item Check
                if(current.getName().equals(name1) && !found1) {
                    found1 = true;
                    iter.remove();
                }
                //2nd Item Check
                else if(current.getName().equals(name2) && !found2) {
                    found2 = true;
                    iter.remove();
                }
                //Both are required items are found
                if  (found1 && found2) {
                    break; //Stops search function
                }
            }
        }
    //Moves onto the combination part
        if (found1 && found2) {

            String combinedResult = null;

            //Check for a valid recipe
            if ((name1.equals("Green Herb") && name2.equals("Red Herb")) ||
                    (name1.equals("Red Herb") && name2.equals("Green Herb"))) {
                combinedResult = "Mixed Herb (G+R)";
            }
            //If valid recipe was found
            if (combinedResult != null) {
                items.add(new Item(combinedResult));
                System.out.println("Combined " + name1 + " and " + name2 + " into: " + combinedResult);
            } else {
            //Fail State: Unrecognized Recipe, returns items
                items.add(new Item(name1));
                items.add(new Item(name2));
                System.out.println("Cannot combine " + name1 + " and " + name2 + ": Unknown recipe.");
            }


        } else {
            //Fail state: Missing Items
            //Item 1 Return
            if (found1) {
                items.add(new Item(name1));
            }
            //Item 2 Return
            if (found2) {
                items.add(new Item(name2));
            }
            System.out.println("Combination failed. You do not have the required item.");
        }
    }

    public void display() {
    //Enhanced for loop to check as many items in the ArrayList and print them.
        for (Item current :items) {
            System.out.println(current);
        }

    }

}
