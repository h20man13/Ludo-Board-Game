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
   public static CircleBoard[] StartingLocations = new CircleBoard[16];
   private boolean tf = true;
   public Board()
   {
      if(tf)
      {
         MainSquares[0] = new SquareBoard(new Coordinates(10, 10), 250, Color.RED);
         MainSquares[1] = new SquareBoard(new Coordinates(MainSquares[0].getSize()/2 + MainSquares[0].getSize() + MainSquares[0].getCoordinates().X(), MainSquares[0].getCoordinates().Y()), MainSquares[0].getSize(), Color.GREEN);
         MainSquares[2] = new SquareBoard(new Coordinates(MainSquares[0].getSize()/2 + MainSquares[0].getSize() + MainSquares[0].getCoordinates().X(), MainSquares[0].getSize()/2 + MainSquares[0].getSize() + MainSquares[0].getCoordinates().Y()), MainSquares[0].getSize(), Color.YELLOW);
         MainSquares[3] = new SquareBoard(new Coordinates(MainSquares[0].getCoordinates().X(), MainSquares[0].getSize()/2 + MainSquares[0].getSize() + MainSquares[0].getCoordinates().Y()), MainSquares[0].getSize(), Color.BLUE);
         for(int i = 0; i < 16; i += 4)
         {
            StartingLocations[i] = new CircleBoard(new Coordinates(MainSquares[i/4].getSize()/3 + MainSquares[i/4].getCoordinates().X(), MainSquares[i/4].getSize()/3 + MainSquares[i/4].getCoordinates().Y()), MainSquares[i/4].getSize()/9, Color.WHITE);
            StartingLocations[i + 1] = new CircleBoard(new Coordinates((MainSquares[i/4].getSize() - MainSquares[i/4].getSize()/3) + MainSquares[i/4].getCoordinates().X(), MainSquares[i/4].getSize()/3 + MainSquares[i/4].getCoordinates().Y()), MainSquares[i/4].getSize()/9, Color.WHITE);
            StartingLocations[i + 2] = new CircleBoard(new Coordinates(MainSquares[i/4].getSize()/3 + MainSquares[i/4].getCoordinates().X(), MainSquares[i/4].getCoordinates().Y() + MainSquares[i/4].getSize() - MainSquares[i/4].getSize()/3), MainSquares[i/4].getSize()/9, Color.WHITE);
            StartingLocations[i + 3] = new CircleBoard(new Coordinates((MainSquares[i/4].getSize() - MainSquares[i/4].getSize()/3) + MainSquares[i/4].getCoordinates().X(), MainSquares[i/4].getCoordinates().Y() + MainSquares[i/4].getSize() - MainSquares[i/4].getSize()/3), MainSquares[i/4].getSize()/9, Color.WHITE);
         }
         tf = false;
      }
      else
      {
         System.err.println("Error: You can only spawn one board per project");
      }
   }
}
