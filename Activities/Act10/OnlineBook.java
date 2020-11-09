/** 
 * Class for holding books to be sold online. 
 *
 * @author Matthew Freestone
 * @version 11/1/2020 
 */
public class OnlineBook extends OnlineTextItem {

   protected String author; 

   /**
    * Constructor. 
    * @param nameIn name of the book
    * @param priceIn price of the book 
    */
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      author = "Author Not Listed"; 
   }

   /**
    * Sets the author of the book. 
    * @param authorIn author 
    */
   public void setAuthor(String authorIn) {
      author = authorIn;
   }

   /**
    * Returns the name, author, and price of the book. 
    * @return string representation of the object. 
    */
   @Override
   public String toString() {
      return name + " - " + author + ": $" + calculateCost();
   }
}