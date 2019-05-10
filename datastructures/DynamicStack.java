package datastructures;

/**
 * Class to create a Dynamic Stack comprising of any generic element T.
 * Implements the StackADT interface that enforces basic stack methods onto this class.
 * Uses a linked list under the hood
 *
 * @author ndesai
 * @version 30th January 2019
 * @see datastructures.LinkedList
 */
public class DynamicStack<T> implements StackADT<T> {
    private LinkedList<T> myList;

    /**
     * Creates an empty stack (based on a linked list).
     */
    public DynamicStack() {
        myList = new LinkedList<>();
    }

    /**
     * Adds the specified element to the top of the stack
     * @param element generic type element to be pushed
     */
    public void push( T element ) {
        myList.addFirst( element );
    }

    /**
     * Removes the element from the top of the stack and returns a reference to it, or null (if empty).
     * @return generic type element that has been popped
     */
    public T pop() {
        return myList.removeFirst();
    }

    /**
     * Returns a reference to the element at the top of the stack, or null (if empty).
     * @return generic type element
     */
    public T peek() {
        return myList.peekFirst();
    }

    /**
     * Returns true if the stack contains no elements, false otherwise.
     * @return boolean is the stack empty?
     */
    public boolean isEmpty() {
        return myList.isEmpty();
    }

    /**
     * Returns the number of elements in the stack.
     * @return integer size of stack
     */
    public int size() {
        return myList.size();
    }

    /**
     * Clears all elements from the stack
     */
    public void clear() {
        myList.clear();
    }

    /**
     *  Returns a String representation of the stack.
     * @return String containing stack info
     */
    public String toString() {
        return myList.toString();
    }
}
