/**
 * Class for keeping track of loans from a bank.
 */
public class BankLoan {
	// constant fields
   private static final int MAX_LOAN_AMOUNT = 100000;

   // instance variables (can be used within the class)
   private String customerName;
   private double balance, interestRate;
   private static int loansCreated = 0;

   
   /**
    * Constructor  .
    * 
    * @param customerNameIn Name of Customer
    * @param interestRateIn Interest rate as a decimal
    */
   public BankLoan(String customerNameIn, double interestRateIn) { 
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++;
   }
   
   /**
    * Checks if a loan is currently in debt.
    * 
    * @param loan the object being checked
    * @return boolean if the person who took out the loan is in debt
    */
   public static boolean isInDebt(BankLoan loan) {
      if (loan.getBalance() > 0) {
         return true;
      }
      return false; 
   }

   
   /**
    *  Returns the number of total loans taken.
    * 
    * @return int number of total loans taken
    */
   public static int getLoansCreated() {
      return loansCreated;
   }

   /**
    *  Resets the number of loans created back to 0.
    * 
    */
   public static void resetLoansCreated() {
      loansCreated = 0;
   }

   
   /** 
    * Borrows the given amount of money from the back as long as 
    * it does not create a loan too large.
    * 
    * @param amount The amount of money to be added to the loan
    * @return boolean If the loan was made
    */
   public boolean borrowFromBank(double amount) {
      
      boolean wasLoanMade = false;
      
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
      }
   
      return wasLoanMade;
   }

   
   /** 
    * Lowers the loan amount by paying back the bank. 
    * 
    * @param amountPaid Amount to give to the bank
    * @return double the new balance of the loan 
    */
   public double payBank(double amountPaid) {
      double newBalance = balance - amountPaid;
      if (newBalance < 0) {
         balance = 0;
         // paid too much, return the overcharge
         return Math.abs(newBalance);
      }
      else {
         balance = newBalance;
         return 0;
      }
   }
   
   
   /**
    * Returns the balance on the loan. 
    * 
    * @return double current balance
    */
   public double getBalance() {
      return balance;
   }
   
   
   /** 
    * Sets the interest rate for the loan (cannot be negative or over 100%).
    * 
    * @param interestRateIn The new interest rate as a decimal
    * @return boolean If the new rate was set
    */
   public boolean setInterestRate(double interestRateIn) {
   
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   
   /** 
    * Returns the interest rate of the loan.
    * 
    * @return double interest rate
    */
   public double getInterestRate() {
      return interestRate;
   }
   
    /** 
    * Adds the interest on the loan to the balance.
    */
   public void chargeInterest() {
      balance = balance * (1 + interestRate);
   }

   
   /** 
    * Checks if the inputed number is a valid amount to be a balance.
    * 
    * @param amount number to be checked
    * @return boolean true if the number is valid
    */
   public static boolean isAmountValid(double amount) {
      if (amount >= 0) {
         return true;
      }
      return false; 
   }
   
   
   /** 
    * Returns a printable represtation of the information in the instance.
    * 
    * @return String state values as a string
    */
   public String toString() {
      String output = "Name: " + customerName + "\r\n" 
         + "Interest rate: " + interestRate + "%\r\n" 
         + "Balance: $" + balance + "\r\n";
      return output;
   }

}
