////////////////////////////////////////////////////////////////////////////////
// File:             MediumDice.java
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
public class MediumDice implements Dice {
   public MediumDice() {
      r = new Random();
   }
   
   public int roll() {
      return r.nextInt(6) + 1;
   }

   public String getDiff() {
      return "medium";
   }

   private Random r;
}
