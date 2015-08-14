/**
 * A program that creates randomly generated passwords based on user parameters
 * @author G. Stewart  
 * @version 8/14/2015
 */
import java.util.Scanner;

public class PassGen
{
    public static void main(String[] args)
    {
      Scanner keyboard = new Scanner(System.in);
      int passwordType;
      int passwordLength;
      int[] maxGen = new int[]{}, minGen = new int[]{};
      
      //Overall Endless Loop for the Program
      while(true)
      { 
         //Loop for Type Information
         do
         {     
        	System.out.println("\t\tPassword Gneration Menu");
            System.out.println("***********************************************************");
            System.out.println("*    [1] Lowercase Letters\t\t\t\t  *");
            System.out.println("*    [2] Lowercase & Uppercase Letters\t\t\t  *");
            System.out.println("*    [3] Lowercase, Uppercase, and Numbers\t\t  *");
            System.out.println("*    [4] Lowercase, Uppercase, Numbers, and Punctuation   *");
            System.out.println("*    [5] Quit\t\t\t\t\t\t  *");
            System.out.println("***********************************************************");
      
            System.out.print("Enter Selection (1-5): ");
            passwordType = keyboard.nextInt();
          
            if(passwordType == 1)
            {
               minGen = new int[]{97};
               maxGen = new int[]{122};
            }
            else if(passwordType == 2)
            {
               //Lower & UperCase Letters
               minGen = new int[]{97, 65};
               maxGen = new int[]{122, 90};
            }
            else if(passwordType == 3)
            {
               //Lower, Uppercase & numbers
               minGen = new int[]{97, 65, 48};
               maxGen = new int[]{122, 90, 57};
            }
            else if(passwordType == 4)
            {
               minGen = new int[]{48};
               maxGen = new int[]{126};
            }
            else if(passwordType == 5)
            {
            	keyboard.close();
            	System.exit(0);
            }
            else
            {
            	System.out.println("Incorrect Selection!\n");
            }
          
         } while(!(passwordType > 0 && passwordType <= 5));

         do
         {     
        	 System.out.print("\nPassword Length (1-128): ");
        	 passwordLength = keyboard.nextInt();
         
        	 if(passwordLength < 0 || passwordLength > 128)
        	 {
        		 System.out.println("Incorrect Password Length!\n");
        	 }
      
         }while(!(passwordLength > 0 && passwordLength <= 128));
      
         //ALL CODES GREEN!
      
         int[] tempAnswerHolding = new int[minGen.length];
         int displayAnswer = 0;
                
         System.out.print("\nPassword: ");
                
         for(int i = 0; i < passwordLength; i++)
         {
            //System that generates numbers based on the min / max and if there's more than one set it generates the 
            //amount of ones that exist in that range and then picks one from the number of the ones in the array
            for(int j = 0; j < minGen.length; j++)
            {
            	tempAnswerHolding[j] = (int)(Math.random() * (maxGen[j] - minGen[j])) + minGen[j];
            }
                
            //If more than one number it picks one of them
            displayAnswer = tempAnswerHolding[((int)(Math.random() * (tempAnswerHolding.length - 0)) + 0)];
                  
            System.out.print((char)displayAnswer);
         }
      
        System.out.println("\n");   
      	}//End Of While Loop
    } //End Of Main
} //End Of Class
