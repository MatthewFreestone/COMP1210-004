import java.text.DecimalFormat;

/** 
 * A class representing an octahedron.
 *
 * @author Matthew Freestone
 * @version 9/29/2020
 */
public class Octahedron {

   /**
    * The label of the Octahedron.
    */
   private String label = "";
   
   /**
    * The color of the Octahedron.
    */
   private String color = "";

   /**
    * The edge length of the Octahedron.
    */
   private double edge;

   
   
   /** 
    * Contructor for octahedron class. 
    *
    * @param labelIn The label of the octahedron
    * @param colorIn The color the octahedron
    * @param edgeIn The length of the edges 
    */
   public Octahedron(String labelIn, String colorIn, double edgeIn) {
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
   }
   
   /**
    * Returns the label of the octahedron.
    * 
    * @return String the label
    */
   public String getLabel() {
      return label;
   }
   
   /**
    * Sets the label of the octahedron. 
    * 
    * @param labelIn the label
    * @return boolean returns true if the label text was set 
    */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      }
      else {
         return false; 
      }
   }

   
   /**
    * Returns the color of the octahedron.
    *  
    * @return String the color
    */
   public String getColor() {
      return color;
   }
   
   /**
    * Sets the color of the octahedron. 
    * 
    * @param colorIn the color
    * @return boolean returns true if the color text was set 
    */
   public boolean setColor(String colorIn) {
      if (colorIn != null) {
         color = colorIn.trim();
         return true;
      }
      else {
         return false; 
      }
   }
   
   
   /**
    * Returns the edge length of the octahedron.
    * 
    * @return double edge length
    */
   public double getEdge() {
      return edge;
   }
   

   
   /**
    * Sets the edge length of the octahedron.  
    * 
    * @param edgeIn edge length, must be positive
    * @return boolean returns true if the edge value was set
    */
   public boolean setEdge(double edgeIn) {
      if (edgeIn >= 0) {
         edge = edgeIn;
         return true;
      }
      else {
         return false; 
      }
   }

   
   /**
    * Returns the surface area of the octahedron.
    * 
    * @return double surface area 
    */
   public double surfaceArea() {
      double surfaceArea = 2 * Math.sqrt(3) * Math.pow(edge, 2);
      return surfaceArea;
   }

   
   /**
    *  Returns the volume of the octahedron.
    * 
    * @return double the volume
    */
   public double volume() {
      double volume = (Math.sqrt(2) / 3) * Math.pow(edge, 3);
      return volume;
   }

   
   /**
    * Returns the ratio of the octahedron's surface area to its volume. 
    * 
    * @return double
    */
   public double surfaceToVolumeRatio() {
      return surfaceArea() / volume();
   }

   
   /** 
    * Formats instance variables to be printed nicely. 
    * 
    * @return String
    */
   public String toString() {
      DecimalFormat forDoubles = new DecimalFormat("#,##0.0###");
      String output = "Octahedron \"" + label + "\" is \"" + color 
            + "\" with 12 edges of length " + edge + " units.\n\t";
      output += "surface area = " 
            + forDoubles.format(surfaceArea()) + " square units\n\t";
      output += "volume = " + forDoubles.format(volume()) + " cubic units\n\t";
      output += "surface/volume ratio = " 
            + forDoubles.format(surfaceToVolumeRatio());
      return output;
   }
}