////////////////////////////////////////////////////////////////////////////////
// File:             coordinates.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer, Shriyanshi Shikha, Muhammad Zain Bin Ihsan Janjua
////////////////////////////////////////////////////////////////////////////////

package edu.depauw.ludo_board_game.ludo.control;

/**
 * The <code>Coordinates</code> class is used to create 2c plane Coordinates that can be stored in one field. <br>
 * The Coordinates
 * are stored as doubles.
 * @author Jacob Bauer
 */
public class Coordinates
{
   private double x;
   private double y;
   public static void main(String[] args)
   {
      Coordinates f = new Coordinates(0, 0);
      System.out.println("Coordinates are: " + f.X() + ", " +  f.Y());
      f.change(f.Y(), f.X());
      System.out.println("Inverse Coordinates Are " + f.X() + ", " + f.Y());
   }
   /**
    * The constructor of the <code> Coordinates </code> class is used to produce a set of xy Coordinates
    * @param x is an x coordinate
    * @param y is the y coordinate
    */
   public Coordinates(double x, double y)
   {
      this.x = x;
      this.y = y;
   }
   /**
    * The <code> change </code> method is used to define a new set of coordinates for the existing object
    * @param x is the new x coordinate
    * @param y is the new y coordinate
    */
   public void change(double x, double y) 
   {
      this.y = y;
      this.x = x;
   }
   /**
    * The <code> X </code> method is used to return the X field of the Coordinate object
    * @return the X field of the coordinate instance
    */
   public double X()
   {
      return x;
   }
   /**
    * The <code> Y </code> method is used to return the Y field of the Coordinate object
    * @return the Y field of the coordinate instance
    */
   public double Y()
   {
      return y;
   }
}
