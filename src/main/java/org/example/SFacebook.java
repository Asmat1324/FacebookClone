package org.example;

/**
 * <p>
 * Title: org.example.SFacebook.java
 * </p>
 *
 * <p>
 * Description: Creates an array of members who can then have their friends modified.
 * </p>
 *
 * @author Asmatullah Khan
 */
public class SFacebook {
    private Friend[] theMembers;	//An array of facebook members
    private int count;				//The count of the amount of members
    /**
     * sFacebook - default constructor that sets theMembers to a size of 5 and count to 0
     *
     */
    public SFacebook()
    {
        theMembers = new Friend[2];
        count = 0;
    }

    /**
     * addToFacebook - adds a friend to the facebook
     * @param addMember - the member that is to be added
     */
    public void addToFacebook(String addMember, int securityLevel)
    {
        if(count < theMembers.length)
        {
            theMembers[count] = new Friend(addMember);
            theMembers[count].setSLevel(securityLevel);
            count++;
        }
        else
        {
            expandCapacity();
            theMembers[count] = new Friend(addMember);
            theMembers[count].setSLevel(securityLevel);
            count++;
        }
    }

    /**
     * makeFriends - Creates a frienddship between two people
     * @param f1 name of the first person
     * @param f2 name of the second person
     */
    public void makeFriends(String f1, String f2)
    {
        if(!f1.equals(f2))
        {
            Friend p1 = findFriend(f1);
            Friend p2 = findFriend(f2);
            int pos1 = 0;
            int pos2 = 0;
            if(p1 != null && p2 != null)
            {
                p1.addFriend(p2);
                p2.addFriend(p1);
            }
            else
                throw new FriendNotFoundException("One of the names does not exist within the facebook. \nFriendNotFoundException has been thrown.");;
        }
    }

    /**
     * breakFriendship - Breaks a friendship between two people.
     * @param f1 name of the first person
     * @param f2 name of the second person
     */
    public void breakFriendship(String f1, String f2)
    {

        if(!f1.equals(f2))
        {
            Friend p1 = findFriend(f1);
            Friend p2 = findFriend(f2);
            if(p1 != null && p2 != null)
            {
                p1.unfriend(p2);
                p2.unfriend(p1);
            }
            else
                throw new FriendNotFoundException("One of the names does not exist within the facebook. \nFriendNotFoundException has been thrown.");
        }
    }

    /**
     * getFriends - returns the list of friends or list of friends and friends of friends depending on security level
     * @param gF - the name of the person who's list of friends is requested
     * @return - list of friends of friend object
     */
    public String getFriends(String gF)
    {
        Friend getF = findFriend(gF);

        if(getF == null)
            throw new FriendNotFoundException("The name provided does not exist within the facebook. \nFriendNotFoundException has been thrown.");
        else
        if(getF.getSLevel() == 0)
            return gF + " is friends with: " + getF.getFriends();
        else
            return  gF + " is friends with: " + getF.getFriendsOfFriends();
    }

    /**
     * getFriendStatus - checks and returns to see if two people are friends or not
     * @param f1 name of the first person
     * @param f2 name of the second person
     * @return
     */
    public String getFriendStatus(String f1, String f2)
    {
        Friend p1 = findFriend(f1);
        Friend p2 = findFriend(f2);
        if(p1 != null && p2 != null)
        {
            if(p1.friendsWith(p2))
                return f1 + " and " + f2 + " are friends." ;
            else
                return f1 + " and " + f2 + " are not friends."  ;
        }
        else
            throw new FriendNotFoundException("One of the names does not exist within the facebook. \nFriendNotFoundException has been thrown.");
    }

    /**
     * toString- returns a string containing a list of friends of all friend objects in the facebook
     */
    public String toString()
    {
        String Op = "";
        for(int i = 0; i < count; i++)
            Op += "\n"+theMembers[i].getName() + " is friends with: " + theMembers[i].getFriends();
        return Op;
    }

    /**
     * findFriend- finds and returns the person in the member array that matches the name provided
     * @param fF - the person who's name is checked
     * @return the member or null depending on if it exists within the array
     */
    private Friend findFriend(String fF)
    {
        Friend fFriend = new Friend(fF);
        for(int i = 0; i < count; i++)
            if(theMembers[i].equals(fFriend))
                return theMembers[i];
        return null;
    }

    /**
     * expandCapacity- expands the capacity of the array when it has reached maximum size
     */
    private void expandCapacity()
    {
        Friend[] expArray = new Friend[theMembers.length * 2];
        for(int i = 0; i < theMembers.length; i++)
            expArray[i] = theMembers[i];
        theMembers = expArray;
    }
}
