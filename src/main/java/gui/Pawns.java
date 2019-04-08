////////////////////////////////////////////////////////////////////////////////
 // File:             Pegs.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package gui;

import javafx.scene.paint.Color;
import control.Coordinates;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
/**
 * 
 */
public class Pawns 
{
   private static Pane p;
   private static boolean check = false;
   private Coordinates[] moveArray;
   private Coordinates c;
   private double r;
   private int adress;
   
   public Pawns(Coordinates f, double r, int adress, Color color)
   {
      if(check) 
      {
         c = new Coordinates(f.X(), f.Y());
         this.r = r;
         Circle co = new Circle(c.X(), c.Y(), r);
         Circle ct = new Circle(c.X(), c.Y(), r / 2);
         ct.setStroke(Color.BLACK);
         co.setStroke(Color.BLACK);
         ct.setFill(color);
         co.setFill(color.brighter());
         this.adress = adress;
         p.getChildren().add(co);
         p.getChildren().add(ct);
      }
      else
      {
         System.err.println("Error: still havent chosen a pane to put the pegs on");
         System.err.println("or you havent set ");
      }
   }
   public void MovesPossible(Coordinates[] f)
   {
      moveArray = f;
   }
   public int getAdress()
   {
      return adress;
   }
   public void movePeg(int rolled)
   {
      int length = moveArray.length;
      for(int i = adress + 1; i < (rolled + adress) % length; i += i % length)
      {
         c.change(moveArray[i].X(), moveArray[i].Y());
      }
   }
   public static void setPane(Pane p)
   {
      Pawns.p = p;
      check = true;
   }
}
