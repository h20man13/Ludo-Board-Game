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

package GUI;

import javafx.scene.canvas.GraphicsContext;
/**
 * 
 */
public class Pegs 
{
   private double[] moveArray;
   private GraphicsContext G;
   private double x;
   private double y;
   private double w;
   private double h;
   private int adress;
   
   public Pegs(GraphicsContext G, double x, double y, double w, double h)
   {
      this.G= G;
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      adress = -1;
   }
   public void setAdress(int I)
   {
      adress = I;
   }
   public int getAdress()
   {
      return adress;
   }
   public void movePeg()
   {
      
   }
}
