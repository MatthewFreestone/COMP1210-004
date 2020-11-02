import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** 
 * Tests the OnlineBook class. 
 *
 * @author Matthew Freestone
 * @version 11/1/2020 
 */
public class OnlineBookTest {

   /**
    * Tests the setAuthor method. 
    */
   @Test
   public void setAuthorTest() {
      OnlineBook book = new OnlineBook("A Novel Novel", 9.99);
      assertEquals("A Novel Novel - Author Not Listed: $9.99", book.toString());
      book.setAuthor("Jane Lane");
      assertEquals("A Novel Novel - Jane Lane: $9.99", book.toString());
   }

}

