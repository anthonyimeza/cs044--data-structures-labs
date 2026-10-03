
//Generic for usability
interface Queue <E> {

    //Returns number of element iin queue
    int size();

    //Check if queue is empty
    boolean isEmpty();

    //Insert element at back of queue
    void enqueue(E e);

    //Returns element in front of queue
    E peek();

    //Removes + Returns element at front of queue
    E dequeue();

}
