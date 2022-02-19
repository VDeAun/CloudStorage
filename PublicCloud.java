/**
*     Victoria Goss
*     September 10, 2021
*     Creates child class for Shared Cloud.
  */

public class PublicCloud extends SharedCloud {
/** Creates constant for cost factor. */
   public static final double COST_FACTOR = 2.0;
   
   /**
   *  Creates constructor for class.
   *  @param nameIn passes name through.
   *  @param costIn passes cost through.
   *  @param dataStoredIn passes data stored through.
   *  @param dataLimitIn passes data limit through.
   */
   
   public PublicCloud(String nameIn, double costIn,
      double dataStoredIn, double dataLimitIn) {
      super(nameIn, costIn, dataStoredIn, dataLimitIn);  
   }
   
   /**
   *  Get current cost factor for object.
   *  @return double representing cost factor.
   */
   
   public double getCostFactor() {
      return PublicCloud.COST_FACTOR;
   }
   
   /**
   *  Gives monthly cost for object.
   *  @return double representing monthly cost.
   */

   
   public double monthlyCost() {
      return (cost + dataOverage() * PublicCloud.COST_FACTOR);
   }

}