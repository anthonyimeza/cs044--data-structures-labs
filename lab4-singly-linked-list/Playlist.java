

public class Playlist {

    private static class Node {

        Song song;
        Node next;

        Node (Song song) {
            this.song = song;
            this.next = null;
        }

    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;



    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void addSong(Song song) {

        Node newNode = new Node(song);

//Initializes head, tail, and playback
        if (head == null) {
            head = tail = currentNode = newNode;
        }
//Update for tail when addiing song
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void removeSong(String title) {

//Checks if playlist is empty
        if (head == null) {
            System.out.println("Playlist is empty. Nothing to remove.");
            return;
        }

//Trackers for current node and previous node
        Node current = head;
        Node predecessor = null;

//Search feature for looking song name up for removal
        while (current != null) {
            if (current.song.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Removing: " + current.song.getTitle());
                break;
            }

//Moves trackers forward
            predecessor = current;
            current = current.next;
        }
//If song couldn't be found
        if (current == null) {
            System.out.println("Song - " + title + "- was not found in the playlist.");
            return;
        }

//Removing head (updates tail as well if the list is empty)
        if (predecessor == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }

//Removing middle or tail (makes the predecessor the new tail if prev. tail was deleted)
        else {
            predecessor.next = current.next;
            if (current == tail) {
                tail = predecessor;
            }
        }

//Reset to head if current song playing is deleted
        if (current == currentNode) {
            currentNode = head;
        }
        size--;
    }


//Checks if head is null (meaning playlist is empty), otherwise regular playlist logic (front-to-back)
    public void playNext() {

        if (head == null) {
            System.out.println("There are no songs in the playlist to play.");
            return;
        }
/*
* Initial State - No playback yet (goes to start)
* Goes to next song if it's available
* Then loops back to beginning if reaches end of playlist
 */
        if (currentNode == null) {
            currentNode = head;
        } else if (currentNode.next != null) {
            currentNode = currentNode.next;
        } else {
            System.out.println("End of playlist reached. Looping back...");
            currentNode = head;
        }

        System.out.println("Now Playing: " + currentNode.song.getTitle() + " by " + currentNode.song.getArtist());

    }

//Temporary pointer at the head so traversing the list is safe
    public void displayPlaylist() {

        Node tempNode = head;

// Check for songs before looping
        if (head == null) {
            System.out.println("The Playlist is empty. Please add songs.");
            return;
        }

//Goes through list until it reaches end
        while (tempNode != null) {
            System.out.println("Song: " + tempNode.song.getTitle() + " by " + tempNode.song.getArtist());
            tempNode = tempNode.next;
        }

    }
}
