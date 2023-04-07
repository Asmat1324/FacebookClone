package org.example;

/**
 * <p>
 * Title: org.example.FriendNotFoundException.java
 * </p>
 *
 * <p>
 * Description: Exception that is to be thrown when a friend is not found
 * </p>
 *
 * @author Asmat
 */
public class FriendNotFoundException extends RuntimeException
{
    /**
     * org.example.FriendNotFoundException - Default constructor that contains a default message
     */
    public FriendNotFoundException()
    {
        super("org.example.Friend was not found");
    }

    /**
     * org.example.FriendNotFoundException - Parameterized constructor that creates an exception with a message that is
     * passed through the parameter
     */
    public FriendNotFoundException(String message)
    {
        super(message);
    }
}
