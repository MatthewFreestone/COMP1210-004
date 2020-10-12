import java.text.DecimalFormat;

/** 
 * A class representing cylinder with half-spheres on each end. 
 *
 * @author Matthew Freestone
 * @version 10/12/2020 
 */
public class Spherocylinder {

   private String label = "";
   private double radius = 0, cylinderHeight = 0;
   private static int count = 0;

   
   
   /** 
    * Constructor.

    * @param labelIn label of the Spherocylinder
    * @param radiusIn radius of the Spherocylinder
    * @param heightIn height of the Spherocylinder
    */
   public Spherocylinder(String labelIn, double radiusIn, double heightIn) {
      setLabel(labelIn);
      setRadius(radiusIn);
      setCylinderHeight(heightIn);
      count++;
   }

   
   /**
    * Sets the label of the Spherocylinder (cannot be null).
    * 
    * @param labelIn the new label, will be trimmed
    * @return boolean if the label was set
    */
   public boolean setLabel(String labelIn) { 
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      }
      return false; 
   }

   
   /**
    * Returns the label of the Spherocylinder.
    * 
    * @return String the label
    */
   public String getLabel() {
      return label;
   }

   
   /**
    * Sets the radius of the Spherocylinder, cannot be negative.
    * 
    * @param radiusIn new radius
    * @return boolean if the radius was set
    */
   public boolean setRadius(double radiusIn) {
      if (radiusIn >= 0) {
         radius = radiusIn;
         return true;
      }
      return false; 
   }

   
   /**
    * Returns the radius of the Spherocylinder. 
    * 
    * @return double the radius 
    */
   public double getRadius() {
      return radius;
   }

   
   /**
    * Sets the height of the cylindrical part of the Spherocylinder. 
    * 
    * @param heightIn the height, cannot be negative
    * @return boolean if the height was set
    */
   public boolean setCylinderHeight(double heightIn) {
      if (heightIn >= 0) {
         cylinderHeight = heightIn;
         return true;
      }
      return false;
   }

   
   /**
    * Returns the height of the cylindrical part of the Spherocylinder. 
    * 
    * @return double the height
    */
   public double getCylinderHeight() {
      return cylinderHeight;
   }

   
   /**
    *  Returns the circumference of the Spherocylinder.
    * 
    * @return double the circumference
    */
   public double circumference() {
      return 2 * radius * Math.PI;
   }

   
   /**
    * Returns the Surface Area of the Spherocylinder. 
    * 
    * @return double the surface area. 
    */
   public double surfaceArea() {
      return (2 * radius * Math.PI) * (2 * radius + cylinderHeight);
   }

   
   /**
    * Return the volume of the Spherocylinder.  
    * 
    * @return double the volume
    */
   public double volume() {
      double firstTerm = Math.PI * Math.pow(radius, 2);
      double secondTerm = (4.0 / 3.0) * radius  + cylinderHeight;
      return firstTerm * secondTerm;
   }

   
   /** 
    * Formats instance information to be printed in a readable format.
    * 
    * @return String represenation of an instance of Spherocylinder
    */
   public String toString() {
      DecimalFormat format = new DecimalFormat("#,##0.0##");
      String output = "Spherocylinder \"" + getLabel() 
            + "\" with radius " + getRadius() 
            + " and cylinder height " + getCylinderHeight() + " has:\n";
      output += "\tcircumference = " + format.format(circumference()) 
            + " units\n";
      output += "\tsurface area = " + format.format(surfaceArea()) 
            + " square units\n";
      output += "\tvolume = " + format.format(volume()) + " cubic units";
      return output;
   }

   
   /** 
    * Returns the number of objects created of type Spherocylinder.
    * 
    * @return int
    */
   public static int getCount() {
      return count;
   }

   /**
    * Resets the number of objects created back to 0. 
    */
   public static void resetCount() {
      count = 0;
   }

   
   /** 
    * Checks if the inputed object is identical to the 
    * current instance of Spherocylinder.
    * 
    * @param objIn The object to check 
    * @return boolean true if the objects are identical 
    */
   public boolean equals(Object objIn) {
      if (!(objIn instanceof Spherocylinder)) {
         return false;
      }
      Spherocylinder d = (Spherocylinder) objIn;
      return (label.equalsIgnoreCase(d.getLabel())
            && Math.abs(radius - d.getRadius()) < .000001
            && Math.abs(cylinderHeight - d.getCylinderHeight())
            < .000001);

   }

   
   /**
    * Function required for checkstyle. 
    * 
    * @return int always 0.
    */
   public int hashCode() {
      return 0; 
   }
   
}