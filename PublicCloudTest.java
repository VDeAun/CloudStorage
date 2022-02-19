import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*     Victoria Goss
*     September 10, 2021
*     Creating PublicCloud JUnit test.
*/



public class PublicCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

/**
*     Tests set and get name methods.
*/

   
   @Test public void nameTest() {
      PublicCloud c4 = new PublicCloud("Cloud Four", 9.00, 25.0, 20.0);
      c4.setName("Cloud Four");
      Assert.assertEquals("Cloud Four", c4.getName());
   }
   
/**
*     Tests baseStorageCost set and get methods.
*/

   
   @Test public void baseStorageCostTest() {
      PublicCloud c4 = new PublicCloud("Cloud Four", 9.00, 25.0, 20.0);
      c4.setBaseStorageCost(9.00);
      Assert.assertEquals(9.00, c4.getBaseStorageCost(), 0.000001);
   }
   
/**
*     Tests dataStored method.
*/

   
   @Test public void dataStoredTest() {
      PublicCloud c4 = new PublicCloud("Cloud Four", 9.00, 25.0, 20.0);
      c4.setDataStored(25.000);
      Assert.assertEquals(25.000, c4.getDataStored(), 0.000001);
   }
   
/**
*     Tests dataLimit method.
*/

   
   @Test public void dataLimitTest() {
      PublicCloud c4 = new PublicCloud("Cloud Four", 9.00, 25.0, 20.0);
      c4.setDataLimit(20.0);
      Assert.assertEquals(20.0, c4.getDataLimit(), 0.000001);
   }
    
   /**
   *  Tests resetCount function.
   */
   
   @Test public void resetCountTest() {
      PublicCloud c1 = new PublicCloud("Cloud Four", 9.00, 25.0, 20.0);
      PublicCloud.resetCount();
      int count = PublicCloud.getCount();
      Assert.assertEquals(0, count);
   }
      
/**
*     Testing monthlyCost method.
*/
  
      
   @Test public void monthlyCostEqualsTest() {
      PublicCloud c1 = new PublicCloud("Cloud Four", 9.00, 25.0, 20.0);
      Assert.assertEquals(19.00, c1.monthlyCost(), 0.000001);
   }
   
/**
*     Tests data overage with more storage left to use.
*/

   
   @Test public void dataOverageTest() {
      PublicCloud c2 = new PublicCloud("Cloud Two", 9.00, 12.0, 20.0);
      Assert.assertEquals(0.000, c2.dataOverage(), 0.000001);
   }
   
/**
*     Tests data overage with no more storage left to use.
*/

   
   @Test public void dataOveragePositiveTest() {
      PublicCloud c3 = new PublicCloud("Cloud Three", 9.00, 25.0, 20.0);
      Assert.assertEquals(5.000, c3.dataOverage(), 0.000001);
   }
   
/**
*     Tests data overage equals.
*/

   
   @Test public void dataOverageEqualsTest() {
      PublicCloud c3 = new PublicCloud("Cloud Three", 9.00, 25.0, 25.0);
      Assert.assertEquals(0.000, c3.dataOverage(), 0.000001);
   }
   
/**
*     Testing cost factor method.
*/

   
   @Test public void costFactorTest() {
      PublicCloud c4 = new PublicCloud("Cloud Four", 9.00, 25.0, 20.0);
      Assert.assertEquals(2.0, c4.getCostFactor(), 0.000001);
   }

/**
*     Testing toString method.
*/


   @Test public void toStringTest() {
      PublicCloud c4 = new PublicCloud("Cloud Four", 9.00, 25.0, 20.0);
      String output = ("Cloud Four (class PublicCloud) Monthly Cost: $19.00"
         + "\nBase Storage Cost: $9.00"
         + "\nData Stored: 25.000 GB"
         + "\nData Limit: 20.000 GB"
         + "\nOverage: 5.000 GB"
         + "\nCost Factor: 2.0");
      Assert.assertEquals(c4.toString(), output);
   }





}
