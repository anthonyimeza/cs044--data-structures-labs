
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int choice;

        do {
            System.out.println("---Testing the Music Playlist---");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Song Title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter the Artist: ");
                    String artist = sc.nextLine();
                    playlist.addSong(new Song(title, artist));
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter the Title of the Song you want to remove: ");
                    String removeTitle = sc.nextLine();
                    playlist.removeSong(removeTitle);
                    System.out.println();
                    break;

                case 3:
                    playlist.playNext();
                    System.out.println();
                    break;

                case 4:
                    playlist.displayPlaylist();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Exiting the Music Playlist...");
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid Option.");
                    System.out.println();
            }
        } while (choice != 5);
        sc.close();
    }
}
