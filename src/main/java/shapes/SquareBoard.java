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
 * 
 */
public class SquareBoard extends BoardPane
{
   private Rectangle r;
   private Coordinates C;
   private double hw;
   public SquareBoard(Coordinates C, double hw, Color v)
   {
      this.hw = hw;
      this.C = new Coordinates(C.X(), C.Y());
      r = new Rectangle(this.C.X(), this.C.Y(), hw, hw);
      r.setStroke(Color.BLACK);
      r.setFill(v);
      getPane().getChildren().add(r);
   }
   public void Move(Coordinates c)
   {
      C.change(c.X(), c.Y());
   }
   public Coordinates getCoordinates()
   {
      return C;
   }
   public double getSize()
   {
      return hw;
   }
}
