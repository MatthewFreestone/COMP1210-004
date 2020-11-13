import org.junit.Test;

import java.io.FileNotFoundException;

import org.junit.Assert;

/** 
 * Test class for DBList.
 * 
 * @author Matthew Freestone
 * @version 11/8/2020 
 */
public class DBListTest {
   /**
    * Tests the get dbArray and invalidRecords methods.
    */
   @Test
   public void getsTests() {
      DBList list = new DBList();
      Assert.assertArrayEquals(new DB[0], list.getDBArray());
      Assert.assertArrayEquals(new String[0], list.getInvalidRecordsArray());
   }

   /**
    * Tests the addInvalidRecord method.
    */
   @Test
   public void addInvalidRecordTest() {
      DBList list = new DBList();
      String c = "This One!";
      String[] test = {c};
      list.addInvalidRecord(c);
      Assert.assertArrayEquals(test, list.getInvalidRecordsArray());
   
      String d = "Also this too!";
      String[] test2 = {c, d};
      list.addInvalidRecord(d);
      Assert.assertArrayEquals(test2, list.getInvalidRecordsArray());
   }

   /**
    * Tests the addDB method.
    */
   @Test
   public void addDBTest() {
      DBList list = new DBList();
      CentralizedDB c = 
            new CentralizedDB("Database One", 1200.0, 5.0, 1500);
      DistributedDB d = 
            new DistributedDB("Database Two", 2000.0, 7.5, 100, 12.0);
      DB[] test = {c};
      list.addDB(c);
      Assert.assertArrayEquals(test, list.getDBArray());
   
      DB[] test2 = {c, d};
      list.addDB(d);
      Assert.assertArrayEquals(test2, list.getDBArray());
   }

   /**
    * Tests the readFile method.
    * @throws FileNotFoundException if file cannot be read
    */
   @Test
   public void readFileTest() throws FileNotFoundException {
      CentralizedDB c = 
            new CentralizedDB("Database One", 1200.0, 5.0, 1500);
      DistributedDB d = 
            new DistributedDB("Database Two", 2000.0, 7.5, 100, 12.0);
      HomogeneousDB h = 
            new HomogeneousDB("Database Three", 2000, 7.5, 100, 14.0);
      HeterogeneousDB he =
            new HeterogeneousDB("Database Four", 2000, 7.5, 100, 14.0);
      DB[] test = {c, d, h, he};
      DBList list = new DBList();
      list.readFile("database_data_1.csv");
      Assert.assertEquals(test.length, list.getDBArray().length);
      Assert.assertArrayEquals(test, list.getDBArray());
   }

}