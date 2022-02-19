/**
*     Victoria Goss
*     September 10,2021
*     Creates child class for Shared Cloud.
*/

public class PersonalCloud extends SharedCloud {
/** Creates constant for cost factor. */
   public static final double COST_FACTOR = 3.0;   
   
   /**
   *  Creates constructor for object.
   *  @param nameIn passes name through.
   *  @param costIn passes cost through.
   *  @param dataStoredIn passes data stored.
   *  @param dataLimitIn passes data limit through.
   */
   
   public PersonalCloud(String nameIn, double costIn,
      double dataStoredIn, double dataLimitIn) {
      super(nameIn, costIn, dataStoredIn, dataLimitIn);
   }
   
   /**
   *  Gets cost factor for object.
   *  @return double for cost factor.
   */
   
   public double getCostFactor() {
      return PersonalCloud.COST_FACTOR;
   }
   
   /**
   *  Returns month;y cost for object.
   *  @return double for monthly cost. 
   */
   
   public double monthlyCost() {
      return (cost + dataOverage() * PersonalCloud.COST_FACTOR);
   }

}