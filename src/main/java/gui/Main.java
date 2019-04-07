////////////////////////////////////////////////////////////////////////////////
// File:             Main.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapes.*;
import control.Coordinates;
/**
 * 
 */
public class Main extends Application
{
   public static void main(String[] args) 
   {
      launch(args);
   }

   @Override
   public void start(Stage stage) throws Exception 
   {
      Pane p = new Pane();
      ChoosePane.InitPane(p);
      
      stage.setMaximized(true);
      
      SquareBoard rt = new SquareBoard(new Coordinates(0, 10), 250, Color.RED);
      SquareBoard lt = new SquareBoard(new Coordinates(375, 10), 250, Color.GREEN);
      SquareBoard rb = new SquareBoard(new Coordinates(0, 385), 250, Color.BLUE);
      SquareBoard lb = new SquareBoard(new Coordinates(375, 385), 250, Color.YELLOW);
      //my new classes for creating shapes
      
      Group g = new Group(p);
      
      Scene scene = new Scene(g);

      stage.setScene(scene);
      stage.setTitle("LUDO");
      stage.show();
      
   }
}