import org.junit.Assert;
import org.junit.Test;


/** 
 * A class for testing CentralizedDB.
 *
 * @author Matthew Freestone
 * @version 11/4/2020 
 */
public class CentralizedDBTest {

   /**
    * Tests the get and set name methods.
    */
   @Test
   public void dbNameTest() {
      CentralizedDB d = new CentralizedDB("Database One", 1200.0, 5.00, 1500.0);
      Assert.assertEquals("Database One", d.getName());
      d.setName("New Name");
      Assert.assertEquals("New Name", d.getName());
   }

   /**
    * Tests the get and set cost methods.
    */
   @Test
   public void dbCostTest() {
      CentralizedDB d = new CentralizedDB("Database One", 1200.0, 5.00, 1500.0);
      Assert.assertEquals(1200.0, d.getBaseCost(), 0.000001);
      d.setBaseCost(15.001);
      Assert.assertEquals(15.001, d.getBaseCost(), 0.000001);
   }

   /**
    * Tests the get and set storage methods. 
    */
   @Test
   public void dbStorageTest() {
      CentralizedDB d = new CentralizedDB("Database One", 1200.0, 5.00, 1500.0);
      Assert.assertEquals(5.0, d.getDbStorage(), 0.000001);
      d.setDbStorage(15.001);
      Assert.assertEquals(15.001, d.getDbStorage(), 0.000001);
   }

   /**
    * Tests the get and set license methods.
    */
   @Test
   public void licenseTest() {
      CentralizedDB d = new CentralizedDB("Database One", 1200.0, 5.00, 1500.0);
      Assert.assertEquals(1500.0, d.getLicense(), 0.000001);
      d.setLicense(15.001);
      Assert.assertEquals(15.001, d.getLicense(), 0.000001);
   }

   /**
    * Tests the get and reset count methods. 
    */
   @Test
   public void countTest() {
      int start = DB.getCount();
      new CentralizedDB("", 0, 0, 0);
      Assert.assertEquals(++start, DB.getCount());
      DB.resetCount();
      Assert.assertEquals(0, DB.getCount());
   } 

   /**
    * Tests the monthlyCost method. 
    */
   @Test
   public void monthyCostTest() {
      CentralizedDB d = new CentralizedDB("Database One", 1200.0, 5.00, 1500.0);
      Assert.assertEquals(2700, d.monthlyCost(), 0.000001);
   }


   /**
    * Tests the toString method.
    */
   @Test 
   public void toStringTest() {
      CentralizedDB d = new CentralizedDB("Database One", 1200.0, 5.00, 1500.0);
      String output = "Database One (class CentralizedDB) "
            + "Monthly Cost: $2,700.00\n" 
            + "Storage: 5.000 TB\n"
            + "Base Cost: $1,200.00\n"
            + "License: $1,500.00";
      Assert.assertEquals(output, d.toString());
   }

}

