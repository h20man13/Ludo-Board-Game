////////////////////////////////////////////////////////////////////////////////
// File:             TriangleBoard.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer
////////////////////////////////////////////////////////////////////////////////

package gui.shapes;

import control.Coordinates;
import gui.board.BoardPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import java.lang.String;
/**
 * Creates a triangle class for the board
 * @author Jacob Bauer
 */
public class TriangleBoard implements ShapesBoard
{
   private Polygon triangle;
   
   /**
    * @Constructor that creates the triangle on the board that is positioned according to the middle of the obtuse side
    * @param C is the coordinates for the triangle
    * @param width is the width of the triangle
    * @param height is the height of the triangle
    * @param the direction the triangle faces up down etc...
    * @param c is the color of the triangle
    */
   public TriangleBoard(Coordinates C, double width, double height , String direction, Color c)
   {
      triangle = new Polygon();
      if(direction.toLowerCase().equals("up"))
      {
         triangle.getPoints().addAll
         (
            C.X(), C.Y(),
            C.X() - width/2, C.Y(),
            C.X(), C.Y() - height,
            C.X() + width/2, C.Y(),
            C.X(), C.Y()
          );
         triangle.setStroke(Color.BLACK);
         triangle.setFill(c);
         BoardPane.getPane().getChildren().add(triangle);
       }
      else if(direction.toLowerCase().equals("down"))
      {
         triangle.getPoints().addAll
         (
            C.X(), C.Y(),
            C.X() - width/2, C.Y(),
            C.X(), C.Y() + height,
            C.X() + width/2, C.Y(),
            C.X(), C.Y()
         );
         triangle.setStroke(Color.BLACK);
         triangle.setFill(c);
         BoardPane.getPane().getChildren().add(triangle);
      }
      else if(direction.toLowerCase().equals("left"))
      {
         triangle.getPoints().addAll
         (
            C.X(), C.Y(),
            C.X(), C.Y() - width/2,
            C.X() - height, C.Y(),
            C.X(), C.Y() + width/2,
            C.X(), C.Y()
         );
         triangle.setStroke(Color.BLACK);
         triangle.setFill(c);
         BoardPane.getPane().getChildren().add(triangle);
      }
      else if(direction.toLowerCase().equals("right"))
      {
         triangle.getPoints().addAll
         (
            C.X(), C.Y(),
            C.X(), C.Y() - width/2,
            C.X() + height, C.Y(),
            C.X(), C.Y() + width/2,
            C.X(), C.Y()
         );
         triangle.setStroke(Color.BLACK);
         triangle.setFill(c);
         BoardPane.getPane().getChildren().add(triangle);
      }
      else
      {
         System.err.println("Couldnt tell what direction you wanted the triangle in");
         System.exit(0);
      }
   }
   public void move(Coordinates c)
   {
      triangle.setTranslateX(c.X() - getCoordinates().X());
      triangle.setTranslateY(c.Y() - getCoordinates().Y());
   }
   public Coordinates getCoordinates()
   {
      return new Coordinates(triangle.getLayoutX(), triangle.getLayoutY());
   }
}
