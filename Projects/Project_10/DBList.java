import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/** 
 * A class that holds an array of DB and allows operations on it.
 * 
 * @author Matthew Freestone
 * @version 11/8/2020 
 */
public class DBList {
   private DB[] dbArray;
   private String[] invalidRecords;

   /**
    * Constructor.
    */
   public DBList() {
      dbArray = new DB[0];
      invalidRecords = new String[0];
   }

   /**
    * Returns the array of DBs. 
    * @return array of DBs
    */
   public DB[] getDBArray() {
      return dbArray;
   }

   /**
    * Returns the array of strings of invalid records. 
    * @return invalid records as a String[]
    */
   public String[] getInvalidRecordsArray() {
      return invalidRecords;
   }

   /**
    * Adds the requested DB into the array.
    * @param in DB to be added
    */
   public void addDB(DB in) {
      int initialLen = dbArray.length;
   
      DB[] newArray = new DB[initialLen + 1];
      for (int i = 0; i < initialLen; i++) {
         newArray[i] = dbArray[i];
      }
      newArray[initialLen] = in;
      dbArray = newArray.clone();
   }

   /**
    * Adds requested InvalidRecord to the array.
    * @param in new invalid record
    */
   public void addInvalidRecord(String in) {
      int initialLen = invalidRecords.length;
   
      String[] newArray = new String[initialLen + 1];
      for (int i = 0; i < initialLen; i++) {
         newArray[i] = invalidRecords[i];
      }
      newArray[initialLen] = in;
      invalidRecords = newArray.clone();
   }

   /**
    * Creates DB objects from information in the given file. 
    * @param filename name of file to get information from
    * @throws FileNotFoundException thrown when file name does not exist
    */
   public void readFile(String filename) throws FileNotFoundException {
      Scanner file = new Scanner(new File(filename));
      while (file.hasNextLine()) {
         String line = file.nextLine();
         Scanner s = new Scanner(line).useDelimiter(",");
         char code = s.next().toCharArray()[0];
         switch (code) {
            case 'C':
               CentralizedDB c = new CentralizedDB(s.next(), s.nextDouble(), 
                     s.nextDouble(), s.nextDouble());
               this.addDB(c);
               s.close();
               break;
            case 'D':
               DistributedDB d = new DistributedDB(s.next(), s.nextDouble(), 
                     s.nextDouble(), s.nextInt(), s.nextDouble());
               this.addDB(d);
               s.close();
               break;
            case 'H':
               HomogeneousDB h = new HomogeneousDB(s.next(), s.nextDouble(), 
                     s.nextDouble(), s.nextInt(), s.nextDouble());
               this.addDB(h);
               s.close();
               break;
            case 'E':
               HeterogeneousDB e = new HeterogeneousDB(s.next(), 
                     s.nextDouble(), s.nextDouble(), 
                     s.nextInt(), s.nextDouble());
               this.addDB(e);
               s.close();
               break;
            default:
               continue;
         }
      }
      file.close();
   }

   /**
    * Returns a String represenation of all of the DB in the array. 
    * @return String represenation of all the DB in array
    */
   public String generateReport() {
      String out = "-------------------------------\n";
      out += "Monthly Database Report\n";
      out += "-------------------------------\n";
      for (DB db : dbArray) {
         out += db.toString() + "\n\n";
      }
      return out;
   }

   /**
    * Returns a String represenation of all of the DB in the array. 
    * Sorted By Name in alphabetical order. 
    * @return String represenation of all the DB in array
    */
   public String generateReportByName() {
      Arrays.sort(dbArray);
      String out = "-----------------------------------------\n";
      out += "Monthly Database Report (by Name)\n";
      out += "-----------------------------------------\n";
      for (DB db : dbArray) {
         out += db.toString() + "\n\n";
      }
      return out;
   }

   /**
    * Returns a String represenation of all of the DB in the array. 
    * Sorted By MontlyCost from most to least. 
    * @return String represenation of all the DB in array
    */
   public String generateReportByMonthlyCost() {
      Arrays.sort(dbArray, new MonthlyCostComparator());
   
      String out = "-------------------------------------------------\n";
      out += "Monthly Database Report (by Monthly Cost)\n";
      out += "-------------------------------------------------\n";
      for (DB db : dbArray) {
         out += db.toString() + "\n\n";
      }
      return out;
   }
}