
//Utilizing the ArrayStack class from the textbook

public class ArrayStack<E> implements Stack<E> {

    public static final int defaultCAP = 1000; //Default Array Capacity
    private E[] data; //Generic Array for Storage
    private int t = -1; //Index at top element in stack
    public ArrayStack() {this(defaultCAP);} //Construct stack with default capacity
    public ArrayStack(int capacity) { //Construct stack with given capacity
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return (t + 1);
    }

    //Checks if Stack is empty
    @Override
    public boolean isEmpty() {
        return (t == -1);
    }
    //Check if array is full, otherwise adds element to index
    @Override
    public void push (E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full.");
        data[++t] = e; //Increases index before adding element to correctly place it on the index
    }

    //Check if empty, otherwise returns the top index
    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }
    //Check if empty, stores top element in answer, removes top element from Stack, moves index down, then returns answer.
    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
}
