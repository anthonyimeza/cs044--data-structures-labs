import java.util.Iterator;

public class LinkedPositionalList<E> implements Iterable<E> {

    private static class Node<E> implements Position<E> {

        private E element;
        private Node<E> prev;
        private Node<E> next;

        //Getters
        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        @Override
        public E getElement() {
            return element;
        }
        //Setters
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setElement(E element) {
            this.element = element;
        }
        //Node Constructor (each has an element and neighbors)
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }


    //Sentinel Nodes and starting Elements
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;


    public LinkedPositionalList() {
    //Creates Header and Trailer nodes, connects header to trailer, and initializes list size
        header = new Node<>(null, null,null);
        trailer = new Node<>(null,header, null);

        header.setNext(trailer);

        size = 0;
    }

    //Ensures Sentinel nodes are not shown
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null;
        } else {
            return node;
        }
    }

    //Validates position of Node
    private Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid Position.");
        }
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null) {
            throw new IllegalArgumentException("Position No Longer Valid.");
        }
        return node;
    }
    //Returns first positon of list
    public Position<E> first() {
        return position(header.getNext());
    }
    //Returns last position of list
    public Position<E> last() {
        return position(trailer.getPrev());
    }
    //Returns position before position P
    public Position <E> before(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }
    //Returns position after position P
    public Position <E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getNext());
    }



    //Adds element in between two nodes
    private Position<E> addBetween (E element, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<E>(element, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
        return position(newest);
    }
    //Adds element to the very beginning of list and returns position
    public Position<E> addFirst (E element) {
        return addBetween(element, header, header.getNext());
    }
    //Adds element to the very last place of list and returns positon
    public Position<E> addLast(E element) {
        return addBetween(element, trailer.getPrev(), trailer);
    }
    //Validates, then adds element before position p and returns position
    public Position<E> addBefore (Position<E> p, E element) {
        Node<E> node = validate(p);
        return addBetween(element, node.getPrev(), node);
    }
    //Validates, then adds element after position p and returns position
    public Position<E> addAfter (Position<E> p, E element) {
        Node<E> node = validate(p);
        return addBetween(element, node, node.getNext());
    }
    //Replaces the element at p with new element and returns previous element
    public E set(Position<E> p, E element) {
        Node<E> node = validate(p);
        E oldElement = node.getElement();
        node.setElement(element);
        return oldElement;
    }
    //Removes the element at p and returns removed element.
    //Also invalidates previous position so it cannot be reused.
    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        //Relinks node
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;

        E answer = node.getElement();
        //Invalidates previous node references
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);

        return answer;
    }


    private class ElementIterator implements Iterator<E> {
        Position<E> cursor = first(); //Tracks first point
        Position<E> recent = null; //Tracks recent point accessed

        public boolean hasNext() {
            return cursor != null;
        }

        public E next() {
            if (cursor == null) {
                throw new java.util.NoSuchElementException("No Next Element.");
            }
            recent = cursor;
            cursor = after(cursor);
            return recent.getElement();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

}
