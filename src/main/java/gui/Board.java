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
         SquareBoard lt = new SquareBoard(new Coordinates(10, 10), 250, Color.RED);
         SquareBoard rt = new SquareBoard(new Coordinates(lt.getSize()/3 + lt.getSize() + lt.getCoordinates().X(), lt.getCoordinates().Y()), lt.getSize(), Color.GREEN);
         SquareBoard rb = new SquareBoard(new Coordinates(lt.getSize()/3 + lt.getSize() + lt.getCoordinates().X(), lt.getSize()/3 + lt.getSize() + lt.getCoordinates().Y()), lt.getSize(), Color.YELLOW);
         SquareBoard lb = new SquareBoard(new Coordinates(lt.getCoordinates().X(), lt.getSize()/3 + lt.getSize() + lt.getCoordinates().Y()), lt.getSize(), Color.BLUE);
      
         CircleBoard ltrt = new CircleBoard(new Coordinates(lt.getSize()/3 + lt.getCoordinates().X(), lt.getSize()/3 + lt.getCoordinates().Y()), lt.getSize()/9, Color.WHITE);
         CircleBoard ltlt = new CircleBoard(new Coordinates((lt.getSize() - lt.getSize()/3) + lt.getCoordinates().X(), lt.getSize()/3 + lt.getCoordinates().Y()), lt.getSize()/9, Color.WHITE);
         CircleBoard ltrb = new CircleBoard(new Coordinates(lt.getSize()/3 + lt.getCoordinates().X(), lt.getCoordinates().Y() + lt.getSize() - lt.getSize()/3), lt.getSize()/9, Color.WHITE);
         CircleBoard ltlb = new CircleBoard(new Coordinates((lt.getSize() - lt.getSize()/3) + lt.getCoordinates().X(), lt.getCoordinates().Y() + lt.getSize() - lt.getSize()/3), lt.getSize()/9, Color.WHITE);
         
         CircleBoard rtrt = new CircleBoard(new Coordinates(rt.getSize()/3 + rt.getCoordinates().X(), rt.getSize()/3 + rt.getCoordinates().Y()), rt.getSize()/9, Color.WHITE);
         CircleBoard rtlt = new CircleBoard(new Coordinates((rt.getSize() - rt.getSize()/3) + rt.getCoordinates().X(), rt.getSize()/3 + rt.getCoordinates().Y()), rt.getSize()/9, Color.WHITE);
         CircleBoard rtrb = new CircleBoard(new Coordinates(rt.getSize()/3 + rt.getCoordinates().X(), rt.getCoordinates().Y() + rt.getSize() - rt.getSize()/3), rt.getSize()/9, Color.WHITE);
         CircleBoard rtlb = new CircleBoard(new Coordinates((rt.getSize() - rt.getSize()/3) + rt.getCoordinates().X(), rt.getCoordinates().Y() + rt.getSize() - rt.getSize()/3), rt.getSize()/9, Color.WHITE);
         
         CircleBoard lbrt = new CircleBoard(new Coordinates(lb.getSize()/3 + lb.getCoordinates().X(), lb.getSize()/3 + lb.getCoordinates().Y()), lb.getSize()/9, Color.WHITE);
         CircleBoard lblt = new CircleBoard(new Coordinates((lb.getSize() - lb.getSize()/3) + lb.getCoordinates().X(), lb.getSize()/3 + lb.getCoordinates().Y()), lb.getSize()/9, Color.WHITE);
         CircleBoard lbrb = new CircleBoard(new Coordinates(lb.getSize()/3 + lb.getCoordinates().X(), lb.getCoordinates().Y() + lb.getSize() - lb.getSize()/3), lb.getSize()/9, Color.WHITE);
         CircleBoard lblb = new CircleBoard(new Coordinates((lb.getSize() - lb.getSize()/3) + lb.getCoordinates().X(), lb.getCoordinates().Y() + lb.getSize() - lb.getSize()/3), lb.getSize()/9, Color.WHITE);
         
         CircleBoard rbrt = new CircleBoard(new Coordinates(rb.getSize()/3 + rb.getCoordinates().X(), rb.getSize()/3 + rb.getCoordinates().Y()), rb.getSize()/9, Color.WHITE);
         CircleBoard rblt = new CircleBoard(new Coordinates((rb.getSize() - rb.getSize()/3) + rb.getCoordinates().X(), rb.getSize()/3 + rb.getCoordinates().Y()), rb.getSize()/9, Color.WHITE);
         CircleBoard rbrb = new CircleBoard(new Coordinates(rb.getSize()/3 + rb.getCoordinates().X(), rb.getCoordinates().Y() + rb.getSize() - rb.getSize()/3), rb.getSize()/9, Color.WHITE);
         CircleBoard rblb = new CircleBoard(new Coordinates((rb.getSize() - rb.getSize()/3) + rb.getCoordinates().X(), rb.getCoordinates().Y() + rb.getSize() - rb.getSize()/3), rb.getSize()/9, Color.WHITE);
         tf = false;
      }
      else
      {
         System.err.println("Error: You can only spawn one board per project");
      }
   }
}
