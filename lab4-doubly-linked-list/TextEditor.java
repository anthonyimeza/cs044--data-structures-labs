

public class TextEditor {
    private static class Node{
        String textState;
        Node prev;
        Node next;

        public Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;

    }

//updatedText so it combines both the previous text and new text (starts off with nothing as seen above)
    public void add(String newText) {
        String updatedText = currentNode.textState + newText;

        Node newNode = new Node(updatedText, currentNode, null);

//Updates redo
        currentNode.next = newNode;

        currentNode = newNode;
    }

//Check if there's anything stored in the undo function
    public String undo() {
        if (currentNode.prev !=null) {
            currentNode = currentNode.prev;
        } else {
            System.out.println("There's nothing to undo.");
        }
        return currentNode.textState;
    }

//Checks if there's anything stored in the redo function
    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
        } else {
            System.out.println("There's nothing to redo.");
        }
        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println(currentNode.textState);
    }

}
