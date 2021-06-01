////////////////////////////////////////////////////////////////////////////////
// File:             ChoosePane.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer, Shriyanshi Shikha, Muhammad Zain Bin Ihsan Janjua
////////////////////////////////////////////////////////////////////////////////

package edu.depauw.ludo_board_game.ludo.gui.board;
import javafx.scene.layout.Pane;
/**
 * The board pane class is a way to specify the pane for all my Board shape classes I created in the project.<br>
 * It must be initialized in the run method otherwise any shape object can not be built
 * @author Jacob Bauer <jacobbauer_2021@depauw.edu>
 */
public class BoardPane 
{
   private static Pane p = new Pane(); 
   private static boolean check = false;
   /**
    * get Pane method is a method for the shape classes to use in order to set the shape Pane
    * @return It return a Pane I didnt want the shape classes to have the ability to modify the pane directly
    */
   public static Pane getPane()
   {
      if(check)
      {
         return p;
      }
      else
      {
         System.err.println("Error: Pane has not been selected");
         return p;
      }
   }
   /**
    * It is a way so that you can check whether the pane has been initialized
    * @return it returns true if it was initialized false if the pane  initialized
    */
   public static boolean check()
   {
      return check;
   }
   /**
    * Most important function to initialize the Pane for the Board all the shape classes are based off of this function
    * @param p Pane to be initialized as the board pane
    */
   public static void InitPane(Pane p)
   {
      if(!check)
      {
         BoardPane.p = p;
         check = true;
      }
      else
      {
         System.err.println("Error: you can only initialize Panes once");
      }
   }
}
