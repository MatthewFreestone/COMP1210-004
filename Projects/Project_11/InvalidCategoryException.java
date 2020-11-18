/**
 * Exception thrown when readFile cannot recognize the category.
 */
public class InvalidCategoryException extends Exception {

  /**
   * Constructor.
   * @param categoryIn represents the category inputed that is unrecongnized
   */
   public InvalidCategoryException(String categoryIn) {
      super("For category: " + categoryIn);
   }
}
