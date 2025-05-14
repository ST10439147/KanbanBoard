/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanbanboard;
import java.util.Scanner;
import java.util.regex.*;
//import java.util.HashMap;

/**
 *
 * @author Dillon Rinkwest ST10439147 PROG5121 Gr01
 */
public class UserManager
{
//'^': asserts the start of the string
// (?=.*[0-9]): ensures that the string contains at least one digit (0-9)
//(?=.*[a-z]): ensures that the string contains at least one lowercase letter (a-z)
//(?=.*[A-Z]): ensures that the string contains at least one uppercase letter (A-Z)
//(?=.*[!@#$%^&*(),.?\":{}|<>]): ensures that the string contains at least one special character from the provided set (!@#$%^&*(),.?":{}|<>)
//(.{8,20}): matches any character (.) between 8 and 20 times ({8,35}), ensuring the length of the string is between 8 and 20 characters    
// '$': asserts the end of the string.

    //Code received from blackbox.ai
    private final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>])(.{8,35})$");

    //Declaring the scanner
    private final Scanner scanner = new Scanner(System.in);
    //-----------------------------------------------------------------------------------------------------------------------------------------//
    //Default constructor
    public UserManager()
    {
        this.username = "";
        this.password = "";
    }
 //----------------------------------------------------------------------------------------------------------------------------------------------------------//   
//getters
    public static String FirstName() //receives the input for firstname
    {
        return firstName;
    }
    public static String Surname() //receives the input for surname
    {
        return surname;
    }
    public static String Username() //receives the input for username
    {
        return username;
    }
    public static String Password() //receives the input for password
    {
        return password;
    }

        
    private static String firstName = "";      //User firstname
    private static String surname = "";      //User surname
    private static String username = "";       //User username
    private static String password = "";       //user password
    

//------------------------------------------------------------------------------------------------------------------------------------------//        
//Displays to interact with users
    public void UserInfo()
	{
        Scanner myscanner;               //Scanner being defined
        myscanner = new Scanner(System.in);
        Menu menuClass = new Menu();
                
        //Using a console
        System.out.print("Enter first name: ");
         //used to read a line of input from the console and store it in the firstName variable
        this.firstName = myscanner.nextLine();
                
        System.out.print("Enter surname: ");
        //used to read a line of input from the console and store it in the surname variable
        this.surname = myscanner.nextLine();
        
            System.out.println("Hello " + FirstName());

        UsernameCreate();//Use of usernameCreate method
        
        passwordCreate();   //Use of passwordCreate method
        
        System.out.println("Your Username is: " + Username()
                +"\nYour password is: " + Password());
        
        menuClass.displayMenu();//Going back to the menu once all methods have been satisfied
        
        myscanner.close();//closing the console for input
        
        }
    //------------------------------------------------------------------------------------------------------------------------------------------//        
    //method to create the username
    public void UsernameCreate()
    {
        do
        {     
            System.out.println("\n" + ConsoleColours.PURPLE + "Note: For the password to be accepted, it needs these requirements:");
            System.out.println(ConsoleColours.PURPLE + "Username must be at most 5 characters long and contain an underscore '_'");
            
            System.out.print("Enter username: ");    //used to read a line of input from the console and store it in the username variable
            String usernameEnt = scanner.nextLine();   
            
            if (this.validUserName(usernameEnt)) //checks if requirements for username have been met
            {
                this.username = usernameEnt;
                System.out.println(ConsoleColours.GREEN + "Username has successfully been recorded");
                break;               
            }
            else
            {
                System.out.println(ConsoleColours.RED+"Invalid Username");
            }            
        } while (true);
    }
//------------------------------------------------------------------------------------------------------------------------------------------//        
    //Method for username validation
    protected boolean validUserName(String usernameEnt)//Code received from blackbox.ai
    {
        //validation code to see whether the input data is
        //less than and equal to 5 chracters long
        //And contains an underscore
        return usernameEnt != null && usernameEnt.length() <= 5 && usernameEnt.matches(".*_.*");
    }
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------------//
    public void passwordCreate()
    {        
        do
        {  
            //Allows the user to understand the specifications needed
            System.out.println("\n" + ConsoleColours.BLUE + "Note: For the password to be accepted, it needs these requirements:");
            System.out.println(ConsoleColours.BLUE + "Password must be at least 8 characters long, 1 capital letter, "
                    + "1 special character and 1 numerical value");
            
            System.out.print("Enter password: "); 
                //used to read a line of input from the console and store it in the password variable
            String Passwordent = this.scanner.nextLine();
            
            if (this.checkPasswordComplexity(Passwordent)) //Check if Password Complexity is correct
            {
                this.password = Passwordent;
                System.out.print("\n" +ConsoleColours.GREEN +"Password has successfully been recorded\n");
                break;
            }
            else
            {
                System.out.print("\n" +ConsoleColours.RED + "Password does not meet the requirements\n");
            }            
        } while (true);
         
    }
    //------------------------------------------------------------------------------------------------------------------------------------------//        
    //method to check the password complexity
    public boolean checkPasswordComplexity(String Passwordent)// code received from blackbox.ai
    {
        //checks if the entire input sequence matches the pattern
        //it will return true if Passwordent matches the pattern defined by PASSWORD_PATTERN, and false otherwise.
        Matcher matcher;
        matcher = PASSWORD_PATTERN.matcher(Passwordent);   //received
        return matcher.matches();        
    }
}
//---------------------------------DDDDooooooooooooooooooooo END OF FILE DDDDooooooooooooooooooooo-------------------------------------------//
