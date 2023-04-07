package org.example;

/**
 * <p>Title: org.example.Node Class</p>
 *
 * <p>Description: Defines a node class capable of storing a
 * reference to an object and a reference to the next node in
 * a linked list. Accessors and mutators are defined for both.</p>
 *
 * @author Darci Burdge
 */
public class Node
{
    private Friend data; //a reference variable of type org.example.Friend will refer to an 'item'
    private Node next; //the address of the next node in the list

    /**
     * default constructor - initializes data and next to null
     */
    public Node()
    {
        data = null;
        next = null;
    }

    /**
     * parameterized constructor - initializes data to the user
     * specified value; next is set to null
     * @param newItem the value to be stored in the node
     */
    public Node(Friend newItem)
    {
        data = newItem;
        next = null;
    }

    /**
     * parameterized constructor - initializes data and next to user
     * specified values
     * @param newItem the object reference to be stored in the node
     * @param nextItem the reference to the next node in the list
     */
    public Node(Friend newItem, Node nextItem)
    {
        data = newItem;
        next = nextItem;
    }

    /**
     * setItem - stores a new value in data
     * @param newItem the object reference to be stored in the node
     */
    public void setItem(Friend newItem)
    {
        data = newItem;
    }

    /**
     * setNext - stores a new value in next
     * @param nextItem the reference to be stored in next
     */
    public void setNext(Node nextItem)
    {
        next = nextItem;
    }

    /**
     * getItem - returns the reference stored in data
     * @return a reference to the data stored in the node
     */
    public Friend getItem()
    {
        return data;
    }

    /**
     * getNext - returns the reference stored in next
     * @return the reference stored in next
     */
    public Node getNext()
    {
        return next;
    }
}