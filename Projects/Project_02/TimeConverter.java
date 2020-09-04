import java.util.Scanner; 
/** 
 * A timer that gives a time in seconds as hours:min:sec. 
 * 
 *
 * @author Matthew Freestone
 * @version 9/4/2020
 */
public class TimeConverter {

  /**
   * Method for reading input and sending output for the times.
   *
   * @param args Command line arguments (not used).
   */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
   
      System.out.print("Enter the raw time measurement in seconds: ");
      int inSeconds = input.nextInt();
   
      if (inSeconds >= 0) {
         int days, hours, minutes, outSeconds; 
      
         outSeconds = inSeconds;
         days = (int) Math.floor(outSeconds / 86400);
         outSeconds %= 86400; 
      
         hours = (int) Math.floor(outSeconds / 3600);
         outSeconds %= 3600; 
      
         minutes = (int) Math.floor(outSeconds / 60);
         outSeconds %= 60; 
      
         System.out.println("\nMeasurement by combined days, "
               + "hours, minutes, seconds:");
         System.out.println("\tdays: " + days);
         System.out.println("\thours: " + hours);
         System.out.println("\tminutes: " + minutes);
         System.out.println("\tseconds: " + outSeconds + "\n");
         System.out.println(inSeconds + " seconds = " + days
                + " days, " + hours + " hours, " 
                + minutes + " minutes, " + outSeconds + " seconds");
      }
      else {
         System.out.println("Measurement must be non-negative!");
      }
   }
}