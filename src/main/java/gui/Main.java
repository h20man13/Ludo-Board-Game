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
      shapes.ChoosePane.InitPane(p);
      
      stage.setMaximized(true);
      /*
      Rectangle rt = new Rectangle(0, 10, 250, 250);
      rt.setStroke(Color.BLACK);
      rt.setFill(Color.RED);
      
      Rectangle lt = new Rectangle(375, 10, 250, 250);
      lt.setStroke(Color.BLACK);
      lt.setFill(Color.GREEN);
      
      Rectangle rb = new Rectangle(0, 385, 250, 250);
      rb.setStroke(Color.BLACK);
      rb.setFill(Color.BLUE);
      
      Rectangle lb = new Rectangle(375, 385, 250, 250);
      lb.setStroke(Color.BLACK);
      lb.setFill(Color.YELLOW);
      
      p.getChildren().add(rt);
      p.getChildren().add(lt);
      p.getChildren().add(rb);
      p.getChildren().add(lb);
      */
      
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