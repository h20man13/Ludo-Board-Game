package control;
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



import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Test;

import control.Save;

/**
 * 
 */
public class SaveTest 
{

   /**
    * Test method for {@link control.Save#save(java.lang.String[])}.
    */
   Save s = new Save("SaveTest.txt");
   @Test
   public void testSave() throws FileNotFoundException 
   {
      String[] ss = new String[]{"Hey was up","Cool  "};
      s.save(ss);
   }

   /**
    * Test method for {@link control.Save#get()}.
    * @throws FileNotFoundException 
    */
   @Test
   public void testGet() throws FileNotFoundException 
   {
      String[] ss = s.get("SaveTest.txt");
      String[] actual = new String[]{"Line 1", "Line 2", "7890"};
      for(int i = 0; i < ss.length; i++)
      {
         assertEquals(ss[i], actual[i]);
      }
   }
}
