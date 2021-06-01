////////////////////////////////////////////////////////////////////////////////
// File:             Save.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer, Shriyanshi Shikha, Muhammad Zain Bin Ihsan Janjua
////////////////////////////////////////////////////////////////////////////////

package edu.depauw.ludo_board_game.ludo.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * This class was designed to create a save file.<br> The user uses the constructor to create the file based off of the name given<br>
 * Then the save method is used to convert a String array into the save format. Each cell in the array is a line on the file.
 * Then the get method is used to retrieve the data back into an String array. I also included a method to check if the file is empty
 * and a method to change a string of numerical values into an int. 
 */
public class Save // the file format is as followed the first line printed in to the file is how many lines need to be scanned from the file          
{                 // the other lines are the data saved to the file
   private File f;
   public static void main(String[] args) throws FileNotFoundException //main method to 
   {
      System.out.println(toDouble("123456.88"));
      System.out.println(toDouble("2") + toDouble(".333333"));
      //should print out the same thing inputed
      Save s = new Save("testSave.txt");
      String[] t = new String[]{"Line 1","Line 2"};
      /* 
       * now the file should appear like this
       * Line 1
       * Line 2
       */
      s.save(t);
      /*
      String[] c = s.get("testSave.txt"); //note save test is another file 
      for(int i = 0; i < c.length; i++)
      {
         System.out.println(c[i]); //should match what is i the file however the file should be deleted after get is used
      }
      */
      System.out.println(exists("testSave.txt"));//try to see if there is a save available
      //there should be a save available under this name because lines 37 - 41 were commented out
      //if you uncomment them the get method will delete the file at the end
      System.out.print(toString(124345.9845));
   }
   public Save(String filename)
   {
      f = new File(filename);
   }
   public void save(String[] saveData) throws FileNotFoundException
   {
      PrintWriter pw = new PrintWriter(f);
      int size = saveData.length; //create printer to store data
      pw.println(toString(size));
      for(int i = 0; i < size; i++)
      {
         pw.println(saveData[i]);
      }
      pw.close();
   }
   /**
    * The get method is used in order to retrieve a save state from a particular file
    * @param fName
    * @return gets a save state and returns it in the form it was entered a String[](each line is its own element>
    * @throws FileNotFoundException
    */
   public String[] get() throws FileNotFoundException
   {
         Scanner sc = new Scanner(f); //create scanner
         int lines = (int)toDouble(sc.nextLine()); //scan line 1 representing the number of lines that need to be scanned
         String[] l = new String[lines]; //create array the size of the first line entered into the file
         for(int i = 0; i < lines; i++)
         {
            l[i] = sc.nextLine();
         }
         sc.close();
         f.delete(); //delete file after it is used
         return l;
   }
   /**
    * This method checks if the file exists
    * @param filename which is the name of the file name in the form of a string
    * @return whether the file exists
    */
   public static boolean exists(String filename) //check if the file exists
   {
      File a = new File(filename);
      return a.exists();
   }
   /**
    * Turns a string of numbers into a int
    * @param s is a string input
    * @return a double representation of a string
    */
   public static double toDouble(String s)
   {
      int tenvar = 1;
      int length = s.length() - 1;
      double awnser = 0;
      for(int i = length; i >= 0; i--)
      {
         if(s.charAt(i) == '.')
         {
            awnser /= tenvar;
            tenvar = 1;
         }
         else
         {
            awnser += (((int)s.charAt(i)) - (int)'0') * tenvar;
            tenvar *= 10;
         }
      }
      return awnser;
   }
   /**
    * Returns a String representation of a double good for inserting strings into arrays
    * @param I a double input
    * @return String that is a representation of a double
    */
   public static String toString(double I) //converts a double to a string
   {
      return "" + I;
   }
}
