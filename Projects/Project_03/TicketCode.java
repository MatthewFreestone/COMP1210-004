import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
/** 
 *  A program intented to process the input of a ticket number in order to 
 *  resturn the information contained in that ticket.
 *
 * @author Matthew Freestone
 * @version 8/23/2020
 */
public class TicketCode {

   /**
    * Takes the code input and processes it to output 
    * information on price and seating.
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) {
      //String desc, date, time, section, row, seat, cost;
      Random random = new Random(); 
      int prize = random.nextInt(998) + 1;
      Scanner input = new Scanner(System.in);
      DecimalFormat money = new DecimalFormat("#,##0.00");
      DecimalFormat prizeForm = new DecimalFormat("000");
   
      System.out.print("Enter ticket code: ");
      String inCode = input.nextLine();
      String trimmedCode = inCode.trim();
      
      if (trimmedCode.length() < 26) {
         System.out.println("\nInvalid ticket code.");
         System.out.println("Ticket code must have at least 26 characters.");
      }
      else {
         double price = Integer.parseInt(trimmedCode.substring(0, 5)) / 100;
         int discount = Integer.parseInt(trimmedCode.substring(5, 7));
        
         String baseTime = trimmedCode.substring(7, 11);
         String time = baseTime.substring(0, 2) + ":" 
                + baseTime.substring(2, 4);
      
         String baseDate = trimmedCode.substring(11, 19);
         String date = baseDate.substring(0, 2) + "/" 
                + baseDate.substring(2, 4) + "/" + baseDate.substring(4, 8);
      
         String section = trimmedCode.substring(19, 21);
         String row = trimmedCode.substring(21, 23);
         String seat = trimmedCode.substring(23, 25);
      
         String desc = trimmedCode.substring(25, trimmedCode.length());
         double cost = price * (1 - ((double) discount / 100));
        
      
         System.out.print("\nDescription: " + desc + "   Date: " + date 
                + "   Time: " + time + "\n");
         System.out.print("Section: " + section + "   Row: " + row 
                + "   Seat: " + seat + "\n");
         System.out.print("Price: $" + money.format(price) + "   Discount: " 
                + discount
                + "%   Cost: $" + money.format(cost) + "\n");
         System.out.println("Prize Number: " + prizeForm.format(prize));
      }
   }
}
