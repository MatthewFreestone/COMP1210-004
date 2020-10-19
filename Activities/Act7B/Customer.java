/** 
 * A class that represents customers and holds their 
 * name, location, and balance. 
 *
 * @author Matthew Freestone
 * @version 10/19/2020  
 */
public class Customer implements Comparable<Customer> {
   private String name;
   private String location;
   private double balance; 

   /**
    * Constructor for the class.

    * @param nameIn Name of Customer
    */
   public Customer(String nameIn) {
      name = nameIn;
      location = "";
      balance = 0;
   }

   
   /**
    * Sets the location of the customer. 
    * 
    * @param locationIn the location
    */
   public void setLocation(String locationIn) {
      location = locationIn;
   }

   
   /**
    * Sets the location of the customer using city and state. 
    * 
    * @param city customer's city
    * @param state customer's state
    */
   public void setLocation(String city, String state) {
      setLocation(city + ", " + state);
   }
   
   
   /** 
    * Changes the customer's balance by the inputed amount.
    * 
    * @param amount amount to change
    */
   public void changeBalance(double amount) {
      balance += amount;
   }

   
   /**
    * Returns the location of the customer.  
    * 
    * @return String customer's location
    */
   public String getLocation() {
      return location;
   }

   
   /**
    * Returns the balance of the customer.  
    * 
    * @return double customer's balance
    */
   public double getBalance() {
      return balance;
   }
   
   
   /**
    * Compares the customer to others and reports how their balances compare. 
    * 
    * @param obj the customer to compare to this one
    * @return int 0 for equal, -1 for obj being greater, 
    *       and 1 for this being greater
    */
   @Override
   public int compareTo(Customer obj) {
      if (Math.abs((this.balance - obj.getBalance())) < 0.00001) {
         return 0;
      }
      else if (this.balance < obj.getBalance()) {
         return -1;
      }
      else {
         return 1;
      }
   }


   
   /**
    * Returns a representation of an customer as a string. 
    * 
    * @return String represenation of a customer
    */
   @Override
   public String toString() {
      return name + "\n" + location + "\n" + "$" + balance;
   }


}