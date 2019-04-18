////////////////////////////////////////////////////////////////////////////////
// File:             Board.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer, 
////////////////////////////////////////////////////////////////////////////////

package gui.board;
import control.Coordinates;
import javafx.scene.paint.Color;
import gui.shapes.CircleBoard;
import gui.shapes.SquareBoard;
import gui.shapes.TriangleBoard;
/**
 * This class was developed to extract away from the Ludo.java <br>File in order to just handle the static objects that dont require event listiners...
 * The board class also allows the tokens to access the sqare positions on the boards
 */
public class Board 
{
   private static SquareBoard[] MainSquares = new SquareBoard[4];
   private static CircleBoard[] StartingLocations = new CircleBoard[16];
   private static TriangleBoard[] endingLocations = new TriangleBoard[4];
   private static SquareBoard[] MainPath = new SquareBoard[52];
   private static SquareBoard[] finalRed = new SquareBoard[5];
   private static SquareBoard[] finalGreen = new SquareBoard[5];
   private static SquareBoard[] finalBlue = new SquareBoard[5];
   private static SquareBoard[] finalYellow = new SquareBoard[5];
   private boolean tf = true;
   public Board(double offsetx, double offsety, double size)
   {
      if(tf)
      {
         MainSquares[0] = new SquareBoard(new Coordinates(offsetx, offsety), size * 2 / 5, Color.RED);
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
         
         genSpaces(new Coordinates(MainSquares[0].getCoordinates().X() + MainSquares[0].getSize(), MainSquares[0].getCoordinates().Y()), 3, MainPath, 0, "right", Color.WHITE);
         MainPath[3] = new SquareBoard(new Coordinates(MainPath[2].getCoordinates().X(), MainPath[2].getCoordinates().Y() + MainPath[2].getSize()), MainPath[2].getSize(), Color.GREEN);
         genSpaces(new Coordinates(MainPath[3].getCoordinates().X(), MainPath[3].getCoordinates().Y() + MainPath[3].getSize()), 4, MainPath, 4, "down", Color.WHITE);
         genSpaces(new Coordinates(MainSquares[1].getCoordinates().X(), MainSquares[1].getCoordinates().Y() + MainSquares[1].getSize()), 6, MainPath, 8, "right", Color.WHITE);
         genSpaces(new Coordinates(MainPath[13].getCoordinates().X(), MainPath[13].getCoordinates().Y() + MainPath[13].getSize()), 2, MainPath, 14, "down", Color.WHITE);
         MainPath[16] = new SquareBoard(new Coordinates(MainPath[15].getCoordinates().X() - MainPath[15].getSize(), MainPath[15].getCoordinates().Y()), MainPath[2].getSize(), Color.YELLOW);
         genSpaces(new Coordinates(MainPath[16].getCoordinates().X() - MainPath[16].getSize(), MainPath[16].getCoordinates().Y()), 4, MainPath, 17 , "left", Color.WHITE);
         genSpaces(new Coordinates(MainSquares[3].getCoordinates().X() - MainPath[3].getSize(), MainSquares[3].getCoordinates().Y()), 6, MainPath, 21, "down", Color.WHITE);
         genSpaces(new Coordinates(MainPath[26].getCoordinates().X() - MainPath[26].getSize(), MainPath[26].getCoordinates().Y()), 2, MainPath, 27, "left", Color.WHITE);
         MainPath[29] = new SquareBoard(new Coordinates(MainPath[28].getCoordinates().X(), MainPath[28].getCoordinates().Y() - MainPath[28].getSize()), MainPath[28].getSize(), Color.BLUE);
         genSpaces(new Coordinates(MainPath[29].getCoordinates().X(), MainPath[29].getCoordinates().Y() - MainPath[29].getSize()), 4, MainPath, 30, "up", Color.WHITE);
         genSpaces(new Coordinates(MainSquares[2].getCoordinates().X() + MainSquares[2].getSize() - MainPath[33].getSize(), MainSquares[2].getCoordinates().Y() - MainPath[33].getSize()), 6, MainPath, 34, "left", Color.WHITE);
         genSpaces(new Coordinates(MainPath[39].getCoordinates().X(), MainPath[39].getCoordinates().Y() - MainPath[39].getSize()), 2, MainPath, 40, "up", Color.WHITE);
         MainPath[42] = new SquareBoard(new Coordinates(MainPath[41].getCoordinates().X() + MainPath[41].getSize(), MainPath[41].getCoordinates().Y()), MainPath[41].getSize(), Color.RED);
         genSpaces(new Coordinates(MainPath[42].getCoordinates().X() + MainPath[42].getSize(), MainPath[42].getCoordinates().Y()), 4, MainPath, 43, "right", Color.WHITE);
         genSpaces(new Coordinates(MainSquares[0].getCoordinates().X() + MainSquares[0].getSize(), MainSquares[0].getCoordinates().Y() + MainSquares[0].getSize() - MainPath[46].getSize()), 5, MainPath, 47, "up", Color.WHITE);
         
         genSpaces(new Coordinates(MainPath[1].getCoordinates().X(), MainPath[1].getCoordinates().Y() + MainPath[1].getSize()), 5, finalGreen, 0, "down", Color.GREEN);
         genSpaces(new Coordinates(MainPath[14].getCoordinates().X() - MainPath[14].getSize(), MainPath[14].getCoordinates().Y()), 5, finalYellow, 0, "left", Color.YELLOW);
         genSpaces(new Coordinates(MainPath[27].getCoordinates().X(), MainPath[27].getCoordinates().Y() - MainPath[27].getSize()), 5, finalBlue, 0, "up", Color.BLUE);
         genSpaces(new Coordinates(MainPath[40].getCoordinates().X() + MainPath[40].getSize(), MainPath[40].getCoordinates().Y()), 5, finalRed, 0, "right", Color.RED);
         
         
      }
      else
      {
         System.err.println("Error: You can only spawn one board per project");
      }
   }
   /**
    * This method was created to help make some of the small squares essentially it could make a certain amount of squares in one direction and it could add them to a path
    * @param start - is the initial coordinates of the first square
    * @param howmany - is how many squares you want to create
    * @param Array - what array do you want to add the squares too
    * @param begin - what position in the array do you want to start creating squares
    * @param direct - what direction do you want to start replicating squares ("up" "down" "left" "right")
    * @param color - what color do you want the squares to be
    */
   private void genSpaces(Coordinates start, int howmany, SquareBoard[] Array, int begin, String direct, Color color)
   {
      for(int i = 0; i < howmany; i++, begin++)
      {
         Array[begin] = new SquareBoard(start, MainSquares[3].getSize()/6, color);
         if(direct.toLowerCase().equals("up"))
         {
            start.change(start.X(), start.Y() - MainSquares[3].getSize()/6);
         }
         else if(direct.toLowerCase().equals("down"))
         {
            start.change(start.X(), start.Y() + MainSquares[3].getSize()/6);
         }
         else if(direct.toLowerCase().equals("left"))
         {
            start.change(start.X() - MainSquares[3].getSize()/6, start.Y());
         }
         else if(direct.toLowerCase().equals("right"))
         {
            start.change(start.X() + MainSquares[3].getSize()/6, start.Y());
         }
         else
         {
            System.err.println("Error: direct not specified correctly it must me: up, down, left, or right");
            break;
         }
      }
   }
}
