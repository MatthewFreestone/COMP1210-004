import java.util.Scanner;
import java.text.DecimalFormat;
/** 
 *  A program that, given an input, gives the solution to an expression and 
 *  formats the result in a standard format for decimals. 
 *
 * @author Matthew Freestone
 * @version 8/23/2020
 */
public class FormulaSolver {

   /**
    * Does the math calculations and prints the lines to the screen.
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      DecimalFormat format = new DecimalFormat("#,##0.0#####");

      // print course description
      System.out.print("Enter a value for x: ");
      double x = input.nextDouble();
      double firstTerm = 6 * Math.pow(x, 3) - 4;
      double secondInside = 7 * Math.pow(x, 3) + 5 * Math.pow(x, 2) + 3 * x + 1;
      double result = firstTerm * Math.sqrt(Math.abs(secondInside));

      String strResult = Double.toString(result);
      String[] splitString = strResult.split("\\."); 
      int lenBeforeDot = splitString[0].length();
      int lenAfterDot = splitString[1].length();

      String formatted = format.format(result);

      System.out.println("Result: " + result);
      System.out.println("# of characters to left of decimal point: " 
            + lenBeforeDot);
      System.out.println("# of characters to right of decimal point: " 
            + lenAfterDot);
      System.out.println("Formatted Result: " + formatted);

   }
}