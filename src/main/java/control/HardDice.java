////////////////////////////////////////////////////////////////////////////////
// File:             HardDice.java
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
public class HardDice implements Dice {
   public HardDice() {
      r = new Random();
      choices = new int[] { 1, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6 };
   }

   public int roll() {
      return choices[r.nextInt(choices.length)];
   }

   public String getDiff() {
      return "hard";
   }

   private Random r;
   private int[] choices;
}
