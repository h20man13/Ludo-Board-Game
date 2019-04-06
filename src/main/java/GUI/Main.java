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

package GUI;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
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
      stage.setMaximized(true);
      
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
       
      Group g = new Group(p);
      
      Scene scene = new Scene(g);

      stage.setScene(scene);
      stage.setTitle("LUDO");
      stage.show();
   }
}