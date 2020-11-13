import java.text.DecimalFormat;

/** 
 * Database at a single location. 
 *
 * @author Matthew Freestone
 * @version 11/4/2020  
 */
public class CentralizedDB extends DB {

   private double license; 

   /**
    * Constructor.
    * 
    * @param nameIn name of the CentralizedDB
    * @param costIn base cost of the CentralizedDB
    * @param storageIn storage in TB of the CentralizedDB
    * @param licenseIn license cost of the CentralizedDB
    */
   public CentralizedDB(String nameIn, double costIn, 
         double storageIn, double licenseIn) {

      super(nameIn, costIn, storageIn);
      this.license = licenseIn;
   }

   /**
    * Returns the License cost.
    * @return License cost
    */
   public double getLicense() {
      return license;
   }

   /**
    * Sets the License cost of the CentralizedDB.
    * @param licenseIn new license cost 
    */
   public void setLicense(double licenseIn) {
      this.license = licenseIn;
   }

   @Override
   public double monthlyCost() {
      return baseCost + license;
   }

   @Override
   public String toString() {
      DecimalFormat f = new DecimalFormat("$#,##0.00");
      String output = super.toString();
      return (output + "\n" + "License: " + f.format(license));
   }

}