import java.text.DecimalFormat;

/** 
 * A class representing an array of Spherocylinders.
 *
 * @author Matthew Freestone
 * @version 10/29/2020
 */
public class SpherocylinderList {

   private String listName = "";
   private Spherocylinder[] array;
   private int arrayLen; 

   /** 
    * Constructor the the class.
    *
    * @param name Name of SpherocylinderList
    * @param arrayIn The array of Spherocylinders
    * @param lenIn number of Spherocylinders in the array
    */
   public SpherocylinderList(String name, Spherocylinder[] arrayIn, int lenIn) {
      listName = name;
      array = arrayIn.clone();
      arrayLen = lenIn;
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
    * Returns the number of Spherocylinders in the list.
    * 
    * @return int the number of Spherocylinders
    */
   public int numberOfSpherocylinders() {
      return arrayLen;
   }

   
   /**
    * Returns the total surface area of all of the Spherocylinders in the list.
    * 
    * @return double Total surface area
    */
   public double totalSurfaceArea() {
      double total = 0;
      if (arrayLen != 0) {
         for (Spherocylinder sph : array) {
            if (sph != null) {
               total += sph.surfaceArea();
            }
         }
      }
      return total;
   }

   
   /** 
    * Returns the total volume of all of the Spherocylinders in the list.
    * 
    * @return double Total Volume
    */
   public double totalVolume() {
      double total = 0;
      if (arrayLen != 0) {
         for (Spherocylinder sph : array) {
            if (sph != null) {
               total += sph.volume();
            }
         }
      }
      return total;
   }

   
   /** 
    * Returns the average surface area of all of the Spherocylinders 
    * in the list.
    *
    * @return double average surface area
    */
   public double averageSurfaceArea() {
      if (arrayLen == 0) {
         return 0;
      }
      return totalSurfaceArea() / arrayLen;
   }

   
   /**
    * Returns the average volume of all of the Spherocylinders in the list.
    * 
    * @return double average volume
    */
   public double averageVolume() {
      if (arrayLen == 0) {
         return 0;
      }
      return totalVolume() / arrayLen;
   }


   /**
    * Returns the array that holds the Spherocylinder objects. 

    * @return array of Spherocylinders 
    */
   public Spherocylinder[] getList()
   {
      return array; 
   }

   /**
    * Adds a Spherocylinder to the array with the requested dimensions. 
    * 
    * @param labelIn label of new Spherocylinder
    * @param radiusIn radius of new Spherocylinder
    * @param heightIn height of new Spherocylinder
    */
   public void addSpherocylinder(
      String labelIn, double radiusIn, double heightIn) {
   
      Spherocylinder newSph = new Spherocylinder(labelIn, radiusIn, heightIn);
      Spherocylinder[] newArray = new Spherocylinder[array.length + 1];
      for (int i = 0; i < array.length; i++) {
         newArray[i] = array[i];
      }
      newArray[arrayLen] = newSph;
      arrayLen++;
      array = newArray.clone();
   }

   /** 
    * Returns a Spherocylinder in the array that matches the inputed 
    * String label, and returns null if one cannot be found.
    * 
    * @param sphName The label of the Spherocylinder being searched for
    * @return Spherocylinder the Spherocylinder when found, null when not 
    */
   public Spherocylinder findSpherocylinder(String sphName) {
      int index = findSphIndex(sphName);
   
      if (index == -1) {
         return null;
      }
      return array[index];
   }

   /**
    * Returns the index of a Spherocylinder in the array 
    * that matches the inputed label; return -1 if not found.
    *
    * @param sphName label being searched for
    * @return index of found Spherocylinder
    */
   private int findSphIndex(String sphName) {
      for (int i = 0; i < arrayLen; i++) {
         if (array[i].getLabel().toLowerCase().equals(sphName.toLowerCase())) {
            return i;
         }
      }
      return -1;
   }


   /** 
    * Returns a Spherocylinder in the list that matches the inputed 
    * String label, and returns null if one cannot be found. 
    * This also deletes the Spherocylinder from the array.
    *  
    * 
    * 
    * @param sphName The label of the Spherocylinder being deleted
    * @return Spherocylinder the Spherocylinder when found, null when not 
    */
   public Spherocylinder deleteSpherocylinder(String sphName) {
   
      int remIndex = findSphIndex(sphName);
      if (remIndex == -1) {
         return null;
      }
      Spherocylinder deleted = array[remIndex];
   
      Spherocylinder[] newArray = new Spherocylinder[arrayLen];
      for (int i = 0; i < remIndex; i++) {
         newArray[i] = array[i];
      }
      for (int i = remIndex; i < arrayLen - 1; i++) {
         newArray[i] = array[i + 1];
      }
      newArray[newArray.length - 1] = null;
      arrayLen--;
      array = newArray.clone();
   
   
      return deleted;
   }


   /**
    * Edits the Spherocylinder that matches the inputed label with the new
    * radius and height. If there is not a matching Spherocylinder, return null.
    *
    * @param labelIn Label of Spherocylinder to match 
    * @param radiusIn new radius of the Spherocylinder
    * @param heightIn new height of the Spherocylinder
    * @return true/false based off if the edit was successful 
    */
   public boolean editSpherocylinder(
      String labelIn, double radiusIn, double heightIn) {
   
      Spherocylinder found = findSpherocylinder(labelIn);
      if (found != null) {
         found.setRadius(radiusIn);
         found.setCylinderHeight(heightIn);
         return true;
      }
   
      return false; 
   }

   /**
    * Returns the Spherocylinder with the largest volume. 
    *
    * @return the Spherocylinder with the largest volume. 
    */
   public Spherocylinder findSpherocylinderWithLargestVolume() {
      if (arrayLen == 0) {
         return null;
      }
      double max = Double.MIN_VALUE;
      int index = 0; 
      for (int i = 0; i < arrayLen; i++) {
         if (array[i].volume() > max) {
            max = array[i].volume();
            index = i; 
         }
      }
      return array[index];
   }


   
   /**
    * Returns a summary of information from the Spherocylinders in the array.  
    * 
    * @return String the summary
    */
   public String toString() {
      DecimalFormat format = new DecimalFormat("#,##0.0##");
      String output = "----- Summary for " + listName + " -----\n";
      output += "Number of Spherocylinders: " + arrayLen + "\n";
      output += "Total Surface Area: " 
            + format.format(totalSurfaceArea()) + "\n";
      output += "Total Volume: " + format.format(totalVolume()) + "\n";
      output += "Average Surface Area: " 
            + format.format(averageSurfaceArea()) + "\n";
      output += "Average Volume: " + format.format(averageVolume()) + "\n";
      return output;
   }
}