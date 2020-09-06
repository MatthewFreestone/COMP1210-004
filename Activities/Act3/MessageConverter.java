import java.util.Scanner;
/** 
 * This program's purpose is to demonstrate manupulating
 * a string using the methods in the String class.  
 *
 * @author Matthew Freestone
 * @version 9/6/2020
 */
public class MessageConverter {

   /**
    * Fetches inputs, does operations on the string, and outputs the result.
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      String message = "";
      String result = "";
   
      System.out.print("Type in a message and press enter:\n\t> ");
      message = userInput.nextLine();
   
      System.out.print("\nOutput types:"
            + "\n\t0: As is "
            + "\n\t1: Trimmed"
            + "\n\t2: lower case"
            + "\n\t3: UPPER CASE" 
            + "\n\t4: v_w_ls r_pl_c_d"
            + "\n\t5: Without first and last character"
            + "\nEnter your choice: ");
      int outputType = Integer.parseInt(userInput.nextLine());
     
      if (outputType == 0) { // as is 
         result = message;
      }
      else if (outputType == 1) { // trimmed
         result = message.trim();
      }
      else if (outputType == 2) { // lower case
         result = message.toLowerCase();
      }
      else if (outputType == 3) { // upper case
         result = message.toUpperCase();
      }
      else if (outputType == 4) { // replace vowels
         char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
         result = message;
         for (char c : vowels) {
            result = result.replace(c, '_');
         }
      }
      else if (outputType == 5) { // without first and last character
         result = message.substring(1, message.length() - 1);
      }
      else { // invalid input 
         result = "Error: Invalid choice input.";
      }
      System.out.println("\n" + result);
   }
}