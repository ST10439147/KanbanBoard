/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanbanboard;
import java.util.Scanner;

/**
 *
 * @author Dillon Rinkwest ST10439147 PROG5121 Gr01
 */
public class Login
{
    private final UserManager UserClass = new UserManager();//accessing information in UserManager Class
    private final Scanner myScan = new Scanner(System.in);//instantiating scanner
    PostLogin mypost = new PostLogin();
          
         
        //-----------------------------------------------------------------------------------------------------------------------//
    //Login
        public void loginUser()
    {
        System.out.println("\n"+ConsoleColours.BLUE +"/////////////////////////////////////////////////////");
        System.out.println(ConsoleColours.BLUE +"                    Login                          ");
        System.out.println(ConsoleColours.BLUE +"/////////////////////////////////////////////////////\n");
        
        LoginDetails();
    }
    //---------------------------------------------------------------------------------------------------------------//
   //enter username and password to login to the program
    public void LoginDetails()
    {
        int maxAttempts;//received from chatgpt
        maxAttempts = 4;//received from chatgpt
        int attempts = 0;//received from chatgpt
        boolean loginSuccessful = false;
        //System.out.println(getUsername() +" "+ getPassword());
        
            do
            {
                attempts++;
                //used to read a line of input from the console and store it in the username variable
                System.out.print("Enter username: ");           
                 String username = myScan.nextLine();
                //used to read a line of input from the console and store it in the password variable
                System.out.print("Enter password: ");                                                       
                String password = myScan.nextLine();
                
//checks whethter the entered username and password matches with getUsername and getPassword from the UserManager Class
            if (!isValid(username, password))  
            {
                loginSuccessful = true;
                break; // Exit the loop on successful login
            } 
                else 
            {
                System.out.println(ConsoleColours.RED + "\nLogin failed. Either the Usernsme or Password is incorrect");
                if (attempts >= maxAttempts) //received from chatgpt
                {
                    System.out.println(ConsoleColours.RED +"Maximum login attempts reached.");
                    break; // Exit the loop after maximum attempts
                }
            }
    } while (true);

         if (loginSuccessful) 
         {
        System.out.println(ConsoleColours.GREEN + "Login successful");
        System.out.println("Welcome " + UserClass.FirstName());
        mypost.displayMenu();
         }
        else 
        {
        System.out.println(ConsoleColours.RED + "Login failed. Exiting program.");
        } 
    }
  //----------------------------------------------------------------------------------------------------------------------//  
   protected boolean isValid(String username, String password) 
   {                  
    // Retrieve username and password from UserManager class
    String usernameLoginValid = UserClass.Username();
    String passwordLoginValid = UserClass.Password();

    // Check if the entered username and password and the valid username and password are not null
    if (username != null && password != null && usernameLoginValid != null && passwordLoginValid != null) {
        // Compare the entered username and password with the valid ones
        return username.equals(usernameLoginValid) && password.equals(passwordLoginValid);
    }
    // Return false if any of the values are null or do not match
    return false;
    }
}
//---------------------------------DDDDooooooooooooooooooooo END OF FILE DDDDooooooooooooooooooooo-------------------------------------------//