
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    TextEditor editor = new TextEditor();
    int choice;

        do {
            System.out.println("---TextEditor Testing---");
            System.out.println("1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Print Current Text");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println("");

            switch (choice) {

                case 1:
                    System.out.print("Enter the text to add: ");
                    String userText = sc.nextLine();
                    editor.add(userText);
                    editor.printCurrent();
                    System.out.println("");
                    break;

                case 2:
                    editor.undo();
                    editor.printCurrent();
                    System.out.println("");
                    break;

                case 3:
                    editor.redo();
                    editor.printCurrent();
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("Your current text:"); editor.printCurrent();
                    System.out.println("");
                    break;

                case 5:
                    System.out.println("Stopping the TextEditor Test...");
                    System.out.println("");
                    break;

                default:
                    System.out.println("Invalid Option. Please try again.");
            }
        } while (choice != 5); {
            sc.close();
        }
    }
}