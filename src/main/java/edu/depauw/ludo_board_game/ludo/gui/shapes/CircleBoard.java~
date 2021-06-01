////////////////////////////////////////////////////////////////////////////////
// File:             CircleBoard.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer, Shriyanshi Shikha, Muhammad Zain Bin Ihsan Janjua
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
public class CircleBoard implements ShapesBoard
{
   private Circle CC;
   private Coordinates to;
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
         to = C;
         CC = new Circle(C.X(), C.Y(), R);
         CC.setStroke(Color.BLACK);
         CC.setFill(g);
         BoardPane.getPane().getChildren().add(CC);
      }
      else
      {
         System.err.println("Error: Pane has not been selected");
         System.exit(0);
      }
   }
   public void Move(Coordinates c)
   {
      CC.setTranslateX(c.X() - CC.getCenterX());
      CC.setTranslateY(c.Y() - CC.getCenterY());
      to = c;
   }
   /**
    * This method receives the coordinates of the specified circle
    * @return the coordinates
    */
   public Coordinates getCoordinates()
   {
     return to;
   }
   /**
    * @return the radius of the circle
    */
   public double getSize()
   {
      return CC.getRadius();
   }
   public Coordinates getCenter()
   {
      return new Coordinates(CC.getCenterX(), CC.getCenterY());
   }
}
