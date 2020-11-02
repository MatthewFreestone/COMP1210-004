/** 
 * Class for holding Electronics that are for sale. 
 *
 * @author Matthew Freestone
 * @version 11/1/2020 
 */
public class ElectronicsItem extends InventoryItem {
   protected double weight;

   /**
    * Cost per pound of weight to ship. 
    */
   public static final double SHIPPING_COST = 1.5;

   /**
    * Constrcutor for the class. 
    * @param nameIn name of the electronic. 
    * @param priceIn price of the electronic.
    * @param weightIn weight of the electronic. 
    */
   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
      super(nameIn, priceIn);
      weight = weightIn;
   }

   /**
    *  Calculates the cost of the item with shipping. 
    */
   @Override
   public double calculateCost() {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }


}