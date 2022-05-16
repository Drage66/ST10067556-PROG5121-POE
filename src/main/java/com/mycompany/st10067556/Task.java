package com.mycompany.st10067556;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.util.Locale;

import static com.mycompany.st10067556.ST10067556.duration;
import static com.mycompany.st10067556.ST10067556.totalDuration;

public class Task

{

    public static boolean checkTaskDescription(String task)
    {
        return task.length() > 50;//returns true if the description length is less than 50
    }

    public static String createTaskID(String taskName, String taskNumber, String developerDeets)
    {
        String taskID = taskName.substring(0,2) + ":" + taskNumber + ":" + developerDeets.substring(developerDeets.length()-3);//declares string task ID with the formatting for ID
        return taskID.toUpperCase();// makes task ID all uppercase
    }

    public static String printTaskDetails(String taskStatus, String developerDeets, String taskNumber, String taskName, String taskDescription, String taskID, int duration)
    {
        //creates a selection menu if depending on if user selects to do, done, or doing
        String status = "";

        if(taskStatus.equals("1"))
        {
            status = "To Do";
        }
        if (taskStatus.equals("2"))
        {
            status = "Done";
        }
        if (taskStatus.equals("3"))
        {
            status = "Doing";
        }



        return "Task Status: " + status
                +"\nDeveloper Details: " + developerDeets
                +"\nTask Number: " + taskNumber
                +"\nTask Name: " + taskName
                +"\nTask Description: " + taskDescription
                +"\nTask ID: " + taskID
                +"\nDuration: " + duration;//returns the task details in a format

    }

    public static int returnTotalHours()
    {
        totalDuration += duration;
        return totalDuration;//returns total hours of all task

    }

}
