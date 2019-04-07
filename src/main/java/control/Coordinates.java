////////////////////////////////////////////////////////////////////////////////
// File:             coordinates.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package control;

/**
 * 
 */
public class Coordinates 
{
   private double x;
   private double y;
   
   public Coordinates(double x, double y)
   {
      this.x = x;
      this.y = y;
   }
   
   public void change(double x, double y)
   {
      this.y = y;
      this.x = x;
   }
   
   public double X()
   {
      return x;
   }
   public double Y()
   {
      return y;
   }
}
