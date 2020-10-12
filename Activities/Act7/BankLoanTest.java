import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Contains tests to be run on the BankLoan class.
 */
public class BankLoanTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /**
    * Checks if interest is charged right.
    */
   @Test public void chargeInterestTest() {
      BankLoan loan1 = new BankLoan("Jane", .10);
      loan1.borrowFromBank(1000.00);
      loan1.chargeInterest();
      Assert.assertEquals(" ", 1100, loan1.getBalance(), .000001);
   }  
   
   /**
   * Checks the work done in pt 1 of activity. 
   */
   @Test public void pt1Test() {
      BankLoan b = new BankLoan("Bob", 0.08);
      boolean tested = BankLoan.isInDebt(b);
      Assert.assertEquals(" ", false, tested);
      b.borrowFromBank(1); // borrow $1.00
      tested = BankLoan.isInDebt(b);
      Assert.assertEquals(" ", true, tested);
   }
   
   /**
   * Checks the work done in pt 2 of activity. 
   */
   @Test public void pt2Test() {
      BankLoan.resetLoansCreated();
      Assert.assertEquals("getLoans", BankLoan.getLoansCreated(), 0);
      BankLoan jane = new BankLoan("Jane L", 0.09);
      BankLoan bob = new BankLoan("Bob S", 0.09);
      Assert.assertEquals("getLoans", BankLoan.getLoansCreated(), 2);
      bob = new BankLoan("Bob Parker", 0.02);
      Assert.assertEquals("getLoans", BankLoan.getLoansCreated(), 3);
      BankLoan.resetLoansCreated();
      Assert.assertEquals("getLoans", BankLoan.getLoansCreated(), 0);
   }

   /**
    * Tests the method borrowFromBank
    */
   @Test public void borrowFromBankTest() {
      BankLoan b = new BankLoan("Bob", .1);
      Assert.assertEquals("", b.borrowFromBank(999999999), false);
   }

   /**
    * Tests the method payBank
    */
   @Test public void payBankTest() {
      BankLoan b = new BankLoan("Bob", .1);
      b.borrowFromBank(90.00);
      Assert.assertEquals("", 0, b.payBank(50), 0.001);
      Assert.assertEquals("", 12, b.payBank(52), 0.001);
   }

   /**
    * Tests the method setInterestRate
    */
   @Test public void setInterestRateTest() {
      BankLoan b = new BankLoan("Bob", .1);
      Assert.assertEquals("", b.setInterestRate(-0.2), false);
      Assert.assertEquals("", b.setInterestRate(15), false);
      Assert.assertEquals("", b.setInterestRate(.2), true);
   }

   /**
    * Tests the method isAMountValid
    */
   @Test public void isAmountValidTest() {
      Assert.assertEquals("", BankLoan.isAmountValid(10), true);
      Assert.assertEquals("", BankLoan.isAmountValid(-10), false);
   }

   /**
    * Tests the method toString
    */
   @Test public void toStringTest() {
      BankLoan b = new BankLoan("Bob", .1);
      String desired = "Name: Bob\r\nInterest rate: 0.1%\r\nBalance: $0.0\r\n";
      Assert.assertEquals("", desired, b.toString());
   }
}
