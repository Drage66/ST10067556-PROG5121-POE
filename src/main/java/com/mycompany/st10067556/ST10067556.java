

package com.mycompany.st10067556;

import javax.swing.*;


public class ST10067556
{
    public static int totalDuration;
    public static int duration;

    public static void main(String[] args)
    {
        //String variable declarations
        String passwordInput = "";
        String userNameInput = JOptionPane.showInputDialog("Enter Username");
        String[] allDevelopers, allTasks, allTaskID,allTaskStatus;
        int[] allTaskDuration;
        String numberOfTask;
        int InumberOfTask = 0;


        ShowReport report = new ShowReport(); //creates and declares the ShowReport Class

        passwordInput = JOptionPane.showInputDialog("Enter Password");

        JOptionPane.showMessageDialog(null, Login.registerUser(Login.checkUserName(userNameInput),Login.checkPasswordComplexity(passwordInput)));
        JOptionPane.showMessageDialog(null, Login.returnLoginStatus(Login.loginUser(userNameInput, passwordInput),userNameInput));

        if(Login.loginUser(userNameInput, passwordInput))//checks whether username and password match the LoginStorage.txt
        {
            String option = " ";
            while (!option.equals("3"))
            {
                option = JOptionPane.showInputDialog("Welcome to EasyKanban" +
                        "\nOption1) Add tasks" +
                        "\nOption2) Show Report" +
                        "\nOption3) Quit");

                if (option.equals("1"))
                {
                    totalDuration = 0;


                    numberOfTask = JOptionPane.showInputDialog("How many tasks do you wish to enter?");
                    InumberOfTask = Integer.parseInt(numberOfTask);

                    //initializes the spaces for the arrays to the number of tasks requested
                    allDevelopers = new String[InumberOfTask];
                    allTasks = new String[InumberOfTask];
                    allTaskID = new String[InumberOfTask];
                    allTaskStatus = new String[InumberOfTask];
                    allTaskDuration = new int[InumberOfTask];


                    for (int i = 0; i < InumberOfTask; i++)
                    {
                        String taskName = JOptionPane.showInputDialog("Task Name");
                        String taskNumber = Integer.toString(i+1);
                        JOptionPane.showMessageDialog(null, taskNumber);
                        String taskDesc = JOptionPane.showInputDialog("Task Description");
                        if(Task.checkTaskDescription(taskDesc))
                        {
                            while(Task.checkTaskDescription(taskDesc))
                            {
                                taskDesc = JOptionPane.showInputDialog(null, "Task description may not be longer than 50 characters","", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        String devDetail = JOptionPane.showInputDialog("Developer Details");
                        String taskDuration = JOptionPane.showInputDialog("Task Duration");
                        duration = Integer.parseInt(taskDuration);
                        String taskID = Task.createTaskID(taskName,taskNumber,devDetail);

                        String taskStatus = JOptionPane.showInputDialog("Option1) To Do" +
                                "\nOption2) Done" +
                                "\nOption3) Doing");

                        switch (taskStatus)//switch statement to convert the input numbers into their respective words
                        {
                            case "1":
                                taskStatus = "To Do";
                                break;

                            case "2":
                                taskStatus = "Done";
                                break;

                            case "3":
                                taskStatus = "Doing";
                                break;
                        }


                        JOptionPane.showMessageDialog(null, Task.printTaskDetails(taskStatus,devDetail,taskNumber,taskName,taskDesc,taskID,duration));
                        Task.returnTotalHours();

                        allDevelopers[i] = devDetail;
                        allTasks[i] = taskName;
                        allTaskID[i] = taskID;
                        allTaskDuration[i] = duration;
                        allTaskStatus[i] = taskStatus;

                    }

                    report.dev = allDevelopers;
                    report.taskName = allTasks;
                    report.taskStatus = allTaskStatus;
                    report.taskDuration = allTaskDuration;
                    report.taskID = allTaskID;

                    JOptionPane.showMessageDialog(null, "The Total amount of hours spent on task is " + Task.returnTotalHours() + " hours!");

                }


                if (option.equals("2"))
                {
                    String arrayOptions = JOptionPane.showInputDialog(null, "1) Display Tasks Done" +
                            "\n2)Display longest duration task" +
                            "\n3)Search for task" +
                            "\n4)Search for all task assigned to developer" +
                            "\n5)Delete task" +
                            "\n6)Print all captured tasks");

                    switch (arrayOptions)
                    {
                        case "1":
                            report.statusOfDone();
                            break;

                        case "2":
                            report.longestDuration();
                            break;

                        case "3":
                            String taskName = JOptionPane.showInputDialog(null, "Enter name to search");
                            report.searchTaskName(taskName);
                            break;

                        case "4":
                            String devName = JOptionPane.showInputDialog(null, "Enter Developer name");
                            report.searchDev(devName);
                            break;

                        case "5":
                            String taskNameDelete = JOptionPane.showInputDialog(null, "Enter task Name to delete");
                            report.deleteTask(taskNameDelete);
                            break;

                        case "6":
                            report.displayReport();
                            break;
                    }
                }
            }
        }
    }

}
