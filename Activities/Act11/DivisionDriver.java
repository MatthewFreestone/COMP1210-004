import javax.swing.JOptionPane;
/** 
 * Driver program for testing the Division class.
 *
 * @author Matthew Freestone
 * @version 11/13/2020 
 */
public class DivisionDriver {

   /**
    * Opens up panes to enter values to test the method.
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) {
      String numIn = JOptionPane.showInputDialog("Enter the numerator: ");
      String denomIn = JOptionPane.showInputDialog("Enter the denominator: ");
   
      try {
         int num = Integer.parseInt(numIn);
         int denom = Integer.parseInt(denomIn);
         String result = "Integer division: \n" 
            + Division.intDivide(num, denom)
            + "\n\nFloating point division: \n"
            + Division.decimalDivide(num, denom);
         JOptionPane.showMessageDialog(null, result,
                "Result", JOptionPane.PLAIN_MESSAGE);
      }
      catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null, 
               "Invalid input: enter numerical integer values only.", 
               "Error", JOptionPane.ERROR_MESSAGE);
      }
      catch (IllegalArgumentException e) {
         JOptionPane.showMessageDialog(null, e, 
               "Error", JOptionPane.ERROR_MESSAGE);
      }
   }
}