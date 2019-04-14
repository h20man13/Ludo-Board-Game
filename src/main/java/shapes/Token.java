////////////////////////////////////////////////////////////////////////////////
 // File:             Pegs.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package shapes;

import javafx.scene.paint.Color;
import control.Coordinates;
/**
 * 
 */
public class Token
{
   private CircleBoard inside;
   private CircleBoard outside;
   private SquareBoard[] moveArray;
   private Coordinates c;
   private double r;
   private int adress;
   
   public Token(Coordinates c, double r, Color color)
   {
         this.c = c;
         this.r = r;
         outside = new CircleBoard(c, r, color.darker());
         inside = new CircleBoard(c, r/2, color);
   }
   public void MovesPossible(SquareBoard[] f)
   {
      moveArray = f;
   }
   public int getAdress()
   {
      return adress;
   }
   public void setAdress(int number)
   {
      adress = number;
   }
}
