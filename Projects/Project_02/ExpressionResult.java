import java.util.Scanner; 
/** 
 * Uses the expression from the project description to make a 
 * calculation given 3 variables. 
 *
 * @author Matthew Freestone
 * @version 9/4/2020
 */
public class ExpressionResult {

   /**
    * Prints a mathematical answer given 3 variables.
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) {
      double x, y, z;
      Scanner input = new Scanner(System.in);
      //expression being used
      System.out.println("result = (x - 1.1) (2y + 2.2) (4z + 4.4) / xyz");
   
      System.out.print("\tx = ");
      x = input.nextDouble();
   
      System.out.print("\ty = ");
      y = input.nextDouble();
   
      System.out.print("\tz = ");
      z = input.nextDouble();
      
      double result;
      if (x * y * z != 0) {
         result = (x - 1.1) * (2 * y + 2.2) * (4 * z + 4.4) / (x * y * z);
         System.out.println("result = " + result);
      }
      else {
         System.out.println("result is \"undefined\"");
      }
   
   }
}