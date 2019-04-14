////////////////////////////////////////////////////////////////////////////////
// File:             TriangleBoard.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package shapes;

import control.Coordinates;
import gui.BoardPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import java.lang.String;
/**
 * 
 */
public class TriangleBoard
{
   private Coordinates C;
   private double width;
   private double height;
   private Polygon triangle;
   
   public TriangleBoard(Coordinates C, double width, double height , String direction, Color c)
   {
      this.C = C;
      this.width = width;
      this.height = height;
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
      }
   }
}
