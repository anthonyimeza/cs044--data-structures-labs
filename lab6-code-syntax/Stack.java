
//Generic used for reusability instead of hardcoding Character
interface Stack<E> {

    //Returns number of elements in stack (in this case, characters)
    int size();

    //Checks if stack is empty
    boolean isEmpty();

    //Inserts element to the top of the stack (in this case, characters)
    void push(E c);

    //Returns top element from the stack (in this case, characters)
    E top();

    //Removes + returns top element from stack (in this case, characters)
    E pop();

}