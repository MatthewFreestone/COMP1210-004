import java.text.DecimalFormat;
import java.util.ArrayList;

/** 
 * A class representing an arraylist of octahedrons.
 *
 * @author Matthew Freestone
 * @version 9/22/2020
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
}