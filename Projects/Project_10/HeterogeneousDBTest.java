import org.junit.Assert;
import org.junit.Test;
/** 
 * A class for testing the HeterogeneousDB class. 
 *
 * @author Matthew Freestone
 * @version 11/4/2020 
 */
public class HeterogeneousDBTest {

   /**
    * Tests the monthlyCost method. 
    */
   @Test
   public void monthlyCostTest() {
      HeterogeneousDB d = 
            new HeterogeneousDB("Database Four", 2000, 7.5, 100, 14.0);
      Assert.assertEquals(3820.0, d.monthlyCost(), 0.0001);
   }

   /**
    * Tests the getCostFactor method.
    */
   @Test
   public void costFactorTest() {
      HeterogeneousDB d = 
            new HeterogeneousDB("Database Four", 2000, 7.5, 100, 14.0);
      Assert.assertEquals(1.3, d.getCostFactor(), 0.0001);
   }

   /**
    * Tests the toString method. 
    */
   @Test 
   public void toStringTest() {
      HeterogeneousDB d = 
            new HeterogeneousDB("Database Four", 2000, 7.5, 100, 14.0);
      String output = 
              "Database Four (class HeterogeneousDB) Monthly Cost: $3,820.00\n" 
            + "Storage: 7.500 TB\n"
            + "Base Cost: $2,000.00\n"
            + "Number of Users: 100\n"
            + "Cost per User: $14.00\n"
            + "User Cost: $1,400.00\n"
            + "Cost Factor: 1.3";
      Assert.assertEquals(output, d.toString());
   }

}

