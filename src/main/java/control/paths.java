////////////////////////////////////////////////////////////////////////////////
// File:             paths.java
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
public class paths 
{
   private static Coordinates[] main = new Coordinates[]
   {};
   private static Coordinates[] green = new Coordinates[]
   {};
   private static Coordinates[] red = new Coordinates[]
   {};
   private static Coordinates[] yellow = new Coordinates[]
   {};
   private static Coordinates[] blue = new Coordinates[]
   {};
   public static Coordinates[] setPath(String s)
   {
      if(s.toLowerCase().equals("main"))
      {
         return main;
      }
      else if(s.toLowerCase().equals("green"))
      {
         return green;
      }
      else if(s.toLowerCase().equals("red"))
      {
         return red;
      }
      else if(s.toLowerCase().equals("yellow"))
      {
         return yellow;
      }
      else if(s.toLowerCase().equals("blue"))
      {
         return blue;
      }
      else
      {
         System.err.println("Error: parameter should be main, red, green, yellow, or blue");
         Coordinates[] i = {};
         return i;
      }
   }
}
