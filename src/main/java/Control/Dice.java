////////////////////////////////////////////////////////////////////////////////
// File:             Dice.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer
////////////////////////////////////////////////////////////////////////////////
package Control;

import java.lang.String;
import java.util.Random;

/**
 * This class is a dice class in our game we want to have a cpu and we will choose their difficulty
 * The cpus difficulty will create a curbed dice more low numbers for easy more high numbers for hard
 * There is one method roll which rolls the dice
 */
public class Dice 
{
   public static void main(String[] args)
   {
      int amount =  30; //amount to tell if the dice works
      
      Dice easy = new Dice("easy");
      Dice medium = new Dice("Medium");
      Dice hard = new Dice("HARD");
      
      for(int i= 0; i < amount; i++)
      {
         System.out.println(easy.roll() + " " + medium.roll() + " " + hard.roll());
      }
   }
   //arrays to control the difficulty of the dice
   private static final int[] easy = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6};
   private static final int[] medium = new int[]{1, 2, 3, 4, 5, 6};
   private static final int[] hard = new int[]{1, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6};
   
   //Dice objects needed to make a proper dice
   private int[] dice;
   private Random r;
   
   public Dice(String in)
   {
      if(in.toLowerCase().equals("easy")) //dice constructor to set difficulty
      {
         dice = easy;
      }
      else if(in.toLowerCase().equals("medium"))
      {
         dice = medium;
      }
      else if(in.toLowerCase().equals("hard"))
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
