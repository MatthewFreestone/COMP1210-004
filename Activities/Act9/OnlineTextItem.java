/** 
 * Class for holding texts sold online. 
 *
 * @author Matthew Freestone
 * @version 11/1/2020 
 */
public abstract class OnlineTextItem extends InventoryItem {

   /**
    * Constructor.
    * @param nameIn name of the text
    * @param priceIn price of the text
    */
   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   
   /**
    * Returns the price of the text, without tax. 
    * @return double price of the text. 
    */
   @Override
   public double calculateCost() {
      return price; 
   }
}