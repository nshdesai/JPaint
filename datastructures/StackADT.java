package datastructures;

/**
 * Interface for any Stack Abstact Data type.
 *
 * @@author Mr. Rao
 */
public interface StackADT<T> {
    /**
     * Adds one element to the top of the stack.
     * @param element generic type element
     */
    public void push(T element);

    /**
     * Removes and returns a reference to the top element from the stack.
     * @return generic type element
     */
    public T pop();

    /**
     * Returns a reference to the top element, without removing it from the stack.
     * @return generic type element
     */
    public T peek();

    /**
     * Returns true if the stack contains no elements, false otherwise.
     * @return boolean is the stack empty?
     */
    public boolean isEmpty();

    /**
     *  Returns the number of elements in the stack.
     * @return integer number of elements in stack
     */
    public int size();

    /**
     * Clears all elements from the stack
     */
    public void clear();

    /**
     * Returns a String representation of this stack.
     * @return String containing stack info
     */
    public String toString();
}
