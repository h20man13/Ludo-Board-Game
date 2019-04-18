////////////////////////////////////////////////////////////////////////////////
// File:             CircleBoard.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer, 
// Online sources:   Stack OverFlow - I used this to figure out how to use a pane to display shapes
////////////////////////////////////////////////////////////////////////////////

package gui.shapes;

import javafx.scene.shape.Circle;
import control.Coordinates;
import gui.board.BoardPane;
import javafx.scene.paint.Color;
/**
 * This class is used to create a circle on the initialized pane
 * @author Jacob Bauer
 */
public class CircleBoard
{
   private Circle CC;
   private Coordinates C;
   private double R;
   /**
    * This constructor is used to create a circle on the pane specified with black outline
    * @param C This will specify the coordinates to spawn the Circle
    * @param R - specifies the radius of the circle
    * @param g - specifies the color of the circle
    */
   public CircleBoard(Coordinates C, double R, Color g)
   {
      if(BoardPane.check())
      {
         this.R = R;
         this.C = new Coordinates(C.X(), C.Y());
         CC = new Circle(this.C.X(), this.C.Y(), R);
         CC.setStroke(Color.BLACK);
         CC.setFill(g);
         BoardPane.getPane().getChildren().add(CC);
      }
      else
      {
         System.err.println("Error: Pane has not been selected");
      }
   }
   public void Move(Coordinates c)
   {
      C.change(c.X(), c.Y());
   }
   /**
    * This method receives the coordinates of the specified circle
    * @return the coordinates
    */
   public Coordinates getCoordinates()
   {
      Coordinates c = new Coordinates(C.X(), C.Y());
      return c; 
   }
   /**
    * @return the radius of the circle
    */
   public double getSize()
   {
      return R;
   }
}
