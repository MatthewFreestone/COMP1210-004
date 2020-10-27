
import org.junit.Assert;
import org.junit.Test;

/** 
 * TODO 
 *
 * @author Matthew Freestone
 * @version 10/12/2020 TODO
 */
public class ScoresTest {

   @Test
   public void toStringTest() {
      int[] nums = {2, 5, 8};
      Scores s = new Scores(nums);
      Assert.assertEquals("2\t5\t8\t", s.toString());
   }

   @Test
   public void toStringInReverseTest() {
      int[] nums = {2, 5, 8};
      Scores s = new Scores(nums);
      Assert.assertEquals("8\t5\t2\t", s.toStringInReverse());
   }

   @Test
   public void findEvensTest(){
      int[] nums = {2, 5, 8, 1, 10};
      Scores s = new Scores(nums);
      int[] evens = s.findEvens();
      int[] realEvens = {2,8,10};
      Assert.assertArrayEquals(realEvens, evens);
   }

   @Test
   public void findOddsTest(){
      int[] nums = {1, 5, 8, 3, 10};
      Scores s = new Scores(nums);
      int[] odds = s.findOdds();
      int[] realOdds = {1,5,3};
      Assert.assertArrayEquals(realOdds, odds);
   }

   @Test
   public void averageTest(){
      int[] nums = {2,5,8,7,19};
      Scores s = new Scores(nums);
      double avg = s.calculateAverage();
      double realAvg = 8.2;
      Assert.assertEquals(realAvg, avg, 0.001);
   }
}

