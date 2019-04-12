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
import javafx.scene.Group;
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
      BoardPane.InitPane(new Pane());
      
      new Board();
      
      //my new classes for creating shapes
      
      BorderPane g = new BorderPane();
      g.setLeft(BoardPane.getPane());
      
      Scene scene = new Scene(g);

      stage.setScene(scene);
      stage.setTitle("LUDO");
      stage.setMaximized(true);
      stage.show();
      
   }
}