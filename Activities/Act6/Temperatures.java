import java.util.ArrayList;
/** 
 * A class used to hold an arraylist of integers representing temperatures
 * and do comparisons to other temperatures.
 * 
 *
 * @author Matthew Freestone
 * @version 9/28/2020
 */
public class Temperatures {
   private ArrayList<Integer> temperatures;

   
   /**
    * Constructor for the class 
    * 
    * @param tempIn The ArrayList of integers representing temperatures 
    */
   public Temperatures(ArrayList<Integer> tempIn) {
      temperatures = tempIn;
   }

   
   /**
    * Returns the lowest temperature in the list.  
    * 
    * @return int lowest temperature
    */
   public int getLowTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int low = temperatures.get(0);
      for (int i = 0; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i);
         }
      }
      return low; 
   
   }
   
   /** 
    * Returns the highest temperature in the list.  

    * @return int highest temperature
    */
   public int getHighTemp() {
   
      if (temperatures.isEmpty()) {
         return 0;
      }
      int high = temperatures.get(0);
      for (int t : temperatures) {
         if (t > high) {
            high = t;
         }
      }
      return high; 
   }

   
   /** 
    * Returns the lowest temperature of the list and the inputed integer.
    * 
    * @param lowIn the low value to be compared to 
    * @return int the lowest temperature in both sets
    */
   public int lowerMinimum(int lowIn) {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }
   
   /** 
    * Returns the highest temperature of the list and the inputed integer.

    * @param highIn the high value to be compared to 
    * @return int the highest temperature in both sets
    */
   public int higherMaximum(int highIn) {
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }

   
   /**
    * Returns a string represenation of the instance.  
    * 
    * @return String representation of the instance
    */
   public String toString() {
      return "\tTemperatures: " + temperatures
            + "\n\tLow: " + getLowTemp()
            + "\n\tHigh: " + getHighTemp();
   }
}