import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/** 
 * A class for testing the Spherocylinder class.
 *
 * @author Matthew Freestone
 * @version 10/12/2020 
 */
public class SpherocylinderTest {

   /**
    * Tests the get and set label methods. 
    */
   @Test
   public void labelTest() {
      Spherocylinder s = new Spherocylinder("bob", 2, 5);
      Assert.assertEquals(true, s.setLabel("jimmy"));
      Assert.assertEquals("jimmy", s.getLabel());
      Assert.assertEquals(false, s.setLabel(null));
   }

   /**
    * Tests the get and set radius methods. 
    */
   @Test
   public void radiusTest() {
      Spherocylinder s = new Spherocylinder("bob", 2, 5);
      Assert.assertEquals(true, s.setRadius(3));
      Assert.assertEquals(3, s.getRadius(), 0.0001);
      Assert.assertEquals(false, s.setRadius(-5));
   }

   /**
    * Tests the get and set height methods. 
    */
   @Test
   public void heightTest() {
      Spherocylinder s = new Spherocylinder("bob", 2, 5);
      Assert.assertEquals(true, s.setCylinderHeight(7));
      Assert.assertEquals(7, s.getCylinderHeight(), 0.0001);
      Assert.assertEquals(false, s.setCylinderHeight(-5));
   }

   /**
    * Tests the circumference method.
    */
   @Test
   public void circumferenceTest() {
      Spherocylinder s = new Spherocylinder("bob", 2, 5);
      double c = 12.566370614359172;
      Assert.assertEquals(c, s.circumference(), 0.000001);
   }

   /**
    * Tests the surfaceArea method.
    */
   @Test
   public void surfaceAreaTest() {
      Spherocylinder s = new Spherocylinder("bob", 2, 5);
      double sa = 113.09733552923255;
      Assert.assertEquals(sa, s.surfaceArea(), 0.000001);
   }

   /**
    * Tests the volume method.
    */
   @Test
   public void volumeTest() {
      Spherocylinder s = new Spherocylinder("bob", 2, 5);
      double v = 96.34217471008698;
      Assert.assertEquals(v, s.volume(), 0.000001);
   }

   /**
    * Tests the toString method.
    */
   @Test
   public void toStringTest() {
      Spherocylinder example1 = new Spherocylinder("Small Example", 0.5, 0.25);
      String ex1 = "Spherocylinder \"Small Example\" with " 
            + "radius 0.5 and cylinder height "
            + "0.25 has:\n\tcircumference = 3.142 units\n\tsurface area = "
            + "3.927 square units\n\tvolume = 0.72 cubic units";
      Assert.assertEquals(ex1, example1.toString());
      Spherocylinder example2 = 
         new Spherocylinder(" Medium Example ", 10.8, 10.1);
      String ex2 = "Spherocylinder \"Medium Example\" with radius 10.8 "
            + "and cylinder height 10.1 has:\n\tcircumference = 67.858 "
            + "units\n\tsurface area = 2,151.111 square units\n\t"
            + "volume = 8,977.666 cubic units";
      Assert.assertEquals(ex2, example2.toString());
      Spherocylinder example3 = 
         new Spherocylinder("Large Example", 98.32, 99.0);
      String ex3 = "Spherocylinder \"Large Example\" with " 
            + "radius 98.32 and cylinder height 99.0"
            + " has:\n\tcircumference = 617.763 units\n\tsurface area = "
            + "182,635.388 square units\n\tvolume = 6,987,754.655 cubic units";
      Assert.assertEquals(ex3, example3.toString());
   }

   /**
    * Tests the getCount method.
    */
   @Test
   public void getCountTest() {
      int start = Spherocylinder.getCount();
      Spherocylinder example1 = new Spherocylinder("Small Example", 0.5, 0.25);
      Assert.assertEquals(start + 1, Spherocylinder.getCount());
      Spherocylinder example2 = 
         new Spherocylinder(" Medium Example ", 10.8, 10.1);
      Assert.assertEquals(start + 2, Spherocylinder.getCount());
   }

   /**
    * Tests the resetCount method. 
    */
   @Test
   public void resetCountTest() {
      //ensure there's at least one at the start
      Spherocylinder example1 = new Spherocylinder("Small Example", 0.5, 0.25); 
      Spherocylinder.resetCount();
      Assert.assertEquals(0, Spherocylinder.getCount());
   }

   /**
    * Tests the equals method.
    */
   @Test
   public void equalsTest() {
      Spherocylinder main = new Spherocylinder("Small Example", 0.5, 0.25);
      Spherocylinder lowerCase = new Spherocylinder("small example", 0.5, 0.25);
      Spherocylinder diffLabel = new Spherocylinder("bad example", 0.5, 0.25);
      Spherocylinder diffRad = new Spherocylinder("small example", 0.3, 0.25);
      Spherocylinder diffHeight = new Spherocylinder("small example", 0.5, 0.5);
      ArrayList<Integer> notIt = new ArrayList<Integer>();
      Assert.assertEquals(true, main.equals(lowerCase));
      Assert.assertEquals(false, main.equals(notIt));
      Assert.assertEquals(false, main.equals(diffLabel));
      Assert.assertEquals(false, main.equals(diffRad));
      Assert.assertEquals(false, main.equals(diffHeight));
   }

   /**
    * Tests the compareTo method for equality (0).
    */
   @Test
   public void compareToTest1() {
      Spherocylinder s1 = new Spherocylinder("s1", 3, 3);
 
      Spherocylinder s2 = new Spherocylinder("s2", 3, 3);
 
      Assert.assertTrue(s1.compareTo(s2) == 0);
   }

    /**
    * Tests the compareTo method for less volume (-1).
    */
   @Test
   public void compareToTest2() {
      Spherocylinder s1 = new Spherocylinder("s1", 2, 2);

      Spherocylinder s2 = new Spherocylinder("s2", 3, 3);

      Assert.assertTrue(s1.compareTo(s2) == -1);
   }

    /**
    * Tests the compareTo method for greater volume (1).
    */
   @Test
   public void compareToTest3() {
      Spherocylinder s1 = new Spherocylinder("s1", 5, 5);

      Spherocylinder s2 = new Spherocylinder("s2", 3, 3);

      Assert.assertTrue(s1.compareTo(s2) == 1);
   }

   /**
    * Tests the hashCode method.
    */
   @Test
   public void hashCodeTest() {
      Spherocylinder example1 = new Spherocylinder("Small Example", 0.5, 0.25);
      Assert.assertEquals(0, example1.hashCode());
   }

}

