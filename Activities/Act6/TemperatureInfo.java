import java.util.Scanner;
import java.util.ArrayList;
/** 
 * A driver class to create a Temperatures object that represents a list of 
 * inputed temperatures and allows the user to do 
 * comparisons of those temperatures.
 *
 * @author Matthew Freestone
 * @version 9/28/2020
 */
public class TemperatureInfo {

   /**
    * Prompts the user for inputs for the temperaures in the list 
    * and to get information about those temperatures.
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      ArrayList<Integer> tempsList = new ArrayList<Integer>();
      String tempInput = "";
   
      do {
         System.out.print("Enter a temperature (or nothing to end list): ");
         tempInput = userInput.nextLine().trim();
         if (!tempInput.equals("")) {
            tempsList.add(Integer.parseInt(tempInput));
         }
      }
      while (!tempInput.equals(""));
      
      Temperatures temps = new Temperatures(tempsList);
   
      char choice = 'E';
      do {
         System.out.print("Enter choice - [L]ow temp, "
               + "[H]igh temp, [P]rint, [E]nd: ");
         choice = userInput.nextLine().toUpperCase().charAt(0);
         switch (choice) {
            case 'L':
               System.out.println("\tLow is " + temps.getLowTemp());
               break;
         
            case 'H':
               System.out.println("\tHigh is " + temps.getHighTemp());
               break;
         
            case 'P':
               System.out.println(temps);
               break;
         
            case 'E':
               System.out.println("\tDone");
               break;
         
            default:
               System.out.println("\tInvalid choice! ");
         }
      } while (choice != 'E');

      userInput.close();
   }
}