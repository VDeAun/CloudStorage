import java.io.FileNotFoundException;
/**
*  Victoria Goss
*  September 20, 2021
*  Creating Driver class for programs. 
**/

public class CloudStoragePart3  {

/**
*  Tests the two options of having a file or not having a file.
*  @param args used
*  @throws FileNotFoundException 
**/

   public static void main(String[] args) {
   
      try {
         if (args.length == 0) {
         
            System.out.println("File name expected as command line argument.");
            System.out.println("Program ending.");
         }
         
         else {
         
            CloudStorageList csl = new CloudStorageList();
            csl.readFile("cloud_storage_data_2_exceptions.csv");            
            System.out.println(csl.generateReport());
            System.out.println(csl.generateReportByName());
            System.out.println(csl.generateReportByMonthlyCost());
            System.out.println(csl.generateInvalidRecordsReport());
         }
      }
      catch (FileNotFoundException e) {
         System.out.print("*** Attempted to read file: " + e.toString());
      }
      
   }
}