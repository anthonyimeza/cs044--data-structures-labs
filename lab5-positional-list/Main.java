
//Inspiration from Resident Evil 4 Remake for items

public class Main {
    public static void main(String[] args) {
    //New Inventory Instance
        Inventory inventory = new Inventory();
        //Adding initial items to inventory
        System.out.println("---Inventory Test---");
        inventory.addItem(new Item("Green Herb"));
        inventory.addItem(new Item("Red Herb"));
        inventory.addItem(new Item("First Aid Spray"));
        inventory.addItem(new Item("Gunpowder"));

        //Display Test
        System.out.println("\n--- Current Inventory ---");
        inventory.display();
        //Craft Failure Check
        System.out.println("\n--- Crafting Item (Should Fail) ---");
        inventory.combineItem("Gunpowder", "Green Herb");
        //Craft Success Check
        System.out.println("\n--- Crafting Item (Should Pass) ---");
        inventory.combineItem("Green Herb", "Red Herb");

        //Post Craft Inventory Check
        System.out.println("\n--- Current Inventory ---");
        inventory.display();
    }
}
