/** 
 * A class intented to return information for a certain number.
 *
 * @author Matthew Freestone
 * @version 8/23/2020
 */
public class NumberOperations {

   private int number; 


   
   /**
    * Constructor for class. 
    * 
    * @param numberIn The number the class looks at.
    */
   public NumberOperations(int numberIn) {
      number = numberIn;
   }

   
   /**
    * Returns the number that the class uses 
    * 
    * @return int The number
    */
   public int getValue() {
      return number;
   }

   
   /**
    * Returns all of the odd numbers under the number 
    * 
    * @return String Odds separated by a tab
    */
   public String oddsUnder() {
      String output = "";
      for (int i = 0; i < number; i++) {
         if (i % 2 != 0) {
            output += i + "\t";
         }
      }
      return output;
   }

   
   /** 
    * Returns all of the powers of 2 under the number 
    * 
    * @return String Powers of 2 separated by a tab
    */
   public String powersTwoUnder() {
      String output = "";
      for (int i = 1; i < number; i *= 2) {
         output += i + "\t";
      }
      return output;
   }

   
   /** 
    * Returns if the parameter is higher, lower, or equal to the number.
    * 
    * @param compareNumber The number used for comparison.
    * @return int 1 for greater, -1 for less, and 0 for equal
    */
   public int isGreater(int compareNumber) {
      if (number > compareNumber) {
         return 1;
      }
      else if (number < compareNumber) {
         return -1;
      }
      else {
         return 0;
      }
   }

   
   /**
    * Returns the number the class uses as a string. 
    * 
    * @return String the number
    */
   public String toString() {
      return number + "";
   }
}
