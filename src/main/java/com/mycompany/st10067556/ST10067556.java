

package com.mycompany.st10067556;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;


public class ST10067556
{
    public static boolean checkUserName(String userName)
    {
        int locator = 0;
        boolean find = false;// value to be returned can either be true or false

        while (find == false && userName.length() <= 5)
        {
            if (userName.charAt(locator) == '_')// if statement that checks at increment char locations until it finds underscore
            {
                find = true;
            }
            else // if it doesnt find a undersocre at pos 0 then lookk for ir and pos 1, then pos 2
            {
                locator++;
            }
            if (locator == userName.length())
            {
                break;
            }
        }

        return find;

    }

    public static boolean checkPasswordComplexity(String password)
    {
        int locator = 0;


        boolean caps = false;
        boolean digits = false;
        boolean special = false;
        boolean find = false; // value to be returned can either be true or false


        while (find == false && password.length() >= 8)
        {

            if (locator == password.length())
            {
                break;
            }

            int charValue = password.charAt(locator);

            if (charValue >= 65 && charValue <= 90)// looks for Caps and returns true if found
            {
                caps = true;
            }


            if (charValue >= 48 && charValue <= 57)
            {
                digits = true;
            }


            if (password.charAt(locator) == '@' || password.charAt(locator) == '$' || password.charAt(locator) == '~' || password.charAt(locator) == ':' || password.charAt(locator) == '#' || password.charAt(locator) == '!')
            {
                special = true;

            }


            if (special == true && digits == true && caps == true)
            {
                find = true;
            }


            locator++;
        }
        return find;
    }

    public static String registerUser(boolean usernameInput, boolean passwordInput)
    {
        int locator = 0;
        String sub1 = " ";
        String sub2 = " ";

        String message = " ";
        if(usernameInput)
        {
            message = "Username successfully captured";


        }
        else
        {
            message = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }


        if(passwordInput)
        {
            message = "Password successfully captured";

        }
        else
        {
            message = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }

        return message;
    }

    public static boolean loginUser(String userName, String password) throws IOException
    {
        FileWriter details = new FileWriter("LoginStorage.txt");
        details.write(userName + "\n" + password);
        details.close();

        Scanner reader = new Scanner("filename.txt");
        String user = reader.nextLine();
        String pass = reader.nextLine();

        return user == userName && pass == password;

    }

    public static String returnLoginStatus(boolean userNameB,String userName, boolean password)
    {
        int locator = 0;
        String sub1 = " ";
        String sub2 = " ";

        String message = " ";
        if(userNameB && password)
        {

            while(userName.charAt(locator) != '_')
            {
                locator++;
            }
            sub1 = userName.substring(0,locator);
            sub2 = userName.substring(locator + 1);

            message = "Welcome " + sub1 + ", " + sub2 + "it is great to see you again";
        }
        else
        {
            message = "Username or password incorrect, please try again";
        }


        return message;
    }

    public static void main(String[] args)
    {
        String passwordInput = "";
        String userNameInput = JOptionPane.showInputDialog("Enter Username");

        passwordInput = JOptionPane.showInputDialog("Enter Password");

        JOptionPane.showMessageDialog(null, registerUser(checkUserName(userNameInput), checkPasswordComplexity(passwordInput)));

        JOptionPane.showMessageDialog(null, returnLoginStatus(checkUserName(userNameInput),userNameInput, checkPasswordComplexity(passwordInput)));
        //The questions and programming memo are the most ambiguous and limiting things I have ever seen btw :)


    }

}
