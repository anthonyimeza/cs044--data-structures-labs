
 class Main {
     public static void main(String[] args) {

        DynamicArray<String> list = new DynamicArray<>();

        System.out.println("Adding Items to the Array...\n");

         list.add("ITEM 1");
         list.add("ITEM 2");
         list.add("ITEM 3");
         list.add("ITEM 4");
         list.add("ITEM 5");
         list.add("ITEM 6");
         list.add("ITEM 7");
         list.add("ITEM 8");
         list.add("ITEM 9");
         list.add("ITEM 10");
         list.add("ITEM 11");

         System.out.println("Testing size method... - Array size is: " + list.size() + "\n");

         System.out.println("Testing the get method... - Index 4 is: " + list.get(4) + "\n");

         System.out.println("Testing the remove method... - Removing Index 7: " + list.get(7));
         String removedItem = list.remove(7);
         System.out.println("Check - Removed: " + removedItem);
         System.out.println("Checking Index 7... - It is now " + list.get(7) + "\n");

         System.out.println("Testing resize... - Current size is: " + list.size());
         for (int i = 0; i < 9; i++){
             list.add("OBJECT " + (i + 1));
         }

         System.out.println("Added 9 items to the Array. Size is now: " + list.size());
         System.out.println("Now checking new Index at 16.. It is: " + list.get(16) + "\n");

         System.out.println("Now checking an Invalid Index -1 (Should return Error)\n");
         System.out.println("This text shouldn't display - Index -1 is: " + list.get(-1));



     }
}
