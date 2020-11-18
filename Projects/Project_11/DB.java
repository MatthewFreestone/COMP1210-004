import java.text.DecimalFormat;

/** 
 * A abstract class meant to represent several types of databases. 
 *
 * @author Matthew Freestone
 * @version 11/4/2020 
 */
public abstract class DB implements Comparable<DB> {
   protected String name;
   protected double baseCost, dbStorage; 

   protected static int count = 0;

	/**
	 * Constructor. 
	 * @param nameIn name of DB
	 * @param baseCostIn base cost of DB
	 * @param storageIn TB storage of DB
	 */
   public DB(String nameIn, double baseCostIn, double storageIn) {
      name = nameIn;
      baseCost = baseCostIn;
      dbStorage = storageIn;
      count++;
   }

	
	/**
	 * Returns the name of the DB. 
	 * 
	 * @return String DB name
	 */
   public String getName() {
      return name;
   }

	
	/**
	 * Sets the name of the DB.
	 * 
	 * @param nameIn new name
	 */
   public void setName(String nameIn) {
      this.name = nameIn;
   }

	
	/**
	 * Returns the base cost of the DB. 
	 * 
	 * @return double cost of DB
	 */
   public double getBaseCost() {
      return baseCost;
   }

	
	/**
	 * Sets the base cost of the DB. 
	 * 
	 * @param baseCostIn base cost of DB
	 */
   public void setBaseCost(double baseCostIn) {
      this.baseCost = baseCostIn;
   }

	
	/**
	 * Returns the TB storage of the DB.
	 * 
	 * @return double TB storage of the DB
	 */
   public double getDbStorage() {
      return dbStorage;
   }

	
	/** 
	 * Sets the TB storage of the DB.
	 * 
	 * @param dbStorageIn new TB storage of the DB
	 */
   public void setDbStorage(double dbStorageIn) {
      this.dbStorage = dbStorageIn;
   }

	
	/**
	 * Returns the number of DB created total.
	 * 
	 * @return int
	 */
   public static int getCount() {
      return count;
   }

	/**
	 * Resets the count of DB's made to 0. 
	 */
   public static void resetCount() {
      count = 0; 
   }

	
	/**
	 * Returns a string representation of the DB.
	 * 
	 * @return String represetnation of the DB
	 */
   public String toString() {
      DecimalFormat price = new DecimalFormat("$#,##0.00");
      DecimalFormat storage = new DecimalFormat("0.000");
   
      String output = name + " (" + this.getClass().toString() + ") ";
      output += "Monthly Cost: " + price.format(this.monthlyCost());
      output += "\nStorage: " + storage.format(dbStorage) + " TB\n";
      output += "Base Cost: " + price.format(baseCost);
      return output;
   }

	/**
	 * Returns the monthly cost of running the DB.
	 * @return monthly cost of DB. 
	 */
   public abstract double monthlyCost();
	

   /**
    * Returns 1,0,or -1 depending on where the name of o falls 
    * in alphabetical order compared to this.
    * @param o DB being compared to
    * @return int used to sort in array
    */
   @Override
   public int compareTo(DB o) {
      String thisName = this.getName().toLowerCase();
      String otherName = o.getName().toLowerCase();
      return thisName.compareTo(otherName);
   }

   /**
    * Returns true or false depending on if 
    * the DB is equal to inputed one. 
    * @param obj object being compared to 
    * @return true or false depending on equality
    */
   @Override
   public boolean equals(Object obj) {
      DB o = (DB) obj;
      if (compareTo(o) == 0) {
         return true;
      }
      return false;
   }

   /**
    * Always returns 1 for checkstyle. 
    */
   @Override
   public int hashCode() {
      return 0;
   }




}