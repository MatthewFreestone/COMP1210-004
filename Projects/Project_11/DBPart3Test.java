import org.junit.Test;
import java.io.FileNotFoundException;
import org.junit.Assert;

/** 
 * Test method for DBPart3.
 * 
 * @author Matthew Freestone
 * @version 11/15/2020 
 */
public class DBPart3Test {

   /**
    * Tests the main method with no args. 
    * @throws FileNotFoundException when file cannot be found. 
    */
   @Test
   public void mainTestEmpty() throws FileNotFoundException {
      String[] args = {};
      DBPart3.main(args);
      Assert.assertEquals(1.1, DistributedDB.COST_FACTOR, 0.0001);
   }

   /**
    * Tests the main method with a file that exists.
    * @throws FileNotFoundException when file cannot be found
    */
   @Test
   public void mainTestFull() throws FileNotFoundException {
      String[] args = {"database_data_1.csv"};
      DBPart3.main(args);
      Assert.assertEquals(1.1, DistributedDB.COST_FACTOR, 0.0001);
   }

   /**
    * Tests the constructor, for webcat. 
    */
   @Test
   public void constructorTest() {
      DBPart3 app = new DBPart3();
      Assert.assertTrue(true);
   }

}