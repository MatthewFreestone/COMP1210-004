/** 
 * Class for holding items for sale. 
 *
 * @author Matthew Freestone
 * @version 11/1/2020  
 */
public class InventoryItem {
   protected String name;
   protected double price;
   private static double taxRate = 0;

   /**
    * Constructor. 
    * @param nameIn name of the item
    * @param priceIn price of the item 
    */
   public InventoryItem(String nameIn, double priceIn) { 
      name = nameIn;
      price = priceIn;
   }

   /**
    * Returns the name of the item.
    *
    * @return name of the item. 
    */
   public String getName() {
      return name;
   }

   /**
    * Returns the cost of the item with tax. 
    * @return cost of item with tax
    */
   public double calculateCost() {
      return price * (1 + taxRate);
   }

   /**
    * Sets the tax rates for all items. 
    * @param taxRateIn new tax rate as a decimal 
    */
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn;
   }

   /**
    * Returns the name of the item and the cost as a String. 
    * @return string representation of the item. 
    */
   public String toString() {
      return name + ": $" + calculateCost();
   }

   
}