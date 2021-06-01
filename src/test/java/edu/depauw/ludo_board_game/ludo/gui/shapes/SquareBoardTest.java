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

package edu.depauw.ludo_board_game.ludo.gui.shapes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.depauw.ludo_board_game.ludo.control.Coordinates;
import javafx.scene.paint.Color;

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
