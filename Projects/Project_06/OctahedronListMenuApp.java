import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
/** 
 * A class used to drive the Octahedron List class and make a usable user 
 * interface to interact with an instance of OctahedronList
 * 
 *
 * @author Matthew Freestone
 * @version 9/29/2020
 */
public class OctahedronListMenuApp {

    /**
     * Prints to the user and reads their response to return 
     * information about an OctahedronList.
     *
     * @param args Command line arguments (not used).
     * @throws FileNotFoundException if filename given cannot be found 
     */
   public static void main(String[] args) throws FileNotFoundException {
    
      String label, color;
      double edge;
      Octahedron result;
      String blankName = "*** no list name assigned ***";
      ArrayList<Octahedron> blank = new ArrayList<Octahedron>();
      OctahedronList octList = new OctahedronList(blankName, blank);
      Scanner terminalIn = new Scanner(System.in);
      System.out.println("Octahedron List System Menu");
      System.out.println("R - Read File and Create Octahedron List");
      System.out.println("P - Print Octahedron List");
      System.out.println("S - Print Summary");
      System.out.println("A - Add Octahedron");
      System.out.println("D - Delete Octahedron");
      System.out.println("F - Find Octahedron");
      System.out.println("E - Edit Octahedron");
      System.out.println("Q - Quit");
      char choice = 'Q';
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         choice = terminalIn.nextLine().toUpperCase().charAt(0);
         switch(choice) {
            case 'R':
               System.out.print("\tFile Name: ");
               String fileName = terminalIn.nextLine();
               System.out.println("\tFile read in and Octahedron List "
                        + "created\n");
               octList = octList.readFile(fileName);
               break;    
            case 'P':
               System.out.println(octList);
               break;
             
            case 'S':
               System.out.println("\n" + octList.summaryInfo());
               break;    
            case 'A':
               System.out.print("\tLabel: ");
               label = terminalIn.nextLine();
               System.out.print("\tColor: ");
               color = terminalIn.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(terminalIn.nextLine());
               octList.addOctahedron(label, color, edge);
                    
               System.out.println("\t*** Octahedron added ***\n");
            
               break;
                
            case 'D':
               System.out.print("\tLabel: ");
               label = terminalIn.nextLine();
               result = octList.deleteOctahedron(label);
               if (result != null) {
                  System.out.println("\t\"" + result.getLabel() 
                        + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
            
               break;
         
            case 'F':
               System.out.print("\tLabel: ");
               label = terminalIn.nextLine();
               result = octList.findOctahedron(label);
               if (result != null) {
                  System.out.println(result + "\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
            
               break;
                
            case 'E':
               System.out.print("\tLabel: ");
               label = terminalIn.nextLine();
               System.out.print("\tColor: ");
               color = terminalIn.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(terminalIn.nextLine());
               result = octList.editOctahedron(label, color, edge);
               
               if (result != null) {
                  System.out.println("\t\"" + result.getLabel() 
                        + "\" successfully edited\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
                   
               break;   
            case 'Q':
               break;
         
            default:
               System.out.println("\t*** invalid code ***\n");
         
            
         }
      } while (choice != 'Q');
   
      terminalIn.close();
   
   
        
      
   }
}