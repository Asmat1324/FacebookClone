package org.example;

/**
 * <p>
 * Title: org.example.FriendList
 * </p>
 *
 * <p>
 * Description: The org.example.FriendList class enables one to create a list of friends. It also allows a user
 * to remove and add from the list. It contains methods that check the status of the list 
 * </p>
 *
 * @author Asmatullah Khan
 */
public class FriendList
{
    private Node header;	//Dummy node that does not contain any value
    private int count;		//The count of the amount of items in the list

    /**
     * FriendList - default constructor that sets instantaites header and sets count to 0;
     */
    public FriendList()
    {
        header = new Node();
        count = 0;
    }
    /**
     * size - returns the size of the list
     * @return count, which is the amount of items in the list
     */
    public int size()
    {
        return count;
    }

    /**
     * isEmpty - Used to check if a friendsList item is empty or not
     * @return true or false depending on whether
     */
    public boolean isEmpty()
    {
        if(count == 0)
            return true;

        return false;
    }

    /**
     * addToFront- adds a new friend object the front of the friends list
     * @param addFriend - the friend that is to be added
     */
    public void addToFront(Friend addFriend)
    {
        if(count == 0)
        {
            header.setNext(new Node(addFriend));
            count++;
        }
        else
        {
            header.setNext(new Node(addFriend, header.getNext()));
            count++;
        }
    }

    /**
     * remove - removes the friend that is passed through from the list. If the friend is not
     * present an excpetion will be thrown.
     * @param remFriend - the friend that is to be removed
     * @return the friend that was removed
     */
    public Friend remove(Friend remFriend)
    {

        Node prev = header;
        Node current = header.getNext();
        boolean exception = false;
        Friend retItem;
        for(int i = 0; i< count; i++)
        {
            if(current.getItem().equals(remFriend))
            {
                retItem = current.getItem();
                prev.setNext(current.getNext());
                count--;
                return retItem;
            }
            else
            {
                prev = current;
                current = current.getNext();
            }
        }
        if(!exception)
            throw new FriendNotFoundException();

        return null;
    }

    /**
     * search - Traverses the list to check if the friend object passed to the method
     * is present
     * @param sFriend - The friend who's presence in the list will be checked for
     * @return - true or false depending the presence of the friend
     */
    public boolean search(Friend sFriend)
    {
        Node current = header.getNext();

        for(int i = 0; i< count; i++)
        {
            if(current.getItem().equals(sFriend))
                return true;
            else
                current = current.getNext();
        }

        return false;
    }

    /**
     * listOfFriends - returns a list of the friends in a friends list
     * @return all items in the list
     */
    public String listOfFriends()
    {
        String OP = "";
        Node current = header.getNext();
        for(int i = 0; i < count; i++)
        {
            OP += current.getItem().getName() + " ";
            current = current.getNext();
        }
        return OP;
    }

    /**
     * listOfFriendsOfFriends - returns a list of the friends in a friends list as well as their friends
     * of friends
     * @return a list of the friends in a friends list as well as their friends
     * of friends
     */
    public String listOfFriendsOfFriends()
    {
        String OP = "";
        Node current = header.getNext();
        for(int i = 0; i < count; i++)
        {
            OP += " and \n"+current.getItem().getName() + " is friends with: " +  current.getItem().getFriends();
            current = current.getNext();
        }
        return OP;
    }
}