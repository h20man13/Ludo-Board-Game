////////////////////////////////////////////////////////////////////////////////
// File:             Main.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer, Shriyanshi Shikha, Muhammad Zain Bin Ihsan Janjua
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
   private static Label v;
   private static Label rollNumber = new Label("");
   public static void main(String[] args) throws FileNotFoundException 
   {
      boolean ex = Save.exists("LudoFile");
      if(ex)
      {
         System.out.print("There is a save available would you like to resume[Y/N]: ");
         Scanner myscann = new Scanner(System.in);
         String ss = myscann.nextLine();
         myscann.close();
         Save S = new Save("LudoFile");
         String[] savedata = S.get();
         if(ss.equals("Y"))
         {
            BoardPane.InitPane(new Pane());
            new Board(10, 10, 600);
            playerNumber = (int)Save.toDouble(savedata[0]);
            tokens = (int)Save.toDouble(savedata[1]);
            Players = new Player[playerNumber];
            Coordinates[][] starts = new Coordinates[playerNumber][tokens];
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
            String[] adres = savedata[9].split("-");
            v = new Label("Player " + (turn + 1) + "'s turn");
            Color[] colors = new Color[playerNumber];
            labels = new Label[playerNumber];
            for(int i = 0; i < playerNumber; i++)
            {
               labels[i] = new Label("Player: " + (i + 1) + " Score: " + Scores[i]);
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
            else
            {
               System.err.println("Error: too many players");
               System.exit(0);
            }
            for(int x = 0; x < playerNumber; x++)
            {
               String[] ppath = path[x].split(" ");
               String[] playerx = PlayersX[x].split(" ");
               String[] playery = PlayersY[x].split(" ");
               String[] spladr = adres[x].split(" ");
               Coordinates[] coordinates = new Coordinates[tokens];
               int[] pathcorrect = new int[tokens];
               for(int i = 0; i < tokens; i++)
               {
                  coordinates[i] = new Coordinates(Save.toDouble(playerx[i]), Save.toDouble(playery[i]));
                  pathcorrect[i] = (int)Save.toDouble(ppath[i]);
               }
               Players[x] = new Player(tokens, yorn[x], starts[x], colors[x], new Dice(diff[x]), pathcorrect);
               for(int y = 0; y < tokens; y++)
               {
                     Players[x].getTokens()[y].move(coordinates[y]);
                     Players[x].getTokens()[y].setCurrentAdress((int)Save.toDouble(spladr[y]));
               }
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
         System.out.print("How many players are in this game: ");
         Scanner sndScanner = new Scanner(System.in);
         playerNumber = (int)Save.toDouble(sndScanner.nextLine());
         labels = new Label[playerNumber];
         for(int i = 0; i < playerNumber; i++)
         {
            labels[i] = new Label("Player: " + (i + 1) + " Score: " + 0);
         }
         Color[] colors = new Color[playerNumber];
         Players = new Player[playerNumber];
         System.out.print("How many tokens per player: ");
         tokens = (int)Save.toDouble(sndScanner.nextLine());
         Random r  = new Random();
         turn = r.nextInt(playerNumber);
         v = new Label("Player " + (turn + 1) + "'s turn");
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
            String yn = sndScanner.nextLine();
            String dif = "medium";
            if(yn.equals("yes"))
            {
               System.out.print("What Difficulty[easy/medium/hard]: ");
               dif = sndScanner.nextLine();
            }
            int[] pp = new int[tokens];
            for(int i = 0; i < tokens; i++)
            {
               pp[i] = 0;
            }
            Players[p] = new Player(tokens, yn, starts[p], colors[p], new Dice(dif), pp);
         }
         sndScanner.close();
      }
      rollNumber.textProperty().set("Player " + (turn + 1) + "'s roll: ");
      launch(args);
   }
   @Override
   public void start(Stage stage) throws Exception 
   {
      //sets pane as the boardpane
      
      //my new classes for creating shapes
      Button roll = new Button("Roll");
      
      roll.setOnAction(e ->
      {
         roll.isDisabled();
         rollNumber.textProperty().set("Player " + (turn + 1) + "'s roll: ");
         if(Players[turn].isCPU().equals("yes"))
         {
             int[] in = Players[turn].findpossible();
             Random r = new Random();
             int rr = in[r.nextInt(in.length)];
             int rll = Players[turn].Roll();
             rollNumber.textProperty().set("Player " + (turn + 1) + "'s roll: " + rll);
             Token f = Players[turn].getTokens()[rr];
             //Coordinates original = f.getCoordinates();
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
                      c.move(c.getHome());
                      c.setPath(0);
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
                  }
                  else if(Players[turn].getColor().equals(Color.GREEN))
                  {
                     f.setCurrentAdress(f.getCurrentAdress() + 1);
                  }
                  else if(Players[turn].getColor().equals(Color.YELLOW))
                  {
                     f.setCurrentAdress(f.getCurrentAdress() + 1);
                  }
                  else if(Players[turn].getColor().equals(Color.BLUE))
                  {
                     f.setCurrentAdress(f.getCurrentAdress() + 1);
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
                  if(Players[turn].getColor().equals(Color.RED))
                  {
                     f.move(Board.finalRed[f.getCurrentAdress()].getCenter());
                  }
                  else if(Players[turn].getColor().equals(Color.GREEN))
                  {
                     f.move(Board.finalGreen[f.getCurrentAdress()].getCenter());
                  }
                  else if(Players[turn].getColor().equals(Color.YELLOW))
                  {
                     f.move(Board.finalYellow[f.getCurrentAdress()].getCenter());
                  }
                  else if(Players[turn].getColor().equals(Color.BLUE))
                  {
                     f.move(Board.finalBlue[f.getCurrentAdress()].getCenter());
                  }
               }
             }
             turn = (turn + 1) % playerNumber;
             v.textProperty().set("Player " + (turn + 1) + "'s turn");
          }
         else if(cont)
         {
            int[] in = Players[turn].findpossible();
            int rr = in[Players[turn].findClosest(new Coordinates(Mousex, Mousey))];
            if(checkInArray(in, rr))
            {
               int rll = Players[turn].Roll();
               rollNumber.textProperty().set("Player " + (turn + 1) + "'s roll: " + rll);
               Token f = Players[turn].getTokens()[rr];
               //Coordinates original = f.getCoordinates();
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
                        c.move(c.getHome());
                        c.setPath(0);
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
                    }
                    else if(Players[turn].getColor().equals(Color.GREEN))
                    {
                       f.setCurrentAdress(f.getCurrentAdress() + 1);
                    }
                    else if(Players[turn].getColor().equals(Color.YELLOW))
                    {
                       f.setCurrentAdress(f.getCurrentAdress() + 1);
                    }
                    else if(Players[turn].getColor().equals(Color.BLUE))
                    {
                       f.setCurrentAdress(f.getCurrentAdress() + 1);
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
                       if(Scores[turn] == tokens)
                       {
                          System.out.println("Player " + (turn + 1) + " Won the game!!");
                          System.exit(0);
                       }
                       break;
                    }
                    if(Players[turn].getColor().equals(Color.RED))
                    {
                       f.move(Board.finalRed[f.getCurrentAdress()].getCenter());
                    }
                    else if(Players[turn].getColor().equals(Color.GREEN))
                    {
                       f.move(Board.finalGreen[f.getCurrentAdress()].getCenter());
                    }
                    else if(Players[turn].getColor().equals(Color.YELLOW))
                    {
                       f.move(Board.finalYellow[f.getCurrentAdress()].getCenter());
                    }
                    else if(Players[turn].getColor().equals(Color.BLUE))
                    {
                       f.move(Board.finalBlue[f.getCurrentAdress()].getCenter());
                    }
                 }
               }
            }
            cont = false;
            turn = (turn + 1) % playerNumber;
            v.textProperty().set("Player " + (turn + 1) + "'s turn");
         }
      });
      
      Button exit = new Button("Exit Game");
      
      exit.setOnAction(e -> 
      {
         exit.isDisabled();
         stage.close();
         //Scanner sd = new Scanner(System.in);
         //String nl = sd.nextLine();
         //sd.close();
         //if(nl.equals("yes"))
         //{
            Save ss = new Save("LudoFile");
            String[] save = new String[10];
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
            save[9] = "";
            for(int i = 0; i < playerNumber - 1; i++)
            {
               for(int x = 0; x < tokens - 1; x++)
               {
                  save[9] += Save.toString(Players[i].getTokens()[x].getCurrentAdress()) + " ";
               }
               save[9] += Save.toString(Players[i].getTokens()[tokens - 1].getCurrentAdress()) + "-";
            }
            for(int x = 0; x < tokens - 1; x++)
            {
               save[9] += Save.toString(Players[playerNumber - 1].getTokens()[x].getCurrentAdress()) + " ";
            }
            save[9] += Save.toString(Players[playerNumber - 1].getTokens()[tokens - 1].getCurrentAdress());
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
      BoardPane.getPane().setOnMouseClicked(e -> mousePressed(e));
      VBox g = new VBox();
      g.setPadding(new Insets(10, 10, 10, 10));
      g.setSpacing(10);
      HBox top = new HBox();
      top.setPadding(new Insets(10, 10, 10, 10));
      top.setSpacing(40);
      top.getChildren().add(roll);
      top.getChildren().add(exit);
      HBox medium = new HBox();
      medium.setPadding(new Insets(10, 10, 10, 10));
      medium.setSpacing(10);
      medium.getChildren().add(v);
      medium.getChildren().add(rollNumber);
      for(int i = 0; i < playerNumber; i++)
      {
         medium.getChildren().add(labels[i]);
      }
      g.getChildren().add(top);
      g.getChildren().add(medium);
      BorderPane k = new BorderPane(); //places pane in boarderPane
      k.setLeft(BoardPane.getPane());
      k.setRight(g);
      Scene scene = new Scene(k);
      stage.setScene(scene); //sets scene as Scene
      stage.setTitle("LUDO"); //title is ludo
      stage.setFullScreen(true); //set it to full screen with a window
      stage.show(); //show the stage
   }
   private void mousePressed(MouseEvent e) 
   {
      Mousex = e.getX();
      Mousey = e.getY();
      cont = true;
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
   private boolean checkInArray(int[] x, int v)
   {
      for(int i = 0; i < x.length; i++)
      {
         if(v == x[i])
         {
            return true;
         }
      }
      return false;
   }
}