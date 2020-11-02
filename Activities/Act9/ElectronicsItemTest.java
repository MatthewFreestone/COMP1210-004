import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** 
 * Tests the ElectionsItem class. 
 *
 * @author Matthew Freestone
 * @version 11/1/2020
 */
public class ElectronicsItemTest {

   /**
    * Tests the calculateCost method. 
    */
   @Test
   public void calculateCostTest() {
      InventoryItem.setTaxRate(0.08);
      ElectronicsItem eItem = new ElectronicsItem("Monitor", 100, 10.0);
      assertEquals("Monitor: $123.0", eItem.toString());
   }

}

