import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*     Victoria Goss
*     September 10, 2021
*     PersonalCloud JUnit test.
*/



public class PersonalCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
/**
*     Tests set and get name methods.
*/


   @Test public void nameTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.00, 21.0, 20.0);
      c5.setName("Cloud Five");
      Assert.assertEquals("Cloud Five", c5.getName());
   }
   
     
/**
*     Tests baseStorageCost set and get methods.
*/

   
   @Test public void baseStorageCostTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.00, 21.0, 20.0);
      c5.setBaseStorageCost(9.00);
      Assert.assertEquals(9.00, c5.getBaseStorageCost(), 0.000001);
   }
   
   /**
   *     Tests dataStored method.
   */
   
   @Test public void dataStoredTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.00, 21.0, 20.0);
      c5.setDataStored(21.000);
      Assert.assertEquals(21.000, c5.getDataStored(), 0.000001);
   }
   
      
/**
*     Tests dataLimit method.
*/

   
   @Test public void dataLimitTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.00, 21.0, 20.0);
      c5.setDataLimit(20.0);
      Assert.assertEquals(20.0, c5.getDataLimit(), 0.000001);
   }
    
   /**
   *  Tests resetCount function.
   */
   
   @Test public void resetCountTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.00, 21.0, 20.0);
      PersonalCloud.resetCount();
      int count = PersonalCloud.getCount();
      Assert.assertEquals(0, count);
   }
   
/**
*     Testing monthlyCost method.
*/

      
   @Test public void monthlyCostEqualsTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.00, 21.0, 20.0);
      Assert.assertEquals(12.00, c5.monthlyCost(), 0.000001);
   }
   
/**
*     Tests data overage with more storage left to use.
*/

   
   @Test public void dataOverageTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.00, 12.0, 20.0);
      Assert.assertEquals(0.000, c5.dataOverage(), 0.000001);
   }
   
/**
*     Tests data overage with no more storage left to use.
*/

   
   @Test public void dataOveragePositiveTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.00, 25.0, 20.0);
      Assert.assertEquals(5.000, c5.dataOverage(), 0.000001);
   }
   
/**
*     Tests data overage equals.
*/


   
   @Test public void dataOverageEqualsTest() {
      PersonalCloud c3 = new PersonalCloud("Cloud Three", 9.00, 25.0, 25.0);
      Assert.assertEquals(0.000, c3.dataOverage(), 0.000001);
   }
   
/**
*     Testing cost factor method.
*/

   
   @Test public void costFactorTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.00, 21.0, 20.0);
      Assert.assertEquals(3.0, c5.getCostFactor(), 0.000001);
   }
   
/**
*     Testing toString method.
*/


   @Test public void toStringTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.00, 21.0, 20.0);
      String output = ("Cloud Five (class PersonalCloud) Monthly Cost: $12.00"
         + "\nBase Storage Cost: $9.00"
         + "\nData Stored: 21.000 GB"
         + "\nData Limit: 20.000 GB"
         + "\nOverage: 1.000 GB"
         + "\nCost Factor: 3.0");
      Assert.assertEquals(c5.toString(), output);
   }


  
  
}
