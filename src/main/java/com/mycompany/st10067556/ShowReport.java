package com.mycompany.st10067556;

import javax.swing.*;

public class ShowReport
{
    //newly declared arrays to be assigned and manipulated
    public String[] dev, taskName, taskStatus, taskID;
    int[] taskDuration;

    public void statusOfDone()//displays the developer, task name, status and duration of tasks done
    {
        String message = "";
        for (int i = 0; i < taskStatus.length; i++)//searches through the whole array looking for task status
        {
            if (this.taskStatus[i].equals("2"))//executes the message assignment once it finds a task status equal to done
            {
                message += "Developer:\t\t" + this.dev[i]
                        + "\nTask Name:\t\t" + this.taskName[i]
                        + "\nTask Status:\t" + this.taskStatus[i]
                        + "\nTask Duration:\t" + this.taskDuration[i]
                        + "\n\n";
            }
        }

        JOptionPane.showMessageDialog(null, message,"Details for tasks Done", JOptionPane.PLAIN_MESSAGE);// **format and make words readable

    }

    public void longestDuration()
    {
        int highestDuration = 0;
        int index = 0;

        for(int i = 0; i < this.taskDuration.length; i++)
        {
            if (highestDuration < this.taskDuration[i])/*continually looks for a number higher than the previous
            if the number is less than the array number at index i*/
            {
                highestDuration = this.taskDuration[i];//then it makes the number equal to the number at index i
                index = i;
            }
        }

        JOptionPane.showMessageDialog(null, "Developer:\t\t" + this.dev[index]
        + "\nTask Duration:\t" + highestDuration, "Longest task duration", JOptionPane.PLAIN_MESSAGE);

    }

    public void searchTaskName(String taskName)
    {
        for (int i = 0; i < this.taskName.length; i++)//searches through array looking for task names
        {
              if (taskName.equals(this.taskName[i]))
              {
                  JOptionPane.showMessageDialog(null, "Task Name:\t\t" + taskName
                  + "\nDeveloper:\t\t" + this.dev[i]
                  + "\nTask Status:\t" + this.taskStatus[i], "Task details for " + taskName, JOptionPane.PLAIN_MESSAGE);
              }
        }
    }

    public void searchDev(String developer)
    {
        String message = "";
        for (int i = 0; i < this.dev.length; i++)//searches through array looking for dev
        {
            if (developer.equals(this.dev[i]))//if the searched for dev is found then execute message assignment
            {
                message += "Task Name:\t\t" + this.taskName[i]
                +"\nTask Status:\t" + this.taskStatus[i]
                +"\n\n";
            }
        }
        JOptionPane.showMessageDialog(null, message, "Task details for " + developer, JOptionPane.PLAIN_MESSAGE);
    }

    public void deleteTask(String taskName)
    {
        for (int i = 0; i < this.taskName.length; i++)
        {
            if (taskName.equals(this.taskName[i]))//this looks through whole array if it has the task name
            {
                String[] diffDev = new String[this.dev.length-1];
                String[] diffTaskName = new String[this.taskName.length-1];
                String[] diffTaskStatus = new String[this.taskStatus.length-1];
                String[] diffTaskID = new String[this.taskID.length-1];
                int[] diffTaskDuration = new int[this.taskDuration.length-1];
                int index = 0; //index variable intended to make sure the first assigned variable starts at the diffsVariables index 0

                for (int j = 0; j < this.taskName.length; j++)/*once the task name has been found can we start assigning
                variables to the newly declared arrays*/
                {
                    if (j != i) //used to omit the assignment of the found index for the deleted task
                    {
                        diffDev[index] = this.dev[j];
                        diffTaskName[index] = this.taskName[j];
                        diffTaskStatus[index] = this.taskStatus[j];
                        diffTaskDuration[index] = this.taskDuration[j];
                        diffTaskID[index] = this.taskID[j];
                        index++;
                    }
                }
                this.dev = diffDev;
                this.taskName = diffTaskName;
                this.taskStatus = diffTaskStatus;
                this.taskDuration = diffTaskDuration;
                this.taskID = diffTaskID;
                JOptionPane.showMessageDialog(null, "Entry " + "\""+taskName +"\"" + "successfully deleted");
            }

        }
    }

    public void displayReport()
    {
        String message = "";
        for (int i = 0; i < taskStatus.length; i++)
        {
            message += "Developer:\t\t" + this.dev[i]
                    + "\nTask Name:\t\t" + this.taskName[i]
                    + "\nTask ID:\t\t" + this.taskID[i]
                    + "\nTask Duration:\t" + this.taskDuration[i]
                    + "\nTask Status:\t" + this.taskStatus[i]
                    + "\n\n";
        }

        JOptionPane.showMessageDialog(null, message,"Details for all", JOptionPane.PLAIN_MESSAGE);// **format and make words readable

    }
}
