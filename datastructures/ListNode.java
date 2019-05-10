package datastructures;

/**
 * Class to build a single node on a (Linked|) list.
 *
 * @author ndesai
 * @version 30th January 2019
 * @see datastructures.LinkedList
 */
public class ListNode<T> {
    private T data;
    private ListNode next;

    /**
     *  Constructor: No reference to next node provided so make it null
     * @param nodeData node data
     */
    public ListNode( T nodeData ) {
        this( nodeData, null);
    }

    /**
     * Constructor: Set data and reference to next node.
     * @param nodeData node data
     * @param nodeNext next node
     */
    public ListNode( T nodeData, ListNode nodeNext ) {
        data = nodeData;
        next = nodeNext;
    }

    /**
     * Accessor: Return the data for current ListNode object
     * @return data in node
     */
    public T getData() {
        return data;
    }

    /**
     * Accessor: Return reference to next ListNode object
     * @return reference to next node
     */
    public ListNode getNext() {
        return next;
    }

    /**
     * Mutator: Set new data for current ListNode object
     * @param newData new data
     */
    public void setData( T newData ) {
        data = newData;
    }

    /**
     * Mutator: Set new reference to the next node object
     * @param newNext new next node
     */
    public void setNext( ListNode newNext ) {
        next = newNext;
    }
}
