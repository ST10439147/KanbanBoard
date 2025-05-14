/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanbanboard;
import javax.swing.*;
import java.util.Scanner;

/**
 *
 * @author Dillon Rinkwest ST10439147 PROG5121 Gr01
 */
public class TaskManager 
{
    Scanner myScanner = new Scanner(System.in);
    public static final int DESCRIP_LENGTH = 50;
    public TaskClass[] TaskData;
    private int numTask;
    private int num;
    private String statusEnt;
    
    //-----------------------------------------------------------------------------------------------------------------------------------//
    //Default constructor
    public TaskManager() 
    {
    }

    //-----------------------------------------------------------------------------------------------------------------------------------//
    // Checks if description length is less than 50
    protected boolean checkTaskDescription(String description) {
        if (description.length() > DESCRIP_LENGTH) 
        {
            return false;
        }
        else
        {
            return true;
        }
        
    }
    //-----------------------------------------------------------------------------------------------------------------------------------//
    /* 
    Creation of taskID
        1st two letters of the task Name in uppercase
        ":"
        Task number
        ":"
        Last three letters of developers surname uppercase
        e.g. AD:0:EST
        Using Surname is makes it more identifiable, hence the use of surname and not name
    */
    protected String createID(TaskClass task, DeveloperClass dev)
    {
        // Add null checks
        if (task == null || dev == null || task.getTaskName() == null || dev.getDevName() == null) {
            return "INVALID:ID";
        }
        
        String taskPrefix = task.getTaskName().length() >= 2 ? task.getTaskName().substring(0, 2).toUpperCase() : task.getTaskName().toUpperCase();
        String devSuffix = dev.getDevName().length() >= 3 ? dev.getDevName().substring(dev.getDevName().length() - 3).toUpperCase() : dev.getDevName().toUpperCase();
        return taskPrefix + ":" + task.getTaskNo() + ":" + devSuffix;
    }
    //-----------------------------------------------------------------------------------------------------------------------------------//
    // The total number of hours that was entered
    protected int returnTotalHours() 
    {
        int totalDuration = 0;
        
        // Added null check for TaskData
        if (TaskData == null) {
            return 0;
        }
        
        for (TaskClass task : TaskData) 
        {
            if (task != null && task.getDeveloper() != null) { // Added null check for task and developer
                totalDuration += task.getDeveloper().getDuration();
            }
        }
        return totalDuration;
    }
    
    
//-----------------------------------------------------------------------------------------------------------------------------------//
    // Asks users for the information needed to display the data
    public void Communication() 
    {
        JOptionPane.showMessageDialog(null, "You will be required to enter the task details");
        /*
            received from chatgpt
                The code inside the try block attempts to execute a potentially error-prone operation.
                The code inside the catch block is executed if an exception is thrown in the try block.
        */
        try 
        {
            numTask = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks would you like to create?"));
        }
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null, "Invalid number of tasks. Please enter a valid number.");
            Communication();
            return;
        }

        TaskData = new TaskClass[numTask];
        int i = 0;

        while (i < numTask)//loop will run until variable i is no longer than numTask
        {            
             String name = JOptionPane.showInputDialog("Task name " + (i + 1) + ":");
            String description = JOptionPane.showInputDialog("Task description " + (i + 1) + ":");

            //Checks if the condition is met
            if (!checkTaskDescription(description)) 
            {
                JOptionPane.showMessageDialog(null, "Description too long, Please enter again" + DESCRIP_LENGTH + " characters.", "Tasks", JOptionPane.ERROR_MESSAGE);
                description = JOptionPane.showInputDialog("Task description " + (i + 1) + ":");
            }

            statusEnt = JOptionPane.showInputDialog(null, "1. To Do\n2. Done\n3. Doing", "Select an option");
            int statusInt;

            try //received from chatgpt
            {
                statusInt = Integer.parseInt(statusEnt);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid status option. Defaulting to 'To Do'.");
                statusInt = 1; // Default to 'To Do'
            }

            String status = getStatus(statusInt);

            // Create the task
            TaskClass task = new TaskClass(name, status, description, i);

            String devName = JOptionPane.showInputDialog("Enter the name of the developer for task " + (i + 1) + ":");
            //String devSurname = JOptionPane.showInputDialog("Enter the surname of the developer for task " + (i + 1) + ":");
            int duration;
            
            /*
            received from chatgpt
            The try block is followed by a catch block that catches NumberFormatException.
            NumberFormatException is thrown if the input string cannot be parsed into an integer
            If a NumberFormatException occurs, the catch block is executed:
            A message dialog is displayed to the user with the message "Invalid duration. Defaulting to 1 hour."
            The duration variable is set to 1, providing a default value
            */
            try
            {
                duration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the estimated duration of the task"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid duration. Defaulting to 1 hour.");
                duration = 1;
            }

            // Create the developer
            DeveloperClass dev = new DeveloperClass(devName, duration);

            // Create the ID
            String ID = createID(task, dev);

            task.setID(ID);
            task.setDeveloper(dev);

            TaskData[i] = task;
            i++;
        }

        printTaskDetails();
        int totalDuration = returnTotalHours();
        JOptionPane.showMessageDialog(null, "Total Duration of all tasks: " + totalDuration + " hours");
        this.displayMenu();
    }

    //-----------------------------------------------------------------------------------------------------------------------------------//
    // Displaying the data in the arrays
    //Using StringBuilder so toString() method can be accessed
    
    public void printTaskDetails() 
    {
        int taskCount = 0;
        
        for (TaskClass task : TaskData) {
        if (task != null) {
            taskCount++;
        }
    }
        StringBuilder output = new StringBuilder("Task Details:\n");
        output.append("Total number of tasks: ").append(taskCount).append("\n\n");

        for (int i = 0; i < numTask; i++) 
        {
            if (TaskData[i] != null) //if taskData is null
            {
                output.append("Task ").append(i + 1).append(" Details:\n");
                output.append("Status: ").append(TaskData[i].getStatus()).append("\n");
                output.append("Name: ").append(TaskData[i].getTaskName()).append("\n");
                output.append("Description: ").append(TaskData[i].getDescription()).append("\n");
                output.append("ID: ").append(TaskData[i].getID()).append("\n");
                output.append("Task Number: ").append(TaskData[i].getTaskNo()).append("\n");

                /*
                 Before accessing TaskData[i].getDeveloper(), ensure that TaskData[i] is not null.
                Also a proper initailizer
                */
                DeveloperClass developer = TaskData[i].getDeveloper();
                if (developer != null) 
                {
                    output.append("Developer Name: ").append(developer.getDevName()).append("\n");
                    output.append("Duration: ").append(developer.getDuration()).append(" hours\n");
                }
                output.append("\n");
            } 
            else 
            {
                output.append("Task ").append(i + 1).append(" is null\n");
            }
        }

        JOptionPane.showMessageDialog(null, output.toString(), "Task Details", JOptionPane.INFORMATION_MESSAGE);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------//
    // Checks whether the status requirements have been met
    protected String getStatus(int StatusInt) 
    {
        switch (StatusInt) {
            case 1:
                return "To Do";
            case 2:
                return "Done";
            case 3:
                return "Doing";
            default:
                return "Unknown";
        }
    }   
    
    public void menuAfterDeclared()
    {
        System.out.println(ConsoleColours.CYAN +"////////////////////////////////////////////////////////");
        System.out.println(ConsoleColours.CYAN +"                    Welcome to Easy KanBan                          ");        System.out.println(ConsoleColours.CYAN +"////////////////////////////////////////////////////////");
        System.out.println("\nPlease choose one of the following 3 options to continue\n");
        
        System.out.println("1. Add Task");
        System.out.println("2. Show report");
        System.out.println("3. Quit");
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------//
    public void displayMenu()
    {
        //Connecting different classes to this class
        UserManager myUser = new UserManager();//Accessing UserManager class
        Login myLogin = new Login();//Accessing Login class
        
//do while loop, will run at least once
        do                                      
        { 
            this.menuAfterDeclared();
            num = this.myScanner.nextInt();
            
        } while (num > 3);                      
        
        //switch statement to communicate and see where the user wants to go
        switch (num)                           
        {
            case 1:
                this.Communication();//Accesses userInfo from TaskManager class
                break;
            case 2:
                this.ManageDetailsDisplay();     //devTasks method is now accessed
                break;
            default:
                System.out.println("Have a nice day");
                myScanner.close();//closing the scanner and ending the program
                break;
        }
        
    }
    
    //--------------------------------------------------------------------------------------------//    
    public void ManageDetailsDisplay()
    {
        int y = 0;
        do
        {            
            y = Integer.parseInt(JOptionPane.showInputDialog(null, "What do you wish to do:\n\n"
                + "1. Search for Task\n"
                + "2. Search for Developer\n"
                + "3. Delete Task\n"
                + "4. Developer with the longest duration\n"
                + "5. Display all Tasks\n"
                + "6. All tasks that are done\n"
                + "7. Quit","Select an option",JOptionPane.QUESTION_MESSAGE));
        } while (y < 1 || y > 7);
        
        switch (y)
        {
            case 1:
                this.searchTask();
                break;
            case 2:
                this.devTasks();
                break;
            case 3:
                this.deleteTask();          //Delete tasks
                break;
            case 4:
                this.maxDuration();// Longest duration
                break;
            case 5:
                this.printTaskDetailsFinal();
                break;
            case 6:
                this.tasksDone();
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Have a good day");
                System.exit(0);
                //return;
            default:
                JOptionPane.showMessageDialog(null,"Invalid option");
                break;
        }
        
        if (y != 7)
        {
            ManageDetailsDisplay();
        }
        
    }
    
    //--------------------------------------------------------------------------------------------//
    // searches the tasks that are connected to each developer that is searched
    public void devTasks()
    {
        JOptionPane.showMessageDialog(null, "Which developer's tasks are you looking for", "Developer's Tasks", JOptionPane.QUESTION_MESSAGE);
        String devName = JOptionPane.showInputDialog("Please Enter the developer's name");
        boolean found = false;
        
        if (devName == null || devName.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Developer name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        StringBuilder output = new StringBuilder("Tasks for developer ").append(devName).append("\n\n");
        
        for (TaskClass taskClass : TaskData)
        {
            if (taskClass != null && taskClass.getDeveloper() != null && taskClass.getDeveloper().getDevName().equalsIgnoreCase(devName))
            {
                output.append("Task Name: ").append(taskClass.getTaskName()).append("\n");
                output.append("Status: ").append(taskClass.getStatus()).append("\n\n");
                found = true;
            }
        }
        
        if (!found)
        {
            output.append("No tasks are allocated to this developer");
            this.ManageDetailsDisplay();
        }
        
        JOptionPane.showMessageDialog(null, output.toString(), "Search results: ", JOptionPane.INFORMATION_MESSAGE);
        this.ManageDetailsDisplay();
    }
    
    //--------------------------------------------------------------------------------------------//
    //Searches for tasks when the task name is entered
    public void searchTask()
    {
       // JOptionPane.showMessageDialog(null, "", "Task", JOptionPane.INFORMATION_MESSAGE);
        String searchTask = JOptionPane.showInputDialog("What tasks are you looking for?");
        if ( searchTask== null || searchTask.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Developer name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
       StringBuilder output = new StringBuilder("Task: ").append("\n\n");
       boolean found = false;
        for (TaskClass taskClass : TaskData)
        {
            if (taskClass != null && taskClass.getTaskName().equalsIgnoreCase(searchTask))
            {
                output.append("Task Name: ").append(taskClass.getTaskName()).append("\n");
                output.append("Task Status: ").append(taskClass.getStatus()).append("\n");
                
                DeveloperClass developer = taskClass.getDeveloper();
                if (developer != null)
                {
                    output.append("Developer Name: ").append(developer.getDevName()).append("\n");
                }
                found = true;
            }            
        }
        if (!found)
        {
            output.append("No Task named with the given name.\n");
            this.ManageDetailsDisplay();
        }
        
        JOptionPane.showMessageDialog(null, output.toString(), "Search Results", JOptionPane.INFORMATION_MESSAGE);
        this.ManageDetailsDisplay();
    }
    
    //--------------------------------------------------------------------------------------------//
    //Deletes the task when task name is entered
    public void deleteTask()
    {
        String taskName = JOptionPane.showInputDialog("What task name do you want to delete?");
        if (taskName == null || taskName.isEmpty()) // FIXED: Changed && to || for correct null check
        {
            JOptionPane.showMessageDialog(null, "There is no task with that name", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean found = false;
        
        for (int i = 0; i < numTask; i++)
        {
            if (TaskData[i] != null && TaskData[i].getTaskName().equalsIgnoreCase(taskName))
            {
                TaskData[i] = null; // Set the task to null to "delete" it
                found = true;
                break;
            }
        }
        if (found)
        {
            JOptionPane.showMessageDialog(null, "Task " + taskName + " has been deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.ManageDetailsDisplay();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No tasks are available with the given name", "Error", JOptionPane.ERROR_MESSAGE);
            this.ManageDetailsDisplay();
        }
    }
    //--------------------------------------------------------------------------------------------//
    //Looks to see the developer with the largest durarion time
    public void maxDuration()
    {
        DeveloperClass longestDev = null;
        int max = 0;
        
        for (TaskClass taskClass : TaskData)
        {
            if (taskClass != null && taskClass.getDeveloper() != null)
            {
                DeveloperClass developer = taskClass.getDeveloper();
                if (developer.getDuration() > max)
                {
                    max = developer.getDuration();
                    longestDev = developer;
                }
            }
        }
        
        if (longestDev != null)
        {
            StringBuilder output = new StringBuilder("Developer with the longest duration:\n\n");
            output.append("Developers Name: ").append(longestDev.getDevName()).append("\n");
            output.append("Duration: ").append(max).append("hrs\n");
            
            JOptionPane.showMessageDialog(null, output.toString(), "Developer with the longest duration", JOptionPane.INFORMATION_MESSAGE);
            this.ManageDetailsDisplay();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No developers found", "Developer with the longest duration", JOptionPane.ERROR_MESSAGE);
            this.ManageDetailsDisplay();
        }
        
    }
    
    //--------------------------------------------------------------------------------------------------------------//
    /*Displays the developers with the status of 'Done'    
    equalsIgnoreCase method.
    This ensures that tasks with the status "Done", "done", "DONE", etc., will all be considered as having the status "Done".
    */
    public void tasksDone()
    {
       StringBuilder output = new StringBuilder("Tasks with the status of Done:\n\n");
        boolean found = false;
        
        for (TaskClass taskClass : TaskData)
        {
            if (taskClass != null && "Done".equalsIgnoreCase(taskClass.getStatus()))
            {
                output.append("Task Name: ").append(taskClass.getTaskName()).append("\n");
                
                DeveloperClass developer = taskClass.getDeveloper();
                if (developer != null)
                {
                    output.append("Developer: ").append(developer.getDevName()).append("\n");
                    output.append("Task Duration: ").append(developer.getDuration()).append("\n\n"); 
                }
                found = true;            
            }            
        }
        if (!found)
        {
            output.append("There are no tasks with the status 'Done' found.\n");
            this.ManageDetailsDisplay();
        }
        JOptionPane.showMessageDialog(null, output.toString(), "Tasks with the status 'Done' ", JOptionPane.INFORMATION_MESSAGE); 
        this.ManageDetailsDisplay();
    }   
    
    public void printTaskDetailsFinal() 
    {
        int taskCount = 0;
        
        for (TaskClass task : TaskData) {
        if (task != null) {
            taskCount++;
        }
    }
        StringBuilder output = new StringBuilder("Task Details:\n");
        output.append("Total number of tasks: ").append(taskCount).append("\n\n");

        for (int i = 0; i < numTask; i++) 
        {
            if (TaskData[i] != null) //if taskData is null
            {
                output.append("Task ").append(i + 1).append(" Details:\n");
                output.append("Status: ").append(TaskData[i].getStatus()).append("\n");
                output.append("Name: ").append(TaskData[i].getTaskName()).append("\n");
                output.append("Description: ").append(TaskData[i].getDescription()).append("\n");
                output.append("ID: ").append(TaskData[i].getID()).append("\n");
                output.append("Task Number: ").append(TaskData[i].getTaskNo()).append("\n");

                /*
                 Before accessing TaskData[i].getDeveloper(), ensure that TaskData[i] is not null.
                Also a proper initailizer
                */
                DeveloperClass developer = TaskData[i].getDeveloper();
                if (developer != null) 
                {
                    output.append("Developer Name: ").append(developer.getDevName()).append("\n");
                    output.append("Duration: ").append(developer.getDuration()).append(" hours\n");
                }
                output.append("\n");
            } 
            else 
            {
                output.append("Task ").append(i + 1).append(" is null\n");
            }
        }

        JOptionPane.showMessageDialog(null, output.toString(), "Task Details", JOptionPane.INFORMATION_MESSAGE);
        this.ManageDetailsDisplay();
    }
    
    

}
//---------------------------------DDDDooooooooooooooooooooo END OF FILE DDDDooooooooooooooooooooo-------------------------------------------//

