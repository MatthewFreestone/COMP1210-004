import java.util.Scanner;
/** 
 * Provides a terminal way to interact with the Octahedron class.
 *
 * @author Matthew Freestone
 * @version 9/12/2020
 */
public class OctahedronApp {

   /**
    * Uses user input information to create octahedron classes. 
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter label, color, and " 
            + "edge length for an octahedron.");
      System.out.print("\tlabel: ");
      String label = input.nextLine();
      System.out.print("\tcolor: ");
      String color = input.nextLine();
      System.out.print("\tedge: ");
      Double edge = input.nextDouble();
      if (edge >= 0) {
         System.out.println("\n" + new Octahedron(label, color, edge));
      }
      else {
         System.out.println("Error: edge must be non-negative.");
      }
   }
}