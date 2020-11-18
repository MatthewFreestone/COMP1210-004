import java.io.FileNotFoundException;

/** 
 * Main driver method for work done in part 2. 
 * 
 * @author Matthew Freestone
 * @version 11/8/2020 
 */
public class DBPart3 {

   /**
    * Tests the readFile and prints the result in serveral formats. 
    * @param args name of data file
    */
   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println("File name expected as " 
               + "command line argument.\nProgram ending.");
      }
      else {
         DBList dbList = new DBList();
         try {
            dbList.readFile(args[0]);
            System.out.print(dbList.generateReport());
            System.out.print(dbList.generateReportByName());
            System.out.print(dbList.generateReportByMonthlyCost());
            System.out.println(dbList.generateInvalidRecordsReport());
         }
         catch (FileNotFoundException e) {
            System.out.println("*** Attempted to read file: " + e.getMessage());
         }
      }
   }
}