package org.example;

/**
 * <p>
 * Title: org.example.Friend
 * </p>
 *
 * <p>
 * Description: The friend class is an object that stores a name and a list of friends. The class contains an
 * accessor method as well as several methods that modify the list of friends. It also contains an equal method and
 * a method that returns the list of friends.
 * </p>
 *
 * @author Asmat
 */
public class Friend {
    private String name;   			//Instance variable that stores a persons name
    private FriendList friends;		//Instance variable that contains a linked list of all of a persons friends
    private int sLevel;				//Instance variable that contains a persons security level
    /**
     * Friend - parameterized constructor that sets name to whatever value is passed to it.
     * friends is also intialized as a friendsList object.
     * @param llamo
     */
    public Friend(String llamo)
    {
        name = llamo;
        friends = new FriendList();
        sLevel = 0;
    }

    /**
     * getName - accessor for the name
     * @return a string containing the persons name
     */
    public String getName()
    {
        return name;
    }

    /**
     * getName - accessor for the security level
     * @return a int containing the persons security level
     */
    public int getSLevel()
    {
        return sLevel;
    }

    /**
     * setSLevel - mutator for the security level
     * @param - secLevel is an int that will get set to a persons security level
     */
    public void setSLevel(int secLevel)
    {
        sLevel = secLevel;
    }
    /**
     * addFriend - adds a friend to the friends list of this object
     * @param aFriend - the friend that is to be added
     */
    public void addFriend(Friend aFriend)
    {
        friends.addToFront(aFriend);
    }

    /**
     * unfriend - removes a friend from the list of friends. Throws an exception if not found.
     * @param uFriend - The friend that is to be removed.
     * @return the friend that was removed.
     */
    public Friend unfriend(Friend uFriend)
    {
        return friends.remove(uFriend);
    }

    /**
     * friendsWith - checks to see if two people are friends
     * @param friend - the friend that is going to be compared and checked
     * @return true or false depending on if the friend is found.
     */
    public boolean friendsWith(Friend friend)
    {
        return friends.search(friend);
    }

    /**
     * getFriends - returns the list of friends that this person has
     * @return A list of the friends this person has.
     */
    public String getFriends()
    {
        return friends.listOfFriends();
    }

    /**
     * getFriends - returns the list of friends that this person has as well as friends of friends
     * @return A list of the friends this person has and friends of friends.
     */
    public String getFriendsOfFriends()
    {
        return getFriends() + friends.listOfFriendsOfFriends();
    }

    /**
     * equals- checks to see if two friend objects are the same;
     * @param eqCheck - The friend object that is to be compared with this friend object
     * @return true or false depending if they are friends or not.
     */
    public boolean equals(Friend eqCheck)
    {
        if(name.equals(eqCheck.getName()))
        {
            return true;
        }
        else
            return false;
    }
}
