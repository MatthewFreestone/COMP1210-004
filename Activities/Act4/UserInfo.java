
/** 
 * A class designed to hold information about a person. 
 *
 * @author Matthew Freestone
 * @version 9/12/20
 */
public class UserInfo {
   // instance variables
   private String firstName, lastName, location;
   private int age, status; 
   private static final int OFFLINE = 0, ONLINE = 1;

   /**
    * Constructor for the class. 
    *
    * @param firstNameIn First Name
    * @param lastNameIn Last Name
    */
   public UserInfo(String firstNameIn, String lastNameIn) {
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not specified";
      age = 0;
      status = OFFLINE;

   }
   

   /**
    * Function for properly returning instance information as a String. 
    *
    * @return String represenation of instance
    */
   public String toString() {
      String output = "Name: " + firstName + " "
            + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE) {
         output += "Offline";
      }
      else { 
         output += "Online";
      }
      return output; 
   }

   /**
    * Sets the location for the user.
    *
    * @param locationIn the String location for the user
    */
   public void setLocation(String locationIn) {
      location = locationIn;
   }

   
   /** 
    * Sets the age of the user.   
    *
    * @param ageIn Desired age
    * @return boolean Whether the new age was set or not
    */
   public boolean setAge(int ageIn) {
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isSet = true;
      }
      return isSet;
   }

   
   /** 
    * Gives the age of the user.  
    *
    * @return int Age
    */
   public int getAge() {
      return age; 
   }

   
   /**
    * Gives location of the user.  
    * 
    * @return String Location
    */
   public String getLocation() {
      return location;
   }

   /**
    * Changes user's status to offline
    */
   public void logOff() {
      status = OFFLINE;
   }

   /**
    * Changes user's status to offline
    */
   public void logOn() {
      status = ONLINE;
   }
}

