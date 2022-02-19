import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*     Victoria Goss
*     September 10, 2021
*     SharedCloud JUnit Test.
*/



public class SharedCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /**
   *     Tests dataStored method. 
   */

   @Test public void dataStoredTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.00, 12.0, 20.0);
      c2.setDataStored(12.0);
      Assert.assertEquals(12.0, c2.getDataStored(), 0.000001);
   }
   
/**
*     Tests dataLimit method.
*/

   
   @Test public void dataLimitTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.00, 12.0, 20.0);
      c2.setDataLimit(20.0);
      Assert.assertEquals(20.0, c2.getDataLimit(), 0.000001);
   }
   
   /**
*     Testing cost factor method.
*/
   
   @Test public void costFactorTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.00, 12.0, 20.0);
      Assert.assertEquals(1.0, c2.getCostFactor(), 0.000001);
   }

/**
*     Tests data overage with more storage left to use.
*/


   @Test public void dataOverageTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.00, 12.0, 20.0);
      Assert.assertEquals(0.000, c2.dataOverage(), 0.000001);
   }
   
/**
*     Tests data overage with no more storage left to use.
*/

   
   @Test public void dataOveragePositiveTest() {
      SharedCloud c3 = new SharedCloud("Cloud Three", 9.00, 25.0, 20.0);
      Assert.assertEquals(5.000, c3.dataOverage(), 0.000001);
   }
   
 /**
*     Tests data overage with no more storage left to use.
*/
   
   @Test public void dataOverageEqualsTest() {
      SharedCloud c3 = new SharedCloud("Cloud Three", 9.00, 25.0, 25.0);
      Assert.assertEquals(0.000, c3.dataOverage(), 0.000001);
   }
   
     
/**
*     Tests baseStorageCost set and get methods.
*/


   @Test public void baseStorageCostTest() {
      SharedCloud c3 = 
         new SharedCloud("Cloud Three", 9.00, 25.0, 25.0);         
      c3.setBaseStorageCost(9.00);
      Assert.assertEquals(9.00, c3.getBaseStorageCost(), 0.000001);
   }
   
/**
*     Tests set and get name methods.
*/

   
   @Test public void nameTest() {
      SharedCloud c3 = new SharedCloud("Cloud Three", 9.00, 25.0, 20.0);
      c3.setName("Cloud Three");
      Assert.assertEquals("Cloud Three", c3.getName());
   }


   /**
   *  Tests resetCount function.
   */
   
   @Test public void resetCountTest() {
      SharedCloud c3 = new SharedCloud("Cloud Three", 9.00, 25.0, 20.0);
      SharedCloud.resetCount();
      int count = SharedCloud .getCount();
      Assert.assertEquals(0, count);
   }
   
   /**
   *     Tests monthlyCost method.
   */
   
   @Test public void monthlyCostEqualsTest() {
      SharedCloud c3 = new SharedCloud("Cloud Three", 9.00, 25.0, 20.0);
      Assert.assertEquals(14.00, c3.monthlyCost(), 0.000001);
   }

   /**
   *     Tests toString method.
   */


   @Test public void toStringTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.00, 12.0, 20.0);
      String output = ("Cloud Two (class SharedCloud) Monthly Cost:"
         + " $9.00\nBase Storage Cost: $9.00"
         + "\nData Stored: 12.000 GB"
         + "\nData Limit: 20.000 GB"
         + "\nOverage: 0.000 GB"
         + "\nCost Factor: 1.0");
      Assert.assertEquals(c2.toString(), output);
   }
   
}
