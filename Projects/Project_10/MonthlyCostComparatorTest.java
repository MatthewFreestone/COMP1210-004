import org.junit.Test;
import org.junit.Assert;

/** 
 * Tests the MonthlyCostComparator. 
 * 
 * @author Matthew Freestone
 * @version 11/8/2020 
 */
public class MonthlyCostComparatorTest {

   /**
    * Tests the compare method. 
    */
   @Test
   public void compareTest() {
      CentralizedDB a = new CentralizedDB("Database A", 1200.0, 5.00, 30000.0);
      CentralizedDB b = new CentralizedDB("Database B", 1200.0, 5.00, 1500.0);
      MonthlyCostComparator comp = new MonthlyCostComparator();
      Assert.assertEquals(-1, comp.compare(a, b));
      Assert.assertEquals(0, comp.compare(a, a));
      Assert.assertEquals(1, comp.compare(b, a));
   }
}