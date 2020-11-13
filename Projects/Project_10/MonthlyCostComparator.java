import java.util.Comparator;

/** 
 * A comparator to compare DBs using their monthly cost. 
 * 
 * @author Matthew Freestone
 * @version 11/8/2020 
 */
public class MonthlyCostComparator implements Comparator<DB> {

   /**
    * Sorts by monthly cost, most expensive first. 
    * @param o1 first object
    * @param o2 second object
    * @return -1,0,or 1 depending on relative value
    */
   @Override
   public int compare(DB o1, DB o2) {
      if (o1.monthlyCost() < o2.monthlyCost()) {
         return 1;
      }
      else if (o1.monthlyCost() == o2.monthlyCost()) {
         return 0;
      }
      else {
         return -1;
      }
   }
}