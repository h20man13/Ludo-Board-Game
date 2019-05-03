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
import gui.shapes.Token;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
   private static int turn;
   private static double Mousex;
   private static double Mousey;
   private static boolean cont = false;
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
            turn = (int)Save.toDouble(savedata[8]);
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
         Random r = new Random();
         r.nextInt(playerNumber);
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
               System.out.print("What Difficulty[easy/medium/hard]: ");
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
      
      roll.setOnAction(e ->
      {
         roll.isDisabled();
         if(Players[turn].isCPU().equals("yes"))
         {
             int[] in = Players[turn].findpossible();
             Random r = new Random();
             int rr = r.nextInt(in.length);
             int rll = Players[turn].Roll();
             Token f = Players[turn].getTokens()[rr];
             Coordinates original = f.getCoordinates();
             if(f.getPath() == 0)
             {
                if(Players[turn].getColor().equals(Color.RED))
                {
                   f.move(Board.MainPath[42].getCenter());
                   f.setPath(1);
                   f.setCurrentAdress(42);
                }
                else if(Players[turn].getColor().equals(Color.GREEN))
                {
                   f.move(Board.MainPath[3].getCenter());
                   f.setPath(1);
                   f.setCurrentAdress(3);
                }
                else if(Players[turn].getColor().equals(Color.YELLOW))
                {
                   f.move(Board.MainPath[16].getCenter());
                   f.setPath(1);
                   f.setCurrentAdress(16);
                }
                else if(Players[turn].getColor().equals(Color.BLUE))
                {
                   f.move(Board.MainPath[29].getCenter());
                   f.setPath(1);
                   f.setCurrentAdress(29);
                }
             }
             if(f.getPath() == 1)
             {
                boolean done = true;
                for(; rll > 0; rll--)
                {
                   f.setCurrentAdress((f.getCurrentAdress() + 1) % Board.MainPath.length);
                   f.move(Board.MainPath[f.getCurrentAdress()].getCenter());
                   if(Players[turn].getColor().equals(Color.RED) && f.getCurrentAdress() == 40)
                   {
                      f.setCurrentAdress(0);
                      f.setPath(2);
                      done = false;
                      break;
                   }
                   else if(Players[turn].getColor().equals(Color.GREEN) && f.getCurrentAdress() == 1)
                   {
                      f.setCurrentAdress(0);
                      f.setPath(2);
                      done = false;
                      break;
                   }
                   else if(Players[turn].getColor().equals(Color.YELLOW) && f.getCurrentAdress() == 14)
                   {
                      f.setCurrentAdress(0);
                      f.setPath(2);
                      done = false;
                      break;
                   }
                   else if(Players[turn].getColor().equals(Color.BLUE) && f.getCurrentAdress() == 27)
                   {
                      f.setCurrentAdress(0);
                      f.setPath(2);
                      done = false;
                      break;
                   }
                }
                if(done)
                {
                   Token c = playerCheck(f.getCoordinates());
                   if(c != null)
                   {
                      c.move(original);
                   }
                }
             }
             if(f.getPath() == 2 && rll > 0)
             {
               for(; rll > 0; rll--)
               {
                  if(Players[turn].getColor().equals(Color.RED))
                  {
                     f.setCurrentAdress(f.getCurrentAdress() + 1);
                     f.move(Board.finalRed[f.getCurrentAdress()].getCenter());
                  }
                  else if(Players[turn].getColor().equals(Color.GREEN))
                  {
                     f.setCurrentAdress(f.getCurrentAdress() + 1);
                     f.move(Board.finalGreen[f.getCurrentAdress()].getCenter());
                  }
                  else if(Players[turn].getColor().equals(Color.YELLOW))
                  {
                     f.setCurrentAdress(f.getCurrentAdress() + 1);
                     f.move(Board.finalYellow[f.getCurrentAdress()].getCenter());
                  }
                  else if(Players[turn].getColor().equals(Color.BLUE))
                  {
                     f.setCurrentAdress(f.getCurrentAdress() + 1);
                     f.move(Board.finalBlue[f.getCurrentAdress()].getCenter());
                  }
                  if(f.getCurrentAdress() == 5)
                  {
                     f.setPath(3);
                     if(Players[turn].getColor().equals(Color.RED))
                     {
                        f.setCurrentAdress(0);
                        f.move(Board.endingLocations[f.getCurrentAdress()].getCoordinates());
                     }
                     else if(Players[turn].getColor().equals(Color.GREEN))
                     {
                        f.setCurrentAdress(1);
                        f.move(Board.endingLocations[f.getCurrentAdress()].getCoordinates());
                     }
                     else if(Players[turn].getColor().equals(Color.YELLOW))
                     {
                        f.setCurrentAdress(3);
                        f.move(Board.endingLocations[f.getCurrentAdress()].getCoordinates());
                     }
                     else if(Players[turn].getColor().equals(Color.BLUE))
                     {
                        f.setCurrentAdress(2);
                        f.move(Board.endingLocations[f.getCurrentAdress()].getCoordinates());
                     }
                     Scores[turn]++;
                     labels[turn].textProperty().set("Player: " + (turn + 1) + " Score: " + Scores[turn]);
                     if(Scores[turn] == tokens)
                     {
                        System.out.println("Player " + (turn + 1) + " Won the game!!");
                        System.exit(0);
                     }
                     break;
                  }
               }
             }
          }
         turn = (turn + 1) % playerNumber;
      });
      
      Button exit = new Button("Exit Game");
      
      exit.setOnAction(e -> 
      {
         exit.isDisabled();
         stage.close();
         System.out.println("Whould you like to save the file[yes/no]: ");
         //Scanner sd = new Scanner(System.in);
         //String nl = sd.nextLine();
         //sd.close();
         //if(nl.equals("yes"))
         //{
            Save ss = new Save("LudoFile");
            String[] save = new String[9];
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
            save[8] = Save.toString(turn);
            try 
            {
              ss.save(save);
            } 
            catch (FileNotFoundException e1) 
            {
               //do nothing
            }
            System.out.println("Saving Complete");
         //}
        // else
         //{
           // System.exit(0);
        // }
      });        
      
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
   }
   private void mousePressed(MouseEvent e) 
   {
      Mousex = e.getX();
      Mousey = e.getY();
      if(Mousex <= 610 && Mousex >= 10 && Mousey <= 610 && Mousey >= 10)
      {
         cont = true;
      }
   }
   private Token playerCheck(Coordinates c)
   {
      for(int i = 0; i < playerNumber; i++)
      {
         if(i != turn)
         {
            for(int x = 0; x < tokens; x++)
            {
               if(Players[i].getTokens()[x].getCoordinates().X() == c.X() && Players[i].getTokens()[x].getCoordinates().Y() == c.Y())
               {
                  return Players[i].getTokens()[x];
               }
            }
         }
      }
      return null;
   }
}