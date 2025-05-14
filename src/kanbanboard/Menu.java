/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanbanboard;

import java.util.Scanner;

/**
 *
 * @author Dillon
 */
public class Menu
{
    private int num = 0 ;   //initializing the variable
    private Scanner MyScanner = new Scanner(System.in);//instantiating scanner
    //----------------------------------------------------------------------------------------------------//
    //Default constructor
    public Menu()
    {        
    }
    //----------------------------------------------------------------------------------------------------//
    public void MenuSetUp()
    {
        System.out.println(ConsoleColours.CYAN +"////////////////////////////////////////////////////////");
        System.out.println(ConsoleColours.CYAN +"                    Welcome                          ");
        System.out.println(ConsoleColours.CYAN +"////////////////////////////////////////////////////////");
        System.out.println("\nPlease choose one of the following 3 options to continue\n");
        
        System.out.println("1. Sign-up");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }
    //----------------------------------------------------------------------------------------------------//
    public void displayMenu()
    {
        //Connecting different classes to this class
        UserManager myUser = new UserManager();//Accessing UserManager class
        Login myLogin = new Login();//Accessing Login class
        
//do while loop, will run at least once
        do                                      
        { 
            this.MenuSetUp();
            num = this.MyScanner.nextInt();
            
        } while (num > 3);                      //
        
        //switch statement to communicate and see where the user wants to go
        switch (num)                           
        {
            case 1:
                myUser.UserInfo();//Accesses userInfo from UserManage class
                break;
            case 2:
                myLogin.loginUser();//Accesses userInfo from Login class
                break;
            default:
                System.out.println("Have a nice day");
                MyScanner.close();//closing the scanner and ending the program
                break;
        }
        
    }
}
//---------------------------------DDDDooooooooooooooooooooo END OF FILE DDDDooooooooooooooooooooo-------------------------------------------//
