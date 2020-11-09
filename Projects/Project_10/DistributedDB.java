import java.text.DecimalFormat;

/** 
 * A database distrubuted among many systems.
 *
 * @author Matthew Freestone
 * @version 11/4/2020 
 */
public class DistributedDB extends DB {

   protected int numberOfUsers;
   protected double costPerUser;

   /**
    * Factor applied to userCost when calculating monthly cost. 
    */
   public static final double COST_FACTOR = 1.1;

   /**
    * Constructor.
    * @param nameIn name of DistributedDB
    * @param costIn base cost of DistributedDB
    * @param storageIn TB storage of DistributedDB
    * @param numberOfUsersIn number of users in the system
    * @param costPerUserIn cost per user in the system
    */
   public DistributedDB(String nameIn, double costIn, 
         double storageIn, int numberOfUsersIn, double costPerUserIn) {
   
      super(nameIn, costIn, storageIn);
      this.numberOfUsers = numberOfUsersIn;
      this.costPerUser = costPerUserIn;
   }

   /**
    * Returns the number of users in the DistributedDB.
    * @return number of users
    */
   public int getNumberOfUsers() {
      return numberOfUsers;
   }

   /**
    * Sets the number of users in the DistributedDB. 
    * @param numberOfUsersIn new number of users
    */
   public void setNumberOfUsers(int numberOfUsersIn) {
      this.numberOfUsers = numberOfUsersIn;
   }
   
   /**
    * Returns the cost per user in the DistributedDB. 
    * @return cost per user
    */
   public double getCostPerUser() {
      return costPerUser;
   }

   /**
    * Sets the cost per user in the DistributedDB.
    * @param costPerUserIn new cost per user
    */
   public void setCostPerUser(double costPerUserIn) {
      this.costPerUser = costPerUserIn;
   }

   /**
    * Returns the product of the number of users and cost per user. 
    * @return total cost for users
    */
   public double userCost() {
      return numberOfUsers * costPerUser;
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
      return baseCost + userCost() * COST_FACTOR;
   }

   @Override
   public String toString() {
      DecimalFormat f = new DecimalFormat("$#,##0.00");
      String output = super.toString() + "\n";
      output += "Number of Users: " + numberOfUsers + "\n";
      output += "Cost per User: " + f.format(costPerUser) + "\n";
      output += "User Cost: " + f.format(userCost()) + "\n";
      output += "Cost Factor: " + this.getCostFactor();
      return output;
   }


}