////////////////////////////////////////////////////////////////////////////////
 // File:            Pegs.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer
////////////////////////////////////////////////////////////////////////////////

package gui.shapes;

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
   private int getPath;
   public int adress;
   /**
    * The constructor is defined so it creates a token which has two circles an outside circle and an inside circle <br>
    * the outside circle is darker so it doesn't blend in to some of the squares
    * @param c the coordinates for the circle
    * @param r the radius for the outside circle
    * @param color the color of the inside circle
    */
   public Token(Coordinates c, double r, Color color, int path)
   {
         outside = new CircleBoard(c, r, color.darker());
         inside = new CircleBoard(c, r/2, color);
         getPath = path;
   }
   /**
    * This method should assign a new SquareBoard array from the Board class so the token knows which moves are possible
    * @param - f the path to take
    */
   
   /**
    * This method gets the current address of the piece in the array
    * @return the address in the moves possible array
    */
   public int getCurrentAdress()
   {
      return adress;
   }
   public void setCurrentAdress(int a)
   {
      adress = a;
   }
   public void move(Coordinates c)
   {
     outside.Move(c);
     inside.Move(c);
   }
   public double getSize()
   {
      return outside.getSize();
   }
   public Coordinates getCoordinates()
   {
      return inside.getCoordinates();
   }
   public int getPath()
   {
      return getPath;
   }
   public void setPath(int x)
   {
      getPath = x;
   }
   public Coordinates getHome()
   {
      return inside.getCenter();
   }
}
