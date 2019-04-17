////////////////////////////////////////////////////////////////////////////////
// File:             SquareBoard.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package shapes;

import javafx.scene.shape.Rectangle;
import control.Coordinates;
import gui.BoardPane;
import javafx.scene.paint.Color;

/**
 * This class was created to create a square on the pane
 */
public class SquareBoard
{
   private Rectangle r;
   private Coordinates C;
   private double hw;
   /**
    * The constructor constructs the Square
    * @param C the coordinates
    * @param hw the height and width
    * @param v the color
    */
   public SquareBoard(Coordinates C, double hw, Color v)
   {
      this.hw = hw;
      this.C = new Coordinates(C.X(), C.Y());
      r = new Rectangle(this.C.X(), this.C.Y(), hw, hw);
      r.setStroke(Color.BLACK);
      r.setFill(v);
      BoardPane.getPane().getChildren().add(r);
   }
   /**
    * @param c
    */
   public void Move(Coordinates c)
   {
      C.change(c.X(), c.Y());
   }
   /**
    * returns the Coordinates of the upper left corner of the square
    * @return the coordinates of the square
    */
   public Coordinates getCoordinates()
   {
      return C;
   }
   /**
    * 
    * @return The hw of the square
    */
   public double getSize()
   {
      return hw;
   }
}
