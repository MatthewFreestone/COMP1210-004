import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
/** 
 * A class representing an arraylist of octahedrons.
 *
 * @author Matthew Freestone
 * @version 9/29/2020
 */
public class OctahedronList {

   private String listName = "";
   private ArrayList<Octahedron> list = new ArrayList<Octahedron>();

   /** 
    * Constructor the the class.
    *
    * @param name Name of list
    * @param inList The arraylist of octahedrons
    */
   public OctahedronList(String name, ArrayList<Octahedron> inList) {
      listName = name;
      list = inList;
   }

   
   /**
    * Returns name of the list. 
    * 
    * @return String the name
    */
   public String getName() {
      return listName;
   }

   
   /** 
    * Returns the number of Octahedrons in the list.
    * 
    * @return int the number of Octahedrons
    */
   public int numberOfOctahedrons() {
      return list.size();
   }

   
   /**
    * Returns the total surface area of all of the Octahedrons in the list.
    * 
    * @return double Total surface area
    */
   public double totalSurfaceArea() {
      double total = 0;
      if (numberOfOctahedrons() != 0) {
         for (Octahedron oct : list) {
            total += oct.surfaceArea();
         }
      }
      return total;
   }

   
   /** 
    * Returns the total volume of all of the Octahedrons in the list.
    * 
    * @return double Total Volume
    */
   public double totalVolume() {
      double total = 0;
      if (numberOfOctahedrons() != 0) {
         for (Octahedron oct : list) {
            total += oct.volume();
         }
      }
      return total;
   }

   
   /** 
    * Returns the average surface area of all of the Octahedrons in the list.
    *
    * @return double average surface area
    */
   public double averageSurfaceArea() {
      if (list.size() == 0) {
         return 0;
      }
      return totalSurfaceArea() / list.size();
   }

   
   /**
    * Returns the average volume of all of the Octahedrons in the list.
    * 
    * @return double average volume
    */
   public double averageVolume() {
      if (list.size() == 0) {
         return 0;
      }
      return totalVolume() / list.size();
   }

   
   /** 
    * Returns the average surface area to volume ratio
    * of all of the Octahedrons in the list.
    *
    * @return double average surface area / volume.
    */
   public double averageSurfaceToVolumeRatio() {
      double total = 0;
      if (numberOfOctahedrons() != 0) {
         for (Octahedron oct : list) {
            total += oct.surfaceToVolumeRatio();
         }
         return total / numberOfOctahedrons();
      }
      return 0;
   } 
   
   /** 
    * Formats instance variables to be printed nicely. 
    * 
    * @return String
    */
   public String toString() {
      String output = listName + "\n";
      for (Octahedron o : list) {
         output +=  "\n" + o.toString() + "\n";
      }
   
      return output;
   }

   
   /**
    * Returns a summary of information from the Octahedrons in the list.  
    * 
    * @return String the summary
    */
   public String summaryInfo() {
      DecimalFormat format = new DecimalFormat("#,##0.0##");
      String output = "----- Summary for " + listName + " -----\n";
      output += "Number of Octahedrons: " + list.size() + "\n";
      output += "Total Surface Area: " 
            + format.format(totalSurfaceArea()) + "\n";
      output += "Total Volume: " + format.format(totalVolume()) + "\n";
      output += "Average Surface Area: " 
            + format.format(averageSurfaceArea()) + "\n";
      output += "Average Volume: " + format.format(averageVolume()) + "\n";
      output += "Average Surface/Volume Ratio: " 
            + format.format(averageSurfaceToVolumeRatio()) + "\n";
      return output;
   
   }

   
   /** 
    * Returns the arrayList that houses the Octahedrons. 

    * @return ArrayList the interal list of Octahedron objects 
    */

   public ArrayList<Octahedron> getList() {
      return list;
   }

   
   /**
    * Reads a file with data about an OctahedronList and returns an
    *  OctahedronList made from this data 
    * 
    * @param fileName The name of tthe file to be read
    * @return OctahedronList A list made of the data
    * @throws FileNotFoundException Throws if the file cannot be found 
    */
   public OctahedronList readFile(String fileName) 
      throws FileNotFoundException {
   
      Scanner inFile = new Scanner(new File(fileName));
      String listNameIn = inFile.nextLine();
      ArrayList<Octahedron> octArrayList = new ArrayList<Octahedron>();
      while (inFile.hasNext()) {
         String label = inFile.nextLine();
         String color = inFile.nextLine();
         double edge = Double.parseDouble(inFile.nextLine());
         octArrayList.add(new Octahedron(label, color, edge));
      }
   
      OctahedronList output = new OctahedronList(listNameIn, octArrayList);
      inFile.close();
      return output;
   }

   
   /** 
    * Adds an octahedron to the arraylist of octahedrons.
    * 
    * @param labelIn the label of the new octahedron
    * @param colorIn the color of the new octahedron
    * @param edgeIn the edge length of the new octahedron
    */
   public void addOctahedron(String labelIn, String colorIn, double edgeIn) {
      list.add(new Octahedron(labelIn, colorIn, edgeIn));
   }

   
   /** 
    * Returns an octahedron in the list that matches the inputed String label, 
    *  and returns null if one cannot be found.
    * 
    * @param octName The label of the Octahedron being searched for
    * @return Octahedron the octahedron when found, null when not 
    */
   public Octahedron findOctahedron(String octName) {
      for (Octahedron oct : list) {
         if (oct.getLabel().toLowerCase().equals(octName.toLowerCase())) {
            return oct;
         }
      }
      //oct not found
      return null;
   }

   
   /** 
    *  Returns an octahedron in the list that matches the inputed String label, 
    *  and returns null if one cannot be found. This also deletes the octahedron
    *  from the ArrayList.
    * 
    * 
    * @param octName The label of the Octahedron being deleted
    * @return Octahedron the octahedron when found, null when not 
    */
   public Octahedron deleteOctahedron(String octName) {
      Octahedron found = findOctahedron(octName);
      list.remove(found);
      return found; 
   }

   
   /**
    * Edits an octahedron of the given label and returns that octahedron. 
    * Returns null when no octahedron with that label can be found. 
    * 
    * @param octName The label of the Octahedron wanting to be edited
    * @param colorIn The new color of the Octahedron
    * @param edgeIn The new edge length of the Octahedron
    * @return Octahedron
    */
   public Octahedron editOctahedron(String octName, 
      String colorIn, double edgeIn) {
         
      Octahedron found = findOctahedron(octName);
      if (found != null) {
         found.setColor(colorIn);
         found.setEdge(edgeIn);
      }

      return found; 
   }
}