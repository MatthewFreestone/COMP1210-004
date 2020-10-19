import org.junit.Assert;
import org.junit.Test;
/**
 * Provides tests for the Customer class.
 *
 * @author Matthew Freestone
 * @version 10/19/2020
 */
public class CustomerTest {

   /**
    * Tests the setLocation method.
    */
   @Test
   public void setLocationTest1() {
      Customer c = new Customer("Lane, Jane");
      c.setLocation("Boston, MA");
      Assert.assertEquals("Boston, MA", c.getLocation());
   }

   /**
    * Tests the setLocation method's other form.
    */
   @Test
   public void setLocationTest2() {
      Customer c = new Customer("Lane, Jane");
      c.setLocation("Atlanta", "GA");
      Assert.assertEquals("Atlanta, GA", c.getLocation());
   }

   /**
    * Tests the toString method.
    */
   @Test
   public void toStringTest() {
      Customer c = new Customer("Lane, Jane");
      c.setLocation("Auburn, AL");
      c.changeBalance(999);
      Assert.assertEquals("Lane, Jane\nAuburn, AL\n$999.0", c.toString());
   }

   /**
    * Tests the compareTo method for equality (0).
    */
   @Test
   public void compareToTest1() {
      Customer c1 = new Customer("Lane, Jane");
      c1.changeBalance(500);

      Customer c2 = new Customer("Lane, Jane");
      c2.changeBalance(500);

      Assert.assertTrue(c1.compareTo(c2) == 0);
   }

   /**
    * Tests the compareTo method for less than (-1).
    */
   @Test
   public void compareToTest2() {
      Customer c1 = new Customer("Lane, Jane");
      c1.changeBalance(100);

      Customer c2 = new Customer("Lane, Jane");
      c2.changeBalance(500);

      Assert.assertTrue(c1.compareTo(c2) == -1);
   }

   /**
    * Tests the compareTo method for greater than (1).
    */
   @Test
   public void compareToTest3() {
      Customer c1 = new Customer("Lane, Jane");
      c1.changeBalance(1000);

      Customer c2 = new Customer("Lane, Jane");
      c2.changeBalance(500);

      Assert.assertTrue(c1.compareTo(c2) == 1);
   }
}