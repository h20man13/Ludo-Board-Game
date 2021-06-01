////////////////////////////////////////////////////////////////////////////////
// File:             Dice.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer, Shriyanshi Shikha, Muhammad Zain Bin Ihsan Janjua, Brian Howard
////////////////////////////////////////////////////////////////////////////////
package edu.depauw.ludo_board_game.ludo.control;

/**
 * The Dice class in our game we want to have a CPU and we will choose their difficulty.<br>
 * The CPU's difficulty will create a curbed dice more low numbers for easy more high numbers for hard.<br>
 * There is one method roll which rolls the dice
 * @author Jacob Bauer <jacobbauer_2021@depauw.edu>
 */
public interface Dice 
{
   public static void main(String[] args)
   {
      int amount =  30; //amount to tell if the dice works
      
      Dice easy = Dice.create("easy");
      Dice medium = Dice.create("Medium");
      Dice hard = Dice.create("HARD");
      
      for(int i= 0; i < amount; i++)
      {
         System.out.println(easy.roll() + " " + medium.roll() + " " + hard.roll());
      }
   }
   
   /**
    * Dice Factory Method. Construct an appropriate Dice instance given a difficulty level.
    */
   public static Dice create(String difficulty) {
      if (difficulty.equalsIgnoreCase("easy")) {
         return new EasyDice();
      } else if (difficulty.equalsIgnoreCase("medium")) {
         return new MediumDice();
      } else if (difficulty.equalsIgnoreCase("hard")) {
         return new HardDice();
      } else {
         System.err.println("Error: String into dice constructor must be Easy, Medium, or Hard (caps doesnt matter)");
         return null;
      }
   }

   /**
    * The roll method rolls a synthetic dice that was created in the constructor
    * @return A roll of the dice that is constructed
    */
   public int roll();
   
   /**
    * @return a String describing the difficulty level
    */
   public String getDiff();
}
