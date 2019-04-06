////////////////////////////////////////////////////////////////////////////////
// File:             Save.java
// Course:           CSC232B, Spring 2019
// Authors:          Jacob Bauer
////////////////////////////////////////////////////////////////////////////////

package Control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.StringBuilder;
/**
 * This class was designed to create a save file The user uses the constructor to create the file based off of the name given
 * Then the save method is used to convert a String array into the save format. Each cell in the array is a line on the file.
 * Then the get method is used to retrieve the data back into an String array. I also included a method to check if the file is empty
 * and a method to change a string of numerical values into an int. 
 */
public class Save 
{
   private int lines;
   private File f;
   public static void main(String[] args) throws FileNotFoundException //main method to 
   {
      System.out.println(toInt("123456"));
      System.out.println(toInt("2") + toInt("3"));
      //should print out the same thing inputed
      Save s = new Save("testSave.txt");
      String[] t = new String[]{"Line 1","Line 2"};
      /* 
       * now the file should appear like this
       * Line 1
       * Line 2
       */
      s.save(t);
      String[] c = s.get("testSave.txt");
      for(int i = 0; i < c.length; i++)
      {
         System.out.println(c[i]); //should match what is i the file however the file should be deleted after get is used
      }
      System.out.println(exists("testSave.txt"));//try to see if there is a save available
      //there wont be a save available because we used get which deletes the file
      System.out.print(toString(124345));
   }
   public Save(String filename)
   {
      lines = 0;
      f = new File(filename);
   }
   public void save(String[] saveData) throws FileNotFoundException
   {
      PrintWriter pw = new PrintWriter(f); //create printer to store data
      lines = saveData.length; //set lines to the input arrays length so it knows how many lines it will need to get
      for(int i = 0; i < lines; i++)
      {
         pw.println(saveData[i]);
      }
      pw.close();
   }
   public String[] get(String fName) throws FileNotFoundException
   {
      if(exists(fName))
      {
         Scanner sc = new Scanner(f); //create scanner
         String[] l = new String[lines]; //create array to return the size of lines that is determined in the save method
         for(int i = 0; i < lines; i++)
         {
            l[i] = sc.nextLine();
         }
         sc.close();
         f.delete(); //delete file after it is used
         return l;
      }
      else
      {
         System.err.print("Error: File is unexistant");
         String[] f = new String[]{};
         return f;
      }
   }
   public static boolean exists(String filename) //check if the file exists
   {
      File a = new File(filename);
      return a.exists();
   }
   public static int toInt(String s)
   {
      int tenvar = 1;
      int length = s.length() - 1;
      int awnser = 0;
      for(int i = length; i >= 0; i--)
      {
         awnser += (((int)s.charAt(i)) - (int)'0') * tenvar;
         tenvar *= 10;
      }
      return awnser;
   }
   public static String toString(int I) //converts int to a STRING
   {
      int count = 0;
      StringBuilder awnser = new StringBuilder("");
      while(I > 0)
      {
         awnser.insert(count, (char)((I % 10) + ((int)'0')));
         I /= 10;
         count++;
      }
      return awnser.reverse().toString();
   }
}
