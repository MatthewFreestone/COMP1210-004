/** 
 * Driver for testing all of the new classes. 
 *
 * @author Matthew Freestone
 * @version 11/1/2020
 */
public class InventoryApp {

   /**
    * Main method that makes several items. 
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) {
      InventoryItem.setTaxRate(0.05);
      InventoryItem item1 = new InventoryItem("Oil Change kit", 39.00);
      ElectronicsItem item2 = new ElectronicsItem("Cordless phone", 80.00, 1.8);
      OnlineArticle item3 = new OnlineArticle("Java News", 8.50);
      item3.setWordCount(700);
      OnlineBook item4 = new OnlineBook("Java for Noobs", 13.37);
      item4.setAuthor("L. G. Jones");
   }
}