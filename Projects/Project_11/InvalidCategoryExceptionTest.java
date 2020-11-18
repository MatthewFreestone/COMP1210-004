import org.junit.Assert;
import org.junit.Test;

/**
 * Class for testing the InvalidCategoryException created. 
 */
public class InvalidCategoryExceptionTest {

   /** 
    * A test for the constructor. 
    */
   @Test public void defaultTest() {
      InvalidCategoryException e = new InvalidCategoryException("Test");
      Assert.assertEquals("InvalidCategoryException: For category: Test",
             e.toString());
   }
}
