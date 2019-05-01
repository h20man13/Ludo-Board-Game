////////////////////////////////////////////////////////////////////////////////
// File:             Player.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package control;
import gui.shapes.Token;
import java.lang.String;
import javafx.scene.paint.Color;
import gui.board.Board;
/**
 * 
 */
public class Player 
{
   private int score;
   private Token[] tokens;
   String cpu;
   private Dice diff;
   public Player(int s, int tokenAmount, String tf, Coordinates[] C, Color c, Dice d)
   {
      score = s;
      tokens = new Token[tokenAmount];
      for(int i = 0; i < tokenAmount; i++)
      {
         tokens[i] = new Token(C[i], Board.StartingLocations[0].getSize()/2, c);
      }
      cpu = tf;
      if(cpu.equals("yes"))
      {
         diff = d;
      }
      else
      {
         diff = new Dice("medium");
      }
   }
   public void roll(int n)
   {
      int f = diff.roll();
      if(tokens[n].getPathOn(0))
      {
         for(int i = 1; i <= f; i++)
         {
            tokens[n].move();
         }
      }
      else if(tokens[n].getPathOn(1))
      {
         
      }
      else if(tokens[n].getPathOn(2))
      {
         
      }
      else
      {
         System.err.println("Error: It is inposxsible to select an end piece");
         System.exit(0);
      }
   }
   
}
