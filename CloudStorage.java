import java.text.DecimalFormat;

/**
*     Victoria Goss
*     September 10, 2021
*     Creating abstract parent class of Cloud Storage.
*/

public abstract class CloudStorage implements Comparable<CloudStorage> {
   protected String name;
   protected double cost;
   protected static int count = 0;
   
  
/**
*  Creating constructor for class that increments count.
*  @param nameIn passes name through.
*  @param costIn passes cost through
*/

   
   public CloudStorage(String nameIn, double costIn) {
      this.name = nameIn;
      this.cost = costIn;
      count++;
   }
   
   
/**
*  Returns the name for the cloud storage object.
*  @return String for name of object. 
*/

   
   public String getName() {
      return name;
   }
   
/**
*  Sets name for object.
*  @param nameIn sets name.
*/

   
   public void setName(String nameIn) {
      this.name = nameIn;
   }
   
/**
*  Gets the cost of object.
*  @return double for cost.
*/

   
   public double getBaseStorageCost() {
      return cost;
   }
   
/**
*  Sets the cost of the object.
*  @param costIn passes cost through. 
*/

   
   public void setBaseStorageCost(double costIn) {
      this.cost = costIn;
   } 
   
/**
*  Gets count for object.
*  @return int for count.
*/

   
   public static int getCount() {
      return count;
   }
   
/**
*  Resets count to zero.    
*/

   
   public static void resetCount() {
      count = 0;
   }
   
/**
*  Formats the toString output for object.
*  @return String format of object.
*/

   
   public String toString() {
      DecimalFormat dfmt = new DecimalFormat("$#,##0.00");
      return (name + " (" + this.getClass() + ") " + "Monthly Cost: "
         + dfmt.format(monthlyCost())
         + "\nBase Storage Cost: " + dfmt.format(cost));
   }    
   
/**
*  Abstract method that is further defined in child classes.
*  @return double for monthly cost.
*/
  
   
   public abstract double monthlyCost();

/**
*  Compare to method will compare two objects in array.
*  @return int for order of array.
*  @param other represent second object.
*/

   public int compareTo(CloudStorage other) {
      return name.toLowerCase()  
                 .compareTo(other.getName().toLowerCase());      
   
   }
}



