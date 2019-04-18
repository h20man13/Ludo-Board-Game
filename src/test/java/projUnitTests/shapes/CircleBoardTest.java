////////////////////////////////////////////////////////////////////////////////
// File:             CircleBoardTest.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package projUnitTests.shapes;

import static org.junit.Assert.*;
import org.junit.Test;

import control.Coordinates;
import gui.shapes.CircleBoard;

/**
 * 
 */
public class CircleBoardTest {

   @SuppressWarnings("deprecation")
   @Test
   public void test() 
   {
      CircleBoard d = new CircleBoard(new Coordinates(100, 878), 0, null);
      assertEquals(0, d.getSize());
      assertEquals(new Coordinates(100, 878), d.getCoordinates());
   }

}
