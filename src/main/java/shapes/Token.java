////////////////////////////////////////////////////////////////////////////////
 // File:             Pegs.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package shapes;

import javafx.scene.paint.Color;
import control.Coordinates;
/**
 * This class is what creates the token mobjects that will move around the board
 * @author Jacob Bauer
 */
public class Token
{
   private CircleBoard inside;
   private CircleBoard outside;
   private SquareBoard[] moveArray;
   private Coordinates c;
   private double r;
   public int adress;
   /**
    * The constructor is defined so it creates a token which has two circles an outside circle and an inside circle <br>
    * the outside circle is darker so it doesn't blend in to some of the squares
    * @param c the coordinates for the circle
    * @param r the radius for the outside circle
    * @param color the color of the inside circle
    */
   public Token(Coordinates c, double r, Color color)
   {
         this.c = c;
         this.r = r;
         outside = new CircleBoard(c, r, color.darker());
         inside = new CircleBoard(c, r/2, color);
   }
   /**
    * This method should assign a new SquareBoard array from the Board class so the token knows which moves are possible
    * @param - f the path to take
    */
   public void MovesPossible(SquareBoard[] f)
   {
      moveArray = f;
   }
   /**
    * This method gets the current address of the piece in the array
    * @return the address in the moves possible array
    */
   public int getAdress()
   {
      return adress;
   }
}
