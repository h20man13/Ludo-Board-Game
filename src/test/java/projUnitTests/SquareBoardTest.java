////////////////////////////////////////////////////////////////////////////////
// File:             SquareBoardTest.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package projUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Coordinates;
import javafx.scene.paint.Color;
import shapes.SquareBoard;

/**
 * 
 */
public class SquareBoardTest 
{

   @SuppressWarnings("deprecation")
   @Test
   public void test() 
   {
      SquareBoard f = new SquareBoard(new Coordinates(0, 7), 88, Color.BLUE);
      assertEquals(88, f.getSize());
   }

}
