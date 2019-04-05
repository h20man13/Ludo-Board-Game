////////////////////////////////////////////////////////////////////////////////
// File:             DiceTest.java
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
public class DiceTest {

   /**
    * Test method for {@link Control.Dice#Dice(java.lang.String)}.
    */
   @Test
   public void testDice() 
   {
      Dice first = new Dice("df;lkjhgs");
      assertNull(first.roll());
   }

}
