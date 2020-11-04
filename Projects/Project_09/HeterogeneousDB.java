
/** 
 * A database distrubuted among many systems, 
 * with each having the same way to store it. 
 *
 * @author Matthew Freestone
 * @version 11/4/2020
 */
public class HeterogeneousDB extends DistributedDB {

   /**
    * Factor applied to userCost when calculating monthly cost. 
    */
   public static final double COST_FACTOR = 1.3;

   /**
    * Constructor. 
    * @param nameIn name of the HeterogeneousDB
    * @param costIn base cost of the HeterogeneousDB
    * @param storageIn TB storage of the HeterogeneousDB
    * @param numberOfUsers number of users in the system
    * @param costPerUserIn cost per user in the system
    */
   public HeterogeneousDB(String nameIn, double costIn, 
            double storageIn, int numberOfUsers, double costPerUserIn) { 

      super(nameIn, costIn, storageIn, numberOfUsers, costPerUserIn);
   }

   /**
    * Returns the constant factor applied to userCost 
    * in monthly cost calculation. 
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