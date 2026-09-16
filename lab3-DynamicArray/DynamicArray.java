
import java.util.Arrays;

public class DynamicArray<T> {


    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

//Creates Array with a generic type preset size
    public DynamicArray(){
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }


//Before adding an element, checks size and resizes if necessary
    public void add(T element){
        if (size == data.length){
            resize();
        }
//Adds the element to the data array,
        data[size++] = element;
    }


/*
*Checks if index is valid (shouldn't be negative or above size cap)
*
* Returns item if valid
*/
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + " | Size: " + size);
        }
        return data[index];
    }


//Same thing as above, validity check but for removing an element
    public T remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + " | Size: " + size);
        }
        T removedElement = data[index];

//Loop so it shifts element to left
        for (int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
//Changes last active spot in array to null since items have been shifted, then reduces size.
        data[size - 1] = null;
        size--;
        return removedElement;
    }


    public int size() {
        return size;
    }


//Uses Java's Arrays class for convenient method to copy Array for resizing
    private void resize(){
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }

}