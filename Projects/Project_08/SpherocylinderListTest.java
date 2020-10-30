import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

/** 
 * A class for testing the SpherocylinderList class.
 *
 * @author Matthew Freestone
 * @version 10/29/2020 
 */
public class SpherocylinderListTest {

   /**
    * Returns a sample array for use.
    *
    * @return sample array
    */
   private Spherocylinder[] getSampleArray() {
      Spherocylinder s1 = new Spherocylinder("s1", 0.5, 0.25);
      Spherocylinder s2 = new Spherocylinder("s2", 10.8, 10.1);
      Spherocylinder s3 = new Spherocylinder("s3", 98.32, 99.0);
   
      Spherocylinder[] array = {s1, s2, s3};
      return array;
   }

   /**
    * Tests the get name method. 
    */
   @Test
   public void getNameTest() {
      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
      assertEquals("sl1", s.getName());
   }

   /**
    * Tests the numOfSpherocylinders method.
    */
   @Test
   public void numofSpherocylindersTest() {
      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
      assertEquals(3, s.numberOfSpherocylinders());
   }

   /**
    * Tests the totalVolume method.
    */
   @Test
   public void totalVolumeTest() {
      Spherocylinder s1 = new Spherocylinder("s1", 0.5, 0.25);
      Spherocylinder s2 = new Spherocylinder("s2", 10.8, 10.1);
      Spherocylinder s3 = new Spherocylinder("s3", 98.32, 99.0);
      Spherocylinder[] arrayEmpty = {s1, s2, s3, null};


      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
      assertEquals(6996733.04095263, s.totalVolume(), 0.00001);
      s = new SpherocylinderList("sl2", new Spherocylinder[0], 0);
      assertEquals(0, s.totalVolume(), 0.001);
      s = new SpherocylinderList("sl3", arrayEmpty, 3);
      assertEquals(6996733.04095263, s.totalVolume(), 0.00001);
   }

   /**
    * Tests the totalSurfaceArea method.
    */
   @Test
   public void totalSurfaceAreaTest() {
      Spherocylinder s1 = new Spherocylinder("s1", 0.5, 0.25);
      Spherocylinder s2 = new Spherocylinder("s2", 10.8, 10.1);
      Spherocylinder s3 = new Spherocylinder("s3", 98.32, 99.0);
      Spherocylinder[] arrayEmpty = {s1, s2, s3, null};

      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
      assertEquals(184790.42641495977, s.totalSurfaceArea(), 0.00001);
      s = new SpherocylinderList("sl2", new Spherocylinder[0], 0);
      assertEquals(0, s.totalSurfaceArea(), 0.001);
      s = new SpherocylinderList("sl3", arrayEmpty, 3);
      assertEquals(184790.42641495977, s.totalSurfaceArea(), 0.00001);
   }

   /**
    * Tests the averageSurfaceArea method.
    */
   @Test
   public void averageSurfaceAreaTest() {
      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
      assertEquals(61596.80880498659, s.averageSurfaceArea(), 0.00001);
      s = new SpherocylinderList("sl2", new Spherocylinder[0], 0);
      assertEquals(0, s.averageSurfaceArea(), 0.001);
   }

   /**
    * Tests the averageVolume method.
    */
   @Test
   public void averageVolumeTest() {
      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
      assertEquals(2332244.34698421, s.averageVolume(), 0.00001);
      s = new SpherocylinderList("sl2", new Spherocylinder[0], 0);
      assertEquals(0, s.averageVolume(), 0.001);
   }

   /**
    * Tests the toString method.
    */
   @Test
   public void toStringTest() {
      String req = "----- Summary for Spherocylinder Test List -----\n";
      req += "Number of Spherocylinders: 3\n";
      req += "Total Surface Area: 184,790.426\n";
      req += "Total Volume: 6,996,733.041\n";
      req += "Average Surface Area: 61,596.809\n";
      req += "Average Volume: 2,332,244.347\n";
      
      SpherocylinderList s = 
            new SpherocylinderList("Spherocylinder Test List", 
            getSampleArray(), 3);
      
      assertEquals(req, s.toString());
   }

   /**
    * Tests the getList method.
    */
   @Test
   public void getListTest() {
      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
      assertArrayEquals(getSampleArray(), s.getList());
   }

   /**
    * Tests the addSpherocylinder method.
    */
   @Test
   public void addSpherocylinderTest() {
      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
      s.addSpherocylinder("s4", 1, 2);
   
      Spherocylinder s1 = new Spherocylinder("s1", 0.5, 0.25);
      Spherocylinder s2 = new Spherocylinder("s2", 10.8, 10.1);
      Spherocylinder s3 = new Spherocylinder("s3", 98.32, 99.0);
      Spherocylinder s4 = new Spherocylinder("s4", 1, 2);
      Spherocylinder[] newArray = {s1, s2, s3, s4};
   
      assertArrayEquals(newArray, s.getList());
      assertEquals(4, s.numberOfSpherocylinders());

      newArray = new Spherocylinder[]{s1, s2, null, null};
      s = new SpherocylinderList("sl1", newArray, 2);
      s.addSpherocylinder("s4", 1, 2);
   }

   /**
    * Tests the findSpherocylinder method.
    */
   @Test
   public void findSpherocylinderTest() {
      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
      Spherocylinder s2 = new Spherocylinder("s2", 10.8, 10.1);
      Spherocylinder s3 = new Spherocylinder("s3", 98.32, 99.0);
      assertTrue(s.findSpherocylinder("s2").equals(s2));
      assertTrue(s.findSpherocylinder("S3").equals(s3));
      assertEquals(null, s.findSpherocylinder("Nope"));
   
      s = new SpherocylinderList("sl2", new Spherocylinder[0], 0);
      assertEquals(null, s.findSpherocylinder("any"));
   }

   /**
    * Tests the deleteSpherocylinder method.
    */
   @Test
   public void deleteSpherocylinderTest() {
      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
      
   
      Spherocylinder s1 = new Spherocylinder("s1", 0.5, 0.25);
      Spherocylinder s2 = new Spherocylinder("s2", 10.8, 10.1);
      Spherocylinder s3 = new Spherocylinder("s3", 98.32, 99.0);
      Spherocylinder[] newArray = {s1, s3, null};
   
      assertTrue(s.deleteSpherocylinder("s2").equals(s2));
      assertArrayEquals(newArray, s.getList());
      assertEquals(2, s.numberOfSpherocylinders());
      assertEquals(null, s.deleteSpherocylinder("Nope"));
   
      s = new SpherocylinderList("sl2", new Spherocylinder[0], 0);
      assertEquals(null, s.deleteSpherocylinder("Nope"));
   }

   /**
    * Tests the editSpherocylinder method.
    */
   @Test 
   public void editSpherocylinderTest() {
      SpherocylinderList s = new SpherocylinderList("sl1", getSampleArray(), 3);
   
      Spherocylinder s1 = new Spherocylinder("s1", 0.5, 0.25);
      Spherocylinder s2 = new Spherocylinder("s2", 1, 2);
      Spherocylinder s3 = new Spherocylinder("s3", 98.32, 99.0);
      Spherocylinder[] newArray = {s1, s2, s3};
   
      assertTrue(s.editSpherocylinder("s2", 1, 2));
      assertArrayEquals(newArray, s.getList());
      assertEquals(3, s.numberOfSpherocylinders());
      assertTrue(!s.editSpherocylinder("Nope", 1, 2));
   
      s = new SpherocylinderList("sl2", new Spherocylinder[0], 0);
      assertTrue(!s.editSpherocylinder("Nope", 1, 2));
   }

   /**
    * Tests the findSpherocylinderWithLargestVolume method.
    */
   @Test 
   public void findLargestTest() {
      Spherocylinder s1 = new Spherocylinder("s1", 0.5, 0.25);
      Spherocylinder s2 = new Spherocylinder("s2", 1, 2);
      Spherocylinder s3 = new Spherocylinder("s3", 98.32, 99.0);
      Spherocylinder[] newArray = {s1, s3, s2};
      
      SpherocylinderList s = new SpherocylinderList("sl1", newArray, 3);
      assertTrue(s.findSpherocylinderWithLargestVolume().equals(s3));
   
      s = new SpherocylinderList("sl2", new Spherocylinder[0], 0);
      assertEquals(null, s.findSpherocylinderWithLargestVolume());
   
   }
}

   

