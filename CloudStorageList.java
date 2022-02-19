import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Arrays; 
import java.util.Scanner;

/**
*     Victoria Goss 
*     September 17, 2021
*     Creating CloudStorageList class.
*/

public class CloudStorageList {
   private CloudStorage[] cloudObjects;
   private String[] invalidRecords;

/**
* Setting the array lists to zero.
* Also creating constructor.
*/

   public CloudStorageList() {
      cloudObjects = new CloudStorage[0];
      invalidRecords = new String[0];
   }
   
   /**
   * Returns an array of Cloudobjects.
   * @return cloudStorage array.
   */

   public CloudStorage[] getCloudStorageArray() {
      return cloudObjects;
   }

   /**
   * Returns an array of Strings.
   * @return String array.
   */

   public String[] getInvalidRecordsArray() {
      return invalidRecords;
   }
     
   /**
   * Adds an object to the array.
   * @param cloudObject is added to the list.
   */

   public void addCloudStorage(CloudStorage cloudObject) {
      cloudObjects = Arrays.copyOf(cloudObjects, cloudObjects.length + 1);
      cloudObjects[cloudObjects.length - 1] = cloudObject;
   }

   /**
   * Adds an object to the array.
   * @param invalidRecord is passed through.
   */

   public void addInvalidRecord(String invalidRecord) {
      invalidRecords = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
      invalidRecords[invalidRecords.length - 1] = invalidRecord;
   }

   /**
   * Reads in file and scans for each element.
   * @param fileNameIn takes in a file to read.
   * @throws FileNotFoundException for invalid records.
   */


   public void readFile(String fileNameIn) throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      while (scanFile.hasNextLine()) {
         String line = scanFile.nextLine();
         Scanner scanLine = new Scanner(line);
                  
      
         try {               
            scanLine.useDelimiter(",");   
            char category = scanLine.next().charAt(0);
            String nameIn = scanLine.next();
            double baseStorageCostIn = Double.parseDouble(scanLine.next());
            
            switch (category) {
               case 'D' :
                  double serverCostIn = Double.parseDouble(scanLine.next());
                  DedicatedCloud d = new DedicatedCloud(nameIn,
                     baseStorageCostIn, serverCostIn);
                  addCloudStorage(d);
                  break;
            
               case 'S' :
                  double dataStoredIn = Double.parseDouble(scanLine.next());
                  double dataLimitIn = Double.parseDouble(scanLine.next());
               
                  SharedCloud s = new SharedCloud(nameIn, baseStorageCostIn,
                     dataStoredIn, dataLimitIn);
                  addCloudStorage(s);
                  break;
            
               case 'C' :
                  dataStoredIn = Double.parseDouble(scanLine.next());
                  dataLimitIn = Double.parseDouble(scanLine.next());
               
                  PublicCloud c = new PublicCloud(nameIn, baseStorageCostIn,
                     dataStoredIn, dataLimitIn);
                  addCloudStorage(c);
                  break;
            
               case 'P' :
                  dataStoredIn = Double.parseDouble(scanLine.next());
                  dataLimitIn = Double.parseDouble(scanLine.next());
               
                  PersonalCloud p = new PersonalCloud(nameIn, baseStorageCostIn,
                     dataStoredIn, dataLimitIn);
                  addCloudStorage(p);
                  break;
            
               default:
                  throw new InvalidCategoryException(line);
                  //addInvalidRecord(nameIn);
                  //break;
               
            }
            
         }
            
         catch (NumberFormatException e) {
            line += "\n" + e.toString();
            addInvalidRecord(line);
         
         }  
         
         catch (InvalidCategoryException e) {
            line += "\n" + e.toString();
            addInvalidRecord(line);
         
         }            
         
         catch (NoSuchElementException e) {
            line += "\n" + e.toString() + ": For missing input data";
            addInvalidRecord(line);
         
         }       
      }   
   }         
   
   
   

	/**
	 * generateReport processes the CloudStorage array 
    * using the original order from
	 * the file to produce the Monthly Cloud Storage Report
    * and then returns the
	 * report as String. 
	 

	 * @return String of report unsorted.
	 */

   public String generateReport() {
   
      String reportString = "-------------------------------\n";
      reportString = reportString + "Monthly Cloud Storage Report \n";
      reportString = reportString + "-------------------------------\n";
      for (int i = 0; i < cloudObjects.length; i++) {
         CloudStorage co = cloudObjects[i];
         reportString = reportString + co.toString() + "\n\n";
      }
      return reportString;
   }
  
  /**
	 * generateReportByName sorts the CloudStorage array 
    * by its natural ordering,
	 * and processes the CloudStorage array 
    * to produce the Monthly Cloud Storage
	 * Report (by Name), then returns the report as a String.
	 * @return String of Report sorted by name. 
    */
	 
   public String generateReportByName() {
      Arrays.sort(getCloudStorageArray());
   
   
      String rString = "-----------------------------------------\n";
      rString = rString + "Monthly Cloud Storage Report (by Name)\n";
      rString = rString + "-----------------------------------------\n";
   
      for (int i = 0; i < cloudObjects.length; i++) {
         CloudStorage co = cloudObjects[i];
         //System.out.println(cloudObjects[i]);
         rString = rString + co.toString() + "\n\n";
         //System.out.println(report_string);
      }
      return rString; 
   
   }  	


	/**
	 * generateReportByMonthlyCost sorts the CloudStorage array
    *  by monthly cost, and
	 * processes the CloudStorage array to produce 
    * the Monthly Cloud Storage Report
	 * (by Monthly Cost) and then returns the report as String.
    * @return String for reprots sorted by monthly cost. 
	 */
   public String generateReportByMonthlyCost() {
   
      Arrays.sort(cloudObjects, new MonthlyCostComparator());
   
      String rString = "-------------------------------------------------\n";
      rString += "Monthly Cloud Storage Report (by Monthly Cost)\n";
      rString += "-------------------------------------------------\n";
   
      for (int i = 0; i < cloudObjects.length; i++) {
         CloudStorage co = cloudObjects[i];
         rString = rString + co.toString() + "\n\n";
      }
      return rString;
   
   }
   
   /**
   *  Generates an invalid record report.
   *  @return String output of record.
   */
   
   public String generateInvalidRecordsReport() {
           
      String rString = "----------------------\n";
      rString += "Invalid Records Report\n";
      rString += "----------------------\n";
   
      for (int i = 0; i < invalidRecords.length; i++) {
         String ir = invalidRecords[i];
         rString = rString + ir.toString() + "\n\n";
      }
      return rString;
   
   }
   
   
}