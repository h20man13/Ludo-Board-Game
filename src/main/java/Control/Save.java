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
   public static void main(String[] args) //main method to 
   {
      System.out.println(toInt("123456")); //should print out the same thing inputed
      Save s = new Save("testSave.txt");
      String[] t = new String[]{};
      s.save();
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
   public String[] get() throws FileNotFoundException
   {
      if(isEmpty())
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
         System.err.println("Error: No data to get the file is empty");
         String[] f = new String[]{"The", "File", "is", "empty"};
         return f;
      }
   }
   public boolean isEmpty() //check if the file is empty
   {
      return (f.length() == 0);
   }
   public static long toInt(String s)
   {
      long tenvar = 1;
      int length = s.length() - 1;
      int awnser = 0;
      for(int i = length - 1; i >= 0; i--)
      {
         awnser += (((int)s.charAt(i)) - (int)'0') * tenvar;
         tenvar *= 10;
      }
      return awnser;
   }
}
