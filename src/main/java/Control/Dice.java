////////////////////////////////////////////////////////////////////////////////
// File:             Dice.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////
package Control;

import java.lang.String;
import java.util.Random;

/**
 * 
 */
public class Dice 
{
   //arrays to control the difficulty of the dice
   private static final int[] easy = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6};
   private static final int[] medium = new int[]{1, 2, 3, 4, 5, 6};
   private static final int[] hard = new int[]{1, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6};
   
   //Dice objects needed to make a proper dice
   private int[] dice;
   private Random r;
   
   public Dice(String in)
   {
      if(in.toLowerCase() == "easy")
      {
         dice = easy;
      }
      else if(in.toLowerCase() == "medium")
      {
         dice = medium;
      }
      else if(in.toLowerCase() == "hard")
      {
         dice = hard;
      }
      else
      {
         System.err.println("Error: String into dice constructor must be Easy, Medium, or Hard(caps doesnt matter)");
      }
      r = new Random();
   }
   //method to roll the dice
   public int roll()
   {
      return dice[r.nextInt(dice.length)];
   }
}
