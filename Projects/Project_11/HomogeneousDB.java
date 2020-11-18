
/** 
 * A database distrubuted among many systems, 
 * with each having their own way to store it. 
 *
 * @author Matthew Freestone
 * @version 11/4/2020 
 */
public class HomogeneousDB extends DistributedDB {

   /**
    * Factor applied to userCost when calculating monthly cost. 
    */
   public static final double COST_FACTOR = 1.2;

   /**
    * Constructor. 
    * @param nameIn name of the HomogeneousDB
    * @param costIn base cost of the HomogeneousDB
    * @param storageIn TB storage of the HomogeneousDB
    * @param numberOfUsers number of users in the system
    * @param costPerUserIn cost per user in the system
    */
   public HomogeneousDB(String nameIn, double costIn, 
            double storageIn, int numberOfUsers, double costPerUserIn) {

      super(nameIn, costIn, storageIn, numberOfUsers, costPerUserIn);
   }

   /**
    * Returns the constant factor applied to 
    * userCost in monthly cost calculation. 
    * 
    * @return factor applied to userCost
    */
   public double getCostFactor() {
      return COST_FACTOR;
   }

   @Override
   public double monthlyCost() {
      return baseCost + userCost() * this.getCostFactor();
   }

}