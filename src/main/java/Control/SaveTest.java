////////////////////////////////////////////////////////////////////////////////
// File:             SaveTest.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package Control;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */
public class SaveTest {

   /**
    * Test method for {@link Control.Save#save(java.lang.String[])}.
    */
   Save s = new Save("SaveTest.txt");
   @Test
   public void testSave() 
   {
      String[] ss = new String[]{"Hey was up","Cool  "};
      s.save(ss);
   }

   /**
    * Test method for {@link Control.Save#get()}.
    */
   @Test
   public void testGet() 
   {
      String[] ss = s.get();
      for(int i = 0; i < ss.length; i++)
      {
         assert.assertArrayEquals();
      }
   }

   /**
    * Test method for {@link Control.Save#isEmpty()}.
    */
   @Test
   public void testIsEmpty() 
   {
      assert.assertTrue(s.isEmpty());
   }

}
