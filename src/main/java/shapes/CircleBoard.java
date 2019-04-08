////////////////////////////////////////////////////////////////////////////////
// File:             CircleBoard.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package shapes;

import javafx.scene.shape.Circle;
import control.Coordinates;
import gui.ChoosePane;
import javafx.scene.paint.Color;
/**
 * 
 */
public class CircleBoard extends ChoosePane
{
   private Circle CC;
   private Coordinates C;
   private double R;
   public CircleBoard(Coordinates C, double R, Color g)
   {
      if(check())
      {
         this.R = R;
         this.C = new Coordinates(C.X() - R, C.Y() - R);
         CC = new Circle(this.C.X(), this.C.Y(), R);
         CC.setStroke(Color.BLACK);
         CC.setFill(g);
         getPane().getChildren().add(CC);
      }
      else
      {
         System.err.println("Error: Pane has not been selected");
      }
   }
   public void Move(Coordinates c)
   {
      C.change(c.X() - R, c.Y() - R);
   }
   public Coordinates getCoordinates()
   {
      Coordinates c = new Coordinates(C.X() + R, C.Y() + R);
      return c; 
   }
   public double getSize()
   {
      return R;
   }
}
