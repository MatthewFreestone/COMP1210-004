/** 
 * Driver testing class for ItemsList
 *
 * @author Matthew Freestone
 * @version 11/1/2020  
 */
public class InventoryListApp {

   /**
    * Shows a test case for the ItemsList Class
    * @param args params
    */
   public static void main(String[] args) {
      InventoryItem.setTaxRate(0.05);
      ItemsList myItems = new ItemsList();
      myItems.addItem(new ElectronicsItem("laptop", 1234.56, 10));
      myItems.addItem(new InventoryItem("motor oil", 9.8));
      myItems.addItem(new OnlineBook("All Things Java", 12.3));
      myItems.addItem(new OnlineArticle("Useful Acronyms", 3.4));

      System.out.println(myItems.toString());
      System.out.println("Total: " + myItems.calculateTotal(2.0));

   }
}