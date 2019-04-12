////////////////////////////////////////////////////////////////////////////////
// File:             ChoosePane.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package gui;
import javafx.scene.layout.Pane;
/**
 * 
 */
public class BoardPane 
{
   private static Pane p = new Pane();
   private static boolean check = false;
   public static Pane getPane()
   {
      if(check)
      {
         return p;
      }
      else
      {
         System.err.println("Error: Pane has not been selected");
         return p;
      }
   }
   public static boolean check()
   {
      return check;
   }
   public static void InitPane(Pane p)
   {
      if(!check)
      {
         BoardPane.p = p;
         check = true;
      }
      else
      {
         System.err.println("Error: you can only initialize Panes once");
      }
   }
}
