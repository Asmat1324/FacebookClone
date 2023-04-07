package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * <p>
 * Title: fbCLoneApp.java
 * </p>
 *
 * <p>
 * Description: This will run all methods made within the sFacebook class
 * </p>
 *
 * @author Asmat
 */
public class fbCloneApp {
    public static void main(String[] args) throws FileNotFoundException
    {

        File f1 = new File("/Users/asmatullahkhan/eclipse-workspace/eclipse-workspace-new/FacebookClone/src/main/java/org/example/fbData.txt");
        Scanner sc = new Scanner(f1);
        SFacebook proj5 = new SFacebook();
        while(sc.hasNextLine())
        {
            try
            {
                String firstletter = sc.next();
                if (firstletter.equals("P"))
                {
                    proj5.addToFacebook(sc.next(), sc.nextInt());
                    System.out.println("----------------------------------------\nCurrent State of the facebook: \n" + proj5 + "\n----------------------------------------");
                }
                else if(firstletter.equals("F"))
                {
                    String mFriendOne, mFriendTwo;
                    mFriendOne = sc.next();
                    mFriendTwo = sc.next();
                    proj5.makeFriends(mFriendOne,mFriendTwo);
                    System.out.println("----------------------------------------\n" + mFriendOne + " and " + mFriendTwo + " have been made friends.\n----------------------------------------");
                }
                else if(firstletter.equals("U"))
                {
                    String uFriendOne, uFriendTwo;
                    uFriendOne = sc.next();
                    uFriendTwo = sc.next();
                    proj5.breakFriendship(uFriendOne, uFriendTwo);
                    System.out.println("----------------------------------------\n" + uFriendOne + " and " + uFriendTwo + " have removed eachother as friends.\n----------------------------------------");
                }
                else if(firstletter.equals("L") || firstletter.equals("V"))
                {
                    String name = sc.next();
                    System.out.println("\n---------------------------------------\nGetting friends, or friends of friends for " + name +"\n---------------------------------------");
                    System.out.println("\n" + proj5.getFriends(name));
                }
                else if(firstletter.equals("Q"))
                {

                    System.out.println("\nCHECKING IF TWO PEOPLE ARE FRIENDS:\n" + proj5.getFriendStatus(sc.next(), sc.next()));
                }
            }
            catch(FriendNotFoundException ex)
            {
                System.out.println("\n" + ex.getMessage());
            }
        }
        System.out.println("----------------------------------------\nFinal State of the facebook: \n" + proj5 + "\n----------------------------------------");
    }
}

