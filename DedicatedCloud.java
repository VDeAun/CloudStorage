import java.text.DecimalFormat;

 /**
*     Victoria Goss
*     September 10, 2021
*     Creating child class DedicatedCloud.
*/


public class DedicatedCloud extends CloudStorage {
   private double serverCost;
   
 /**
 * Creating constructor for class.
 * @param nameIn passes name through.
 * @param costIn passes cost through.
 * @param serverCostIn passes server cost through. 
 */
   
   public DedicatedCloud(String nameIn, double costIn, double serverCostIn) {
      super(nameIn, costIn);
      this.serverCost = serverCostIn;
   }
   
 /**
 * Gets the server cost.
 * @return double for server cost.
 */
   
   public double getServerCost() {
      return serverCost;
   }
   
 /**
 * Sets the server cost for object.
 * @param serverCostIn is passes in.
 */
   
   public void setServerCost(double serverCostIn) {
      this.serverCost = serverCostIn;
   }
   
 /**
 * Calculates monthly cost.
 * @return double for monthly cost.
 */
   
   public double monthlyCost() {
      return (cost + serverCost);
   }
   
 /**
 * Formats output of object.
 * @return String of formatted object.
 */
   
   public String toString() {
      DecimalFormat dfmt = new DecimalFormat("$#,##0.00");
      return (super.toString() + "\nServer Cost: " 
         + dfmt.format(getServerCost()));
   }
}