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
   private static SquareBoard[] MainSquares = new SquareBoard[4];
   private static CircleBoard[] StartingLocations = new CircleBoard[16];
   private static TriangleBoard[] endingLocations = new TriangleBoard[4];
   private boolean tf = true;
   public Board()
   {
      if(tf)
      {
         MainSquares[0] = new SquareBoard(new Coordinates(10, 10), 250, Color.RED);
         MainSquares[1] = new SquareBoard(new Coordinates(MainSquares[0].getSize()/2 + MainSquares[0].getSize() + MainSquares[0].getCoordinates().X(), MainSquares[0].getCoordinates().Y()), MainSquares[0].getSize(), Color.GREEN);
         MainSquares[2] = new SquareBoard(new Coordinates(MainSquares[0].getCoordinates().X(), MainSquares[0].getSize()/2 + MainSquares[0].getSize() + MainSquares[0].getCoordinates().Y()), MainSquares[0].getSize(), Color.BLUE);
         MainSquares[3] = new SquareBoard(new Coordinates(MainSquares[0].getSize()/2 + MainSquares[0].getSize() + MainSquares[0].getCoordinates().X(), MainSquares[0].getSize()/2 + MainSquares[0].getSize() + MainSquares[0].getCoordinates().Y()), MainSquares[0].getSize(), Color.YELLOW);
         for(int i = 0; i < 16; i += 4)
         {
            StartingLocations[i] = new CircleBoard(new Coordinates(MainSquares[i/4].getSize()/3 + MainSquares[i/4].getCoordinates().X(), MainSquares[i/4].getSize()/3 + MainSquares[i/4].getCoordinates().Y()), MainSquares[i/4].getSize()/9, Color.WHITE);
            StartingLocations[i + 1] = new CircleBoard(new Coordinates((MainSquares[i/4].getSize() - MainSquares[i/4].getSize()/3) + MainSquares[i/4].getCoordinates().X(), MainSquares[i/4].getSize()/3 + MainSquares[i/4].getCoordinates().Y()), MainSquares[i/4].getSize()/9, Color.WHITE);
            StartingLocations[i + 2] = new CircleBoard(new Coordinates(MainSquares[i/4].getSize()/3 + MainSquares[i/4].getCoordinates().X(), MainSquares[i/4].getCoordinates().Y() + MainSquares[i/4].getSize() - MainSquares[i/4].getSize()/3), MainSquares[i/4].getSize()/9, Color.WHITE);
            StartingLocations[i + 3] = new CircleBoard(new Coordinates((MainSquares[i/4].getSize() - MainSquares[i/4].getSize()/3) + MainSquares[i/4].getCoordinates().X(), MainSquares[i/4].getCoordinates().Y() + MainSquares[i/4].getSize() - MainSquares[i/4].getSize()/3), MainSquares[i/4].getSize()/9, Color.WHITE);
         }
         endingLocations[0] = new TriangleBoard(new Coordinates(MainSquares[0].getCoordinates().X() + MainSquares[0].getSize(),MainSquares[0].getCoordinates().Y() + MainSquares[0].getSize()/4 + MainSquares[0].getSize()), MainSquares[0].getSize()/2, MainSquares[0].getSize()/4, "right", Color.RED);
         endingLocations[1] = new TriangleBoard(new Coordinates(MainSquares[0].getCoordinates().X() + MainSquares[0].getSize() + MainSquares[0].getSize()/4, MainSquares[0].getCoordinates().Y() + MainSquares[0].getSize()), MainSquares[0].getSize()/2, MainSquares[0].getSize()/4, "down", Color.GREEN);
         endingLocations[2] = new TriangleBoard(new Coordinates(MainSquares[2].getCoordinates().X() + MainSquares[2].getSize() + MainSquares[2].getSize()/4, MainSquares[2].getCoordinates().Y()), MainSquares[2].getSize()/2, MainSquares[2].getSize()/4, "up", Color.BLUE);
         endingLocations[3] = new TriangleBoard(new Coordinates(MainSquares[2].getCoordinates().X() + MainSquares[2].getSize() + MainSquares[2].getSize()/2,MainSquares[2].getCoordinates().Y() - MainSquares[2].getSize()/4), MainSquares[2].getSize()/2, MainSquares[2].getSize()/4, "left", Color.YELLOW); //creates the triangles
         
      }
      else
      {
         System.err.println("Error: You can only spawn one board per project");
      }
   }
}
