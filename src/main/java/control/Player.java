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
   private Token[] tokens;
   private String cpu;
   private Dice diff;
   public Player(int tokenAmount, String tf, Coordinates[] C, Color c, Dice d, int[] paths)
   {
      tokens = new Token[tokenAmount];
      for(int i = 0; i < tokenAmount; i++)
      {
         tokens[i] = new Token(C[i], Board.StartingLocations[0].getSize()/2, c, paths[i]);
      }
      cpu = tf.toLowerCase();
      if(cpu.equals("yes"))
      {
         diff = d;
      }
      else
      {
         diff = new Dice("medium");
      }
   }
   public String isCPU()
   {
      return cpu;
   }
   public Token[] getTokens()
   {
      return tokens;
   }
   public String getDifficulty()
   {
      return diff.getDiff();
   }
}
