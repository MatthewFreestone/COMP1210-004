/** 
 * A program that provides two division methods. 
 *
 * @author Matthew Freestone
 * @version 11/13/2020 
 */
public class Division {

   /**
    * Divides two number to get an integer.
    * @param num numerator
    * @param denom denominator
    * @return int result
    */
   public static int intDivide(int num, int denom) {
      try {
         return (num / denom);
      }
      catch (ArithmeticException e) {
         return 0;
      }
   }

   /**
    * Divides two number to get an double.
    * @param num numerator
    * @param denom denominator
    * @return double result
    */
   public static double decimalDivide(int num, int denom) {
      if (denom == 0) {
         throw new IllegalArgumentException("The denominator "
               + "cannot be zero.");
      }
      return ((double) num / (double) denom);
   }
}