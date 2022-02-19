import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*     Victoria Goss
*     September 10, 2021
*     Creating Junit test for DedicatedCloud.
*/


public class DedicatedCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
    
   @Before public void setUp() {
   }

/**
*     Tests serverCost method. 
*/
      
   @Test public void serverCostTest() {
      DedicatedCloud c1 = new DedicatedCloud("Cloud One", 40.00, 10.00);
      c1.setServerCost(10.00);
      Assert.assertEquals(10.00, c1.getServerCost(), 0.000001);
   }
   
     
/**
*     Tests baseStorageCost set and get methods.
*/

   
   @Test public void baseStorageCostTest() {
      DedicatedCloud c1 = new DedicatedCloud("Cloud One", 40.00, 10.00);
      c1.setBaseStorageCost(40.00);
      Assert.assertEquals(40.00, c1.getBaseStorageCost(), 0.000001);
   }

/**
*     Tests set and get name methods.
*/

   
   @Test public void nameTest() {
      DedicatedCloud c1 = new DedicatedCloud("Cloud One", 40.00, 10.00);
      c1.setName("Cloud One");
      Assert.assertEquals("Cloud One", c1.getName());
   }

   /**
   *  Tests monthlyCostEquals method.
   */
         
   @Test public void monthlyCostEqualsTest() {
      DedicatedCloud c1 = new DedicatedCloud("Cloud One", 40.00, 10.00);
      Assert.assertEquals(50.00, c1.monthlyCost(), 0.000001);
   }
   
   /**
   *  Tests resetCount function.
   */
   
   @Test public void resetCountTest() {
      DedicatedCloud c1 = new DedicatedCloud("Cloud One", 40.00, 10.00);
      DedicatedCloud.resetCount();
      int count = DedicatedCloud .getCount();
      Assert.assertEquals(0, count);
   }
   
   /**
   *  Tests toString method.
   */

   @Test public void toStringTest() {
      DedicatedCloud c2 = new DedicatedCloud("Cloud One", 40.00, 10.0);
      String output = ("Cloud One (class DedicatedCloud) Monthly Cost: $50.00"
         + "\nBase Storage Cost: $40.00"
         + "\nServer Cost: $10.00");
      Assert.assertEquals(c2.toString(), output);
   }

}
