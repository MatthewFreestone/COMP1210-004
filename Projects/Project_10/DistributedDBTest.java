import org.junit.Assert;
import org.junit.Test;


/** 
 * A class for testing the DistributedDB class. 
 *
 * @author Matthew Freestone
 * @version 11/4/2020 
 */
public class DistributedDBTest {

   /**
    * Tests the get and set numberOfUsers methods.
    */
   @Test
   public void numberOfUsersTest() {
      DistributedDB d = 
            new DistributedDB("Database Two", 2000.0, 7.5, 100, 12.0);
      Assert.assertEquals(100, d.getNumberOfUsers());
      d.setNumberOfUsers(1);
      Assert.assertEquals(1, d.getNumberOfUsers());
   }

   /**
    * Tests the get and set costPerUser methods. 
    */
   @Test
   public void costPerUserTest() {
      DistributedDB d = 
            new DistributedDB("Database Two", 2000.0, 7.5, 100, 12.0);
      Assert.assertEquals(12.0, d.getCostPerUser(), 0.0001);
      d.setCostPerUser(12.3);
      Assert.assertEquals(12.3, d.getCostPerUser(), 0.0001);
      
   }

   /**
    * Tests the userCost method. 
    */
   @Test
   public void userCostTest() {
      DistributedDB d = 
            new DistributedDB("Database Two", 2000.0, 7.5, 100, 12.0);
      Assert.assertEquals(1200.0, d.userCost(), 0.0001);
   }

   /**
    * Tests the getCostFactor method. 
    */
   @Test
   public void costFactorTest() {
      DistributedDB d = 
            new DistributedDB("Database Two", 2000.0, 7.5, 100, 12.0);
      Assert.assertEquals(1.1, d.getCostFactor(), 0.0001);
   }

   /**
    * Tests the monthlyCost method. 
    */
   @Test
   public void monthlyCostTest() {
      DistributedDB d = 
            new DistributedDB("Database Two", 2000.0, 7.5, 100, 12.0);
      Assert.assertEquals(3320.0, d.monthlyCost(), 0.0001);
   }

   /**
    * Tests the toString method. 
    */
   @Test 
   public void toStringTest() {
      DistributedDB d = 
            new DistributedDB("Database Two", 2000.0, 7.5, 100, 12.0);
      String output = 
              "Database Two (class DistributedDB) Monthly Cost: $3,320.00\n" 
            + "Storage: 7.500 TB\n"
            + "Base Cost: $2,000.00\n"
            + "Number of Users: 100\n"
            + "Cost per User: $12.00\n"
            + "User Cost: $1,200.00\n"
            + "Cost Factor: 1.1";
      Assert.assertEquals(output, d.toString());
   }

}

