////////////////////////////////////////////////////////////////////////////////
// File:             Main.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * 
 */
public class Ludo extends Application
{
   public static void main(String[] args) 
   {
      launch(args);
   }

   @Override
   public void start(Stage stage) throws Exception 
   {
      BoardPane.InitPane(new Pane()); //sets pane as the boardpane
      
      new Board(10, 10, 600); //creates board
      
      //my new classes for creating shapes
      
      BorderPane g = new BorderPane(); //places pane in boarderPane
      g.setLeft(BoardPane.getPane());
      
      Scene scene = new Scene(g);

      stage.setScene(scene); //sets scene as Scene
      stage.setTitle("LUDO"); //title is ludo
      stage.setMaximized(true); //set it to full screen with a window
      stage.show(); //show the stage
      
   }
}