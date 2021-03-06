////////////////////////////////////////////////////////////////////////////////
// File:             DiceTest.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer
////////////////////////////////////////////////////////////////////////////////

package edu.depauw.ludo_board_game.ludo.control;

import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * 
 */
public class DiceTest {

   /**
    * Test method for {@link control.Dice#Dice(java.lang.String)}.
    */
   @Test
   public void testDice() 
   {
      Dice first = Dice.create("df;lkjhgs"); //this will not pass
      //i just tried putting in a bad input to see if my message displayed
      assertNull(first.roll());
   }

}
