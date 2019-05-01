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

import control.*;
import gui.board.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * This is the main class to create all the graphics and run the game
 * @author Jacob Bauer
 */
public class Ludo extends Application
{
   private static int playerNumber;
   private static Player[] Players;
   private static int tokens;
   
   public static void main(String[] args) throws FileNotFoundException 
   {
      boolean ex = Save.exists("LudoFile");
      if(ex)
      {
         Scanner s = new Scanner(System.in);
         System.out.print("There is a save available would you like to resume[Y/N]: ");
         String ss = s.nextLine();
         s.close();
         if(ss.equals("Y"))
         {
            BoardPane.InitPane(new Pane());
            new Board(10, 10, 600);
            s.close();
            Save S = new Save("LudoFile");
            String[] savedata = S.get();
            playerNumber = (int)Save.toDouble(savedata[0]);
            tokens = (int)Save.toDouble(savedata[1]);
            Players = new Player[playerNumber];
            String[] yorn = savedata[2].split(" "); //stats to make players
            String[] PlayersX = savedata[3].split("-");
            String[] PlayersY = savedata[4].split("-");
            String[] scores = savedata[5].split(" ");
            String[] diff = savedata[6].split(" ");
            Color[] colors = new Color[playerNumber];
            if(playerNumber == 2)
            {
               colors[0] = Color.RED;
               colors[1] = Color.YELLOW;
            }
            else if(playerNumber == 3)
            {
               colors[0] = Color.RED;
               colors[1] = Color.GREEN;
               colors[2] = Color.BLUE;
            }
            else if(playerNumber == 4)
            {
               colors[0] = Color.RED;
               colors[1] = Color.GREEN;
               colors[2] = Color.BLUE;
               colors[3] = Color.YELLOW;
            }
            else
            {
               System.exit(0);
            }
            for(int x = 0; x < playerNumber; x++)
            {
               String[] playerx = PlayersX[x].split(" ");
               String[] playery = PlayersY[x].split(" ");
               Coordinates[] coordinates = new Coordinates[tokens];
               for(int i = 0; i < tokens; i++)
               {
                  coordinates[i] = new Coordinates(Save.toDouble(playerx[i]), Save.toDouble(playery[i]));
               }
               Players[x] = new Player((int)Save.toDouble(scores[x]), tokens, yorn[x], coordinates, colors[x], new Dice(diff[x]));
            }
         }
         else
         {
            ex = false;
         }
      }
      if(!ex)
      {
         BoardPane.InitPane(new Pane());
         new Board(10, 10, 600);
         Scanner s = new Scanner(System.in);
         System.out.print("How many players are in this game: ");
         playerNumber = (int)Save.toDouble(s.nextLine());
         Color[] colors = new Color[playerNumber];
         Players = new Player[playerNumber];
         System.out.print("How many tokens per player: ");
         tokens = (int)Save.toDouble(s.nextLine());
         Coordinates[][] starts = new Coordinates[playerNumber][tokens];
         if(playerNumber == 2)
         {
            int start = 0;
            colors[0] = Color.RED;
            for(int i = start; i < start + tokens; i++)
            {
               starts[0][i - start] = Board.StartingLocations[i].getCoordinates();
            }
            colors[1] = Color.YELLOW;
            start = 12;
            for(int i = start; i < start + tokens; i++)
            {
               starts[1][i - start] = Board.StartingLocations[i].getCoordinates();
            }
         }
         else if(playerNumber == 3)
         {
            colors[0] = Color.RED;
            int start = 0;
            for(int i = start; i < start + tokens; i++)
            {
               starts[0][i - start] = Board.StartingLocations[i].getCoordinates();
            }
            colors[1] = Color.GREEN;
            start = 4;
            for(int i = start; i < start + tokens; i++)
            {
               starts[1][i - start] = Board.StartingLocations[i].getCoordinates();
            }
            colors[2] = Color.YELLOW;
            start = 12;
            for(int i = start; i < start + tokens; i++)
            {
               starts[2][i - start] = Board.StartingLocations[i].getCoordinates();
            }
         }
         else if(playerNumber == 4)
         {
            colors[0] = Color.RED;
            int start = 0;
            for(int i = start; i < start + tokens; i++)
            {
               starts[0][i - start] = Board.StartingLocations[i].getCoordinates();
            }
            colors[1] = Color.GREEN;
            start = 4;
            for(int i = start; i < start + tokens; i++)
            {
               starts[1][i - start] = Board.StartingLocations[i].getCoordinates();
            }
            colors[2] = Color.YELLOW;
            start = 12;
            for(int i = start; i < start + tokens; i++)
            {
               starts[2][i - start] = Board.StartingLocations[i].getCoordinates();
            }
            colors[3] = Color.BLUE;
            start = 8;
            for(int i = start; i < start + tokens; i++)
            {
               starts[3][i - start] = Board.StartingLocations[i].getCoordinates();
            }
         }
         for(int p = 0; p < playerNumber; p++)
         {
            System.out.print("Is player " + (p + 1) + " a computer[yes/no]: ");
            String yn = s.nextLine();
            String dif = "medium";
            if(yn.equals("yes"))
            {
               System.out.print("What Difficulty: ");
               dif = s.nextLine();
            }
            Players[p] = new Player(0, tokens, yn, starts[p], colors[p], new Dice(dif));
         }
         s.close();
      }
      launch(args);
   }
   @Override
   public void start(Stage stage) throws Exception 
   {
      //sets pane as the boardpane
      
       //creates board
      
      //my new classes for creating shapes
      VBox v = new VBox();
      HBox top = new HBox();
      HBox bottom = new HBox();
      BorderPane g = new BorderPane(); //places pane in boarderPane
      g.setLeft(BoardPane.getPane());
      g.setRight(v);
      
      Scene scene = new Scene(g);

      stage.setScene(scene); //sets scene as Scene
      stage.setTitle("LUDO"); //title is ludo
      stage.setMaximized(true); //set it to full screen with a window
      stage.show(); //show the stage
      
   }
}