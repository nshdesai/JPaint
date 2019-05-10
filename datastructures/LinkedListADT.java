package datastructures;

/**
 * LinkedList interface
 *
 * @@author Mr. Rao
 */
public interface LinkedListADT<T> {

    /**
     * Returns true if the linked list has no nodes, or false otherwise.
     * @return boolean is the linked list empty?
     */
    public boolean isEmpty();

    /**
     * Deletes all of the nodes in the linked list.
     */
    public void clear();

    /**
     * Returns the number of nodes in the linked list
     * @return integer size of linked list
     */
    public int size();

    /**
     * Adds a node to the front of the linked list.
     * @param element generic type element
     */
    public void addFirst( T element );

    /**
     * Adds a node to the end of the linked list
     * @param element generic type element
     */
    public void addLast( T element );

    /**
     * Returns a reference to the data in the first node, or null if the list is empty.
     * @return generic type element
     */
    public T peekFirst();

    /**
     * Removes a node from the front of the linked list (if there is one).
     * Returns a reference to the data in the first node, or null if the list is empty.
     * @return generic type element
     */
    public T removeFirst();

    /**
     * Returns a reference to the last node in the list and removes it
     * @return generic type element
     */
    public T removeLast();

    /**
     * Returns true if the linked list contains a certain element, or false otherwise.
     * @param  key generic type element
     * @return     boolean. does the linked list contain the key?
     */
    public boolean contains( T key );

    /**
     * Return String representation of the linked list.
     * @return String containing linked list info
     */
    public String toString();
}
