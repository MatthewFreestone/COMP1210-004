import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

/** 
 * Tests the InventoryItem class. 
 *
 * @author Matthew Freestone
 * @version 11/1/2020 
 */
public class InventoryItemTest {

   /**
    * Tests the setTaxRate method. 
    */
   @Test
   public void setTaxRateTest() {
      InventoryItem.setTaxRate(0.08);
      InventoryItem item1 = new InventoryItem("Birdseed", 7.99);
      Assert.assertEquals("Birdseed: $8.6292", item1.toString());
      InventoryItem item2 = new InventoryItem("Picture", 10.99);
      assertEquals("Picture: $11.869200000000001", item2.toString());
   
   }

}

