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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
   private static Label[] labels;
   private static int[] Scores;
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
            Scores = new int[playerNumber];
            for(int i = 0; i < playerNumber; i++)
            {
               Scores[i] = (int)Save.toDouble(scores[i]);
            }
            String[] diff = savedata[6].split(" ");
            String[] path = savedata[7].split("-");
            Color[] colors = new Color[playerNumber];
            labels = new Label[playerNumber];
            for(int i = 0; i < playerNumber; i++)
            {
               labels[i] = new Label("Player: " + (i + 1) + " Score: " + Scores[i]);
            }
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
               String[] ppath = path[x].split(" ");
               String[] playerx = PlayersX[x].split(" ");
               String[] playery = PlayersY[x].split(" ");
               Coordinates[] coordinates = new Coordinates[tokens];
               int[] pathcorrect = new int[tokens];
               for(int i = 0; i < tokens; i++)
               {
                  coordinates[i] = new Coordinates(Save.toDouble(playerx[i]), Save.toDouble(playery[i]));
                  pathcorrect[i] = (int)Save.toDouble(ppath[i]);
               }
               Players[x] = new Player(tokens, yorn[x], coordinates, colors[x], new Dice(diff[x]), pathcorrect);
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
         labels = new Label[playerNumber];
         for(int i = 0; i < playerNumber; i++)
         {
            labels[i] = new Label("Player: " + (i + 1) + " Score: " + 0);
         }
         Color[] colors = new Color[playerNumber];
         Players = new Player[playerNumber];
         System.out.print("How many tokens per player: ");
         tokens = (int)Save.toDouble(s.nextLine());
         Coordinates[][] starts = new Coordinates[playerNumber][tokens];
         Scores = new int[playerNumber];
         for(int i = 0; i < playerNumber; i++)
         {
            Scores[i] = 0;
         }
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
            int[] pp = new int[tokens];
            for(int i = 0; i < tokens; i++)
            {
               pp[i] = 0;
            }
            Players[p] = new Player(tokens, yn, starts[p], colors[p], new Dice(dif), pp);
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
      Button roll = new Button("Roll");
      Button exit = new Button("Exit Game");
      VBox v = new VBox();
      v.setPadding(new Insets(10, 10, 10, 10));
      v.setSpacing(10);
      HBox top = new HBox();
      top.setPadding(new Insets(10, 10, 10, 10));
      top.setSpacing(40);
      top.getChildren().add(roll);
      top.getChildren().add(exit);
      HBox medium = new HBox();
      medium.setPadding(new Insets(10, 10, 10, 10));
      medium.setSpacing(10);
      for(int i = 0; i < playerNumber; i++)
      {
         medium.getChildren().add(labels[i]);
      }
      v.getChildren().add(top);
      v.getChildren().add(medium);
      BorderPane g = new BorderPane(); //places pane in boarderPane
      g.setLeft(BoardPane.getPane());
      g.setRight(v);
      Scene scene = new Scene(g);
      stage.setScene(scene); //sets scene as Scene
      stage.setTitle("LUDO"); //title is ludo
      stage.setMaximized(true); //set it to full screen with a window
      stage.show(); //show the stage
      exit.setOnAction(new EventHandler<ActionEvent>() 
      {
         public void handle(ActionEvent e) 
         {
             System.out.println("Whould you like to save the file[yes/no]: ");
             
             Scanner sd = new Scanner(System.in);
             String nl = sd.nextLine();
             sd.close();
             if(nl.equals("yes"))
             {
                Save ss = new Save("LudoFile");
                String[] save = new String[8];
                save[0] = Save.toString((double)playerNumber);
                save[1] = Save.toString((double)tokens);
                save[2] = "";
                for(int i = 0; i < playerNumber - 1; i++)
                {
                   save[2] += Players[i].isCPU() + " ";
                }
                save[2] += Players[playerNumber - 1].isCPU();
                save[3] = "";
                for(int i = 0; i < playerNumber - 1; i++)
                {
                   for(int x = 0; x < tokens - 1; x++)
                   {
                      save[3] += Save.toString(Players[i].getTokens()[x].getCoordinates().X()) + " ";
                   }
                   save[3] += Save.toString(Players[i].getTokens()[tokens - 1].getCoordinates().X()) + "-";
                }
                for(int x = 0; x < tokens - 1; x++)
                {
                   save[3] += Save.toString(Players[playerNumber - 1].getTokens()[x].getCoordinates().X()) + " ";
                }
                save[3] += Save.toString(Players[playerNumber - 1].getTokens()[tokens - 1].getCoordinates().X());
                save[4] = "";
                for(int i = 0; i < playerNumber - 1; i++)
                {
                   for(int x = 0; x < tokens - 1; x++)
                   {
                      save[4] += Save.toString(Players[i].getTokens()[x].getCoordinates().Y()) + " ";
                   }
                   save[4] += Save.toString(Players[i].getTokens()[tokens - 1].getCoordinates().Y()) + "-";
                }
                for(int x = 0; x < tokens - 1; x++)
                {
                   save[4] += Save.toString(Players[playerNumber - 1].getTokens()[x].getCoordinates().Y()) + " ";
                }
                save[4] += Save.toString(Players[playerNumber - 1].getTokens()[tokens - 1].getCoordinates().Y());
                save[5] = "";
                for(int i = 0; i < playerNumber - 1; i++)
                {
                   save[5] += Save.toString((int)Scores[i]) + " ";
                }
                save[5] += Save.toString((int)Scores[playerNumber - 1]);
                save[6] = "";
                for(int i = 0; i < playerNumber - 1; i++)
                {
                   save[6] += Players[i].getDifficulty() + " ";
                }
                save[6] += Players[playerNumber - 1].getDifficulty();
                save[7] = "";
                for(int i = 0; i < playerNumber - 1; i++)
                {
                   for(int x = 0; x < tokens - 1; x++)
                   {
                      save[7] += Save.toString(Players[i].getTokens()[x].getPath()) + " ";
                   }
                   save[7] += Save.toString(Players[i].getTokens()[tokens - 1].getPath()) + "-";
                }
                for(int x = 0; x < tokens - 1; x++)
                {
                   save[7] += Save.toString(Players[playerNumber - 1].getTokens()[x].getPath()) + " ";
                }
                save[7] += Save.toString(Players[playerNumber - 1].getTokens()[tokens - 1].getPath());
                try 
                {
                  ss.save(save);
                } 
                catch (FileNotFoundException e1) 
                {
                   //do nothing
                }
                System.out.println("Saving Complete");
             }
             else
             {
                System.exit(0);
             }
         }
      });
   }
}