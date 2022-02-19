import java.text.DecimalFormat;

 /**
*     Victoria Goss
*     September 10, 2021
*     Creates child class for CloudStorage and instance variables.
*/


public class SharedCloud extends CloudStorage {
   protected double dataStored;
   protected double dataLimit;
   /** Creates constant for cost factor. */
   public static final double COST_FACTOR = 1.0;
   
   /**
   *  Creates constructor for class.
   *  @param nameIn passes name through.
   *  @param costIn passes cost through.
   *  @param dataStoredIn passes data stored through.
   *  @param dataLimitIn passes data limit through.
   */

   public SharedCloud(String nameIn, double costIn, 
      double dataStoredIn, double dataLimitIn) {
      super(nameIn, costIn);
      this.dataStored = dataStoredIn;
      this.dataLimit = dataLimitIn;
   }
   
   /**
   *  Gets data stored.
   *  @return double for data stored.
   */
   
   public double getDataStored() {
      return dataStored;
   }
   
   /**
   *  Sets data stored for object.
   *  @param dataStoredIn passes data stored through.
   */

   
   public void setDataStored(double dataStoredIn) {
      this.dataStored = dataStoredIn;
   }
   
   /**
   *  Gets the current data limit for object.
   *  @return double for datalimit.
   */

   
   public double getDataLimit() {
      return dataLimit;
   }
   
   /**
   *  Sets the data limit for object.
   *  @param dataLimitIn passes data limit through.
   */

   
   public void setDataLimit(double dataLimitIn) {
      this.dataLimit = dataLimitIn;
   }
   
   /**
   *  Gets the current cost factor of object.
   *  @return double for cost factor.
   */

   
   public double getCostFactor() {
      return (SharedCloud.COST_FACTOR);
   }
   
   /**
   *  Calculates data overage and returns value accordingly.
   *  @return double for data overage.
   */

   
   public double dataOverage() {
      if (dataStored >= dataLimit) {
         return (dataStored - dataLimit);
      }
      else {
         return 0;
      }
   }
   
   /**
   *  Calculates monthly cost by overriding function in parent class.
   *  @return double for monthly cost.
   */

   
   public double monthlyCost() {
      return (cost + dataOverage() * SharedCloud.COST_FACTOR);
   }
   
   /**
   *  Overrides toString method by adding extra fields.
   *  @return String format of output.
   */

   
   public String toString() {
      DecimalFormat dfmt2 = new DecimalFormat("0.000");
      return (super.toString() + "\nData Stored: " + dfmt2.format(dataStored) 
         + " GB" + "\nData Limit: " + dfmt2.format(dataLimit) 
         + " GB" + "\nOverage: " + dfmt2.format(dataOverage()) 
         + " GB" + "\nCost Factor: " + getCostFactor());
   }
}