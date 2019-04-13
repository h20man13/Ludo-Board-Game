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
/**
 * 
 */
public class TriangleBoard 
{
   private Coordinates C;
   private double width;
   private double height;
   private Polygon triangle;
   
   public TriangleBoard(Coordinates C, double width, double height)
   {
      this.C = C;
      this.width = width;
      this.height = height;
      triangle = new Polygon();
      triangle.getPoints().setAll
      (
         
      );
   }
}
