////////////////////////////////////////////////////////////////////////////////
// File:             Board.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package gui;
import shapes.*;
import control.Coordinates;
import javafx.scene.paint.Color;
/**
 * 
 */
public class Board 
{
   private boolean tf = true;
   public Board()
   {
      if(tf)
      {
         SquareBoard rt = new SquareBoard(new Coordinates(10, 10), 250, Color.RED);
         SquareBoard lt = new SquareBoard(new Coordinates(rt.getSize()/3 + rt.getSize() + rt.getCoordinates().X(), rt.getCoordinates().Y()), rt.getSize(), Color.GREEN);
         SquareBoard rb = new SquareBoard(new Coordinates(rt.getSize()/3 + rt.getSize() + rt.getCoordinates().X(), rt.getSize()/3 + rt.getSize() + rt.getCoordinates().Y()), rt.getSize(), Color.YELLOW);
         SquareBoard lb = new SquareBoard(new Coordinates(rt.getCoordinates().X(), rt.getSize()/3 + rt.getSize() + rt.getCoordinates().Y()), rt.getSize(), Color.BLUE);
      
         CircleBoard rtrt = new CircleBoard(new Coordinates(rt.getSize()/3 + rt.getCoordinates().X(), rt.getSize()/3 + rt.getCoordinates().Y()), rt.getSize()/8, Color.WHITE);
         CircleBoard rtlt = new CircleBoard(new Coordinates((rt.getSize() - rt.getSize()/3) + rt.getCoordinates().X(), rt.getSize()/3 + rt.getCoordinates().Y()), rt.getSize()/8, Color.WHITE);
         tf = false;
      }
      else
      {
         System.err.println("Error: You can only spawn one board per project");
      }
   }
}
