

package com.mycompany.st10067556;

import javax.swing.*;
import java.util.Scanner;
import java.util.regex.*;


public class ST10067556
{
//    public static boolean checkUserName(String userNames)
//    {
//        boolean verify; // this verifies input
//        Pattern input = Pattern.compile("_+"); //Pattern object created to search for the single character underscore
//        Matcher matcher = input.matcher(userNames); //Matcher object derived from pattern object that looks in the input for the patter
//        boolean matchFound = matcher.find(); // returns true if underscore found and false if not
//
//        int charCount = userNames.length(); //returns the amount of characters in the string. Can only be created as long for some reason
//
//        if (matchFound && charCount <= 5) //Checks whether the number of characters is less than or equal to 5 AND whether the matchfound returned true
//        {
//            verify = true;
//        }
//        else
//        {
//            verify = false;
//        }
//
//        return verify; //returns true or false
//    }

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

//    public static boolean checkPasswordComplexity(String password)
//    {
//        boolean verify; // this verifies input
//        String character = " ";;
//        Pattern input = Pattern.compile(character); //Pattern object created to search for the single character underscore
//        Matcher matcher = input.matcher(password); //Matcher object derived from pattern object that looks in the input for the pattern
//        boolean matchFound = matcher.find(); // returns true if underscore found and false if not
//
//        int charCount = password.length(); //returns the amount of characters in the string. Can only be created as long for some reason
//
//        if (matchFound && charCount >= 8) //Checks whether the number of characters is greater than or equal to 8 AND whether the matchfound returned true
//        {
//            verify = true;
//        }
//        else
//        {
//            verify = false;
//        }
//
//        return verify; //returns true or false
//
//    }

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

            int charValue = (int) password.charAt(locator);

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

    public static String registerUser(boolean usernameInput,String userName, boolean passwordInput)
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

//        if(passwordInput && usernameInput)
//        {
//            message = "Welcome " + sub1 + ", " + sub2 + " it is great to see you again";
//        }
//        else
//        {
//            message = "Username or password incorrect, please try again";
//        }

        return message;
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
            sub2 = userName.substring(locator + 1,userName.length());

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
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter Username");
//        String userNameInput = sc.next();
//        System.out.println("Enter Password");
//        String passwordInput = sc.next();
//        System.out.println(registerUser(checkUserName(userNameInput), userNameInput, checkPasswordComplexity(passwordInput)));

        String passwordInput = "";
        String userNameInput = JOptionPane.showInputDialog("Enter Username");

        passwordInput = JOptionPane.showInputDialog("Enter Password");

        JOptionPane.showMessageDialog(null, registerUser(checkUserName(userNameInput), userNameInput, checkPasswordComplexity(passwordInput)));

        JOptionPane.showMessageDialog(null, returnLoginStatus(checkUserName(userNameInput),userNameInput, checkPasswordComplexity(passwordInput)));




    }

}
