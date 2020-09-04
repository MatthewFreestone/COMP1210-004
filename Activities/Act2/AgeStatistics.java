import java.util.Scanner;
/** 
 * A program that tells a user what their average heartrate and 
 *    age in different formats given their age and sex.
 *
 * @author Matthew Freestone
 * @version 8/31/2020
 */
public class AgeStatistics {

   /**
    * Prompts users for personal information to tell them age in two formats. 
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) {
     
      Scanner userInput = new Scanner(System.in);
      String name = "";
      int ageInYears = 0;
      int gender = 0;
      double maxHeartRate = 0;
      
      //Prompt the user for their name:
      System.out.print("Enter your name: ");
      name = userInput.nextLine();
      
      //Prompt the user for their age:
      System.out.print("Enter your age in years: ");
      ageInYears = userInput.nextInt();
      
      //Prompt the user for their sex (not gender):
      System.out.print("Enter your gender (1 for female and 0 for male): ");
      gender =  userInput.nextInt();
      
      //Convert age:
      System.out.println("\tYour age in minutes is " 
            + ageInYears * 525600 + " minutes.");
      System.out.println("\tYour age in centuries is "
            + (double) ageInYears / 100 + " centuries.");
            
            
      if (gender == 1) {
         maxHeartRate = 209 - (0.7 * ageInYears);
      }
      else {
         maxHeartRate = 214 - (0.8 * ageInYears);
      }
      
      //display max heart rate
      System.out.println("Your max heart rate is "
            + maxHeartRate + " beats per minute.");
      
            
      
   }
   
}