////////////////////////////////////////////////////////////////////////////////
// File:             Player.java
// Course:           CSC232B, Spring 2019
// Authors:          Shriyanshi Shikha, Muhammad Zain Bin Ihsan Janjua
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package control;
import java.lang.String;
import javafx.scene.paint.Color;
import gui.board.Board;
import gui.board.Token;

import java.lang.Math;
/**
 * 
 */
public class Player 
{
   private Token[] tokens;
   private String cpu;
   private Dice diff;
   private Color c;
   public Player(int tokenAmount, String tf, Coordinates[] C, Color c, Dice d, int[] paths)
   {
      this.c = c;
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
   public int findClosest(Coordinates f)
   {
      int index = 0;
      double closestC = Math.sqrt((f.X() - tokens[0].getCoordinates().X()) * (f.X() - tokens[0].getCoordinates().X()) + (f.Y() - tokens[0].getCoordinates().Y()) * (f.Y() - tokens[0].getCoordinates().Y()));
      for(int i = 0; i < tokens.length; i++)
      {
         double n = Math.sqrt((f.X() - tokens[i].getCoordinates().X()) * (f.X() - tokens[i].getCoordinates().X()) + (f.Y() - tokens[i].getCoordinates().Y()) * (f.Y() - tokens[i].getCoordinates().Y()));
         if(n < closestC)
         {
            closestC = n;
            index = i;
         }
      }
      return index;
   }
   public Color getColor()
   {
      return c;
   }
   public int[] findpossible()
   {
      int count = 0;
      for(int i = 0; i < tokens.length; i++)
      {
         if(tokens[i].getPath() < 3 && tokens[i].getPath() >= 0)
         {
            count++;
         }
      }
      int[] indexis = new int[count];
      count = 0;
      for(int i = 0; i < tokens.length; i++)
      {
         if(tokens[i].getPath() < 3 && tokens[i].getPath() >= 0)
         {
            indexis[count] = i;
            count++;
         }
      }  
      return indexis;
   }
   public int Roll()
   {
      return diff.roll();
   }
}
