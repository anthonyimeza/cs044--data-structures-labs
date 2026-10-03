

public class LinkedQueue<E> implements Queue<E> {
    //Framework for LinkedList
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    //Check if head is nothing (therefore it's empty)
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    //
    @Override
    public void enqueue(E e) {

        Node<E> newest = new Node <>(e, null);

        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    //Checks if empty, else it returns the first element in the queue (head)
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        } else {
            return head.getElement();
        }
    }

    //Checks if empty, Stores head element in answer, moves head forward (removing previous front node)
    //Decreases size of queue, and makes sure no edge cases happens with the tail node
    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }
}
