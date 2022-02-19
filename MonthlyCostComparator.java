import java.util.Comparator;

/**
 * Victoria Goss
 * September 19, 2021
 * Creates monthly cost comparator class. 
 */
 
public class MonthlyCostComparator implements Comparator <CloudStorage> {

/**
* Compares and sorts objects based off of monthly cost.
*  @param c1 is the first object of cloud storage objects.
*  @param c2 is the second object of cloud storage objects.
*  @return int value to compare objects.
*/

   public int compare(CloudStorage c1, CloudStorage c2) {
   
      if (c1.monthlyCost() > c2.monthlyCost()) {
         return -1;
      }
      
      else if (c1.monthlyCost() < c2.monthlyCost()) {
         return 1;
      }
      
      else {
         return 0;
      }
   }

}
