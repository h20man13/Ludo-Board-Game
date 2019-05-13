////////////////////////////////////////////////////////////////////////////////
// File:             EasyDice.java
// Course:           CSC232B, Spring 2019
// Authors:          Brian Howard
//
// Acknowledgments:  Refactored from code by Jacob Bauer
//
// Online sources:   None
////////////////////////////////////////////////////////////////////////////////

package control;

import java.util.Random;

/**
 * 
 */
public class EasyDice implements Dice {
   public EasyDice() {
      r = new Random();
      choices = new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6 };
   }

   public int roll() {
      return choices[r.nextInt(choices.length)];
   }

   public String getDiff() {
      return "easy";
   }

   private Random r;
   private int[] choices;
}
