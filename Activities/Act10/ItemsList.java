/** 
 * Class for holding an array of Items
 *
 * @author Matthew Freestone
 * @version 11/1/2020  
 */
public class ItemsList {

   private InventoryItem[] inventory;
   private int count;

   /**
    * Constructor.
    */
   public ItemsList() {
      inventory = new InventoryItem[20];
      count = 0;
   }

   /**
    * Adds an item to the list.
    * @param i item to add
    */
   public void addItem(InventoryItem i) {
      inventory[count] = i;
      count++;
   }

   /**
    * Returns the total cost of the whole inventory. 
    * @param electronicsSurcharge extra cost for electroncs 
    * @return total cost
    */
   public double calculateTotal(double electronicsSurcharge) { 
      double output = 0;
      for (int i = 0; i < count; i++) {
         if (inventory[i] instanceof ElectronicsItem) {
            output += inventory[i].calculateCost() + electronicsSurcharge;
         }
         else {
            output += inventory[i].calculateCost();
         }
      }
      return output;
   }

   /**
    * Returns string representation of the inventory.
    * @return string representation
    */
   public String toString() {
      String output = "All inventory:\n\n";

      for (int i = 0; i < count; i++) {
         output += inventory[i].toString() + "\n";
      }
      return output;
   }
}