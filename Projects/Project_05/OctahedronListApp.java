import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/** 
 * Driving app for Octahedron list, allows file io for creating lists.
 *
 * @author Matthew Freestone
 * @version 9/22/2020
 */
public class OctahedronListApp {

   /**
    * Reads a file specified by the user to make a list of octahedrons. 
    *
    * @param args Command line arguments (not used).
    * @throws FileNotFoundException Occurs if the file name 
    *     given cannot be opened.
    */
   public static void main(String[] args) throws FileNotFoundException {
      Scanner terminal = new Scanner(System.in);
      System.out.print("Enter file name: ");
      
      String fileName = terminal.nextLine();
      Scanner inFile = new Scanner(new File(fileName));
   
   
      String listName = inFile.nextLine();
      ArrayList<Octahedron> octArrayList = new ArrayList<Octahedron>();
      while (inFile.hasNext()) {
         String label = inFile.nextLine();
         String color = inFile.nextLine();
         double edge = Double.parseDouble(inFile.nextLine());
         octArrayList.add(new Octahedron(label, color, edge));
      }
   
      OctahedronList octList = new OctahedronList(listName, octArrayList);
   
      System.out.println("\n" + octList + "\n");
      System.out.println(octList.summaryInfo());
   
      terminal.close();
      inFile.close();
   }
}