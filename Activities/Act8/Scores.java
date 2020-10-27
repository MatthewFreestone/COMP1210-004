import java.util.ArrayList;

/** 
 * A class for score objects that will return and format data inside an array. 
 *
 * @author Matthew Freestone
 * @version 10/27/2020
 */

public class Scores {

   private int[] numbers; 

   /**
    * Constructor, allows you to put in an array of integers.
    *
    * @param numbersIn the array of integers to start with
    */
   public Scores(int[] numbersIn) {
      numbers = numbersIn; 
   }

   
   /**
    * Returns the even numbers in the score array. 
    * 
    * @return int[] even numbers from the array
    */
   public int[] findEvens() {
      int numberEvens = 0;

      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            numberEvens++;
         }
      }
      int[] evens = new int[numberEvens];

      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            evens[count] = numbers[i];
            count++;
         }
      }
      return evens;
   }

   
   /**
    * Returns the odd numbers in the score array. 
    * 
    * @return int[] odd numbers from the array
    */
   public int[] findOdds() {
      ArrayList<Integer> odds = new ArrayList<Integer>();
      for (int i : numbers) {
         if (i % 2 == 1) {
            odds.add(i);
         }
      }
      int[] oddsArray = new int[odds.size()];
      for (int i = 0; i < oddsArray.length; i++) {
         oddsArray[i] = odds.get(i);
      }
      return oddsArray;
   }

   
   /**
    * Calculates the mean of the values in the score array.  
    * 
    * @return double average of the data 
    */
   public double calculateAverage() {
      double sum = 0;

      for (int i = 0; i < numbers.length; i++) {
         sum += numbers[i];
      }
      return (sum / numbers.length);
   }
 
   
   /**
    * Formats the data in the array in order. 
    * 
    * @return String Representation of the data in the array. 
    */
   public String toString() {
      String result = "";

      for (int i = 0; i < numbers.length; i++) {
         result += numbers[i] + "\t";
      }

      return result; 

   }

   
   /**
    * Formats the data in the array in reverse order. 
    * 
    * @return String Representation of the data in the array reversed. 
    */
   public String toStringInReverse() {
      String result = "";

      for (int i = numbers.length - 1; i >= 0; i--) {
         result += numbers[i] + "\t";
      }

      return result; 
   }



}