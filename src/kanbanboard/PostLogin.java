/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanbanboard;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Dillon Rinkwest ST10439147 PROG5121 Gr01
 */
public class PostLogin
{
    //-----------------------VARIABLES---------------------------------------//
    private int num;
    Scanner myScanner = new Scanner(System.in);
    TaskManager mytask = new TaskManager();
    //-----------------------------------------------------------------------------------------------------------------------------------//
    //Default constructor
    public PostLogin()
    {        
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------//
    public void menu()
    {
        System.out.println(ConsoleColours.CYAN +"////////////////////////////////////////////////////////");
        System.out.println(ConsoleColours.CYAN +"                    Welcome to Easy KanBan                          ");
        System.out.println(ConsoleColours.CYAN +"////////////////////////////////////////////////////////");
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
            this.menu();
            num = this.myScanner.nextInt();
            
        } while (num > 3);                      
        
        //switch statement to communicate and see where the user wants to go
        switch (num)                           
        {
            case 1:
                mytask.Communication();//Accesses userInfo from TaskManager class
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Coming Soon");
                this.displayMenu();     //Menu comes back, so that the program flows better
                break;
            default:
                System.out.println("Have a nice day");
                myScanner.close();//closing the scanner and ending the program
                break;
        }
        
    }
}
//---------------------------------DDDDooooooooooooooooooooo END OF FILE DDDDooooooooooooooooooooo-------------------------------------------//
