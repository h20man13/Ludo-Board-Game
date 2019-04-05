////////////////////////////////////////////////////////////////////////////////
// File:             Save.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package Control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * 
 */
public class Save 
{
   private int lines;
   private File f;
   public Save(String filename)
   {
      lines = 0;
      f = new File(filename);
   }
   public void save(String[] saveData) throws FileNotFoundException
   {
      PrintWriter pw = new PrintWriter(f); //create printer to store data
      lines = saveData.length;
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
   public boolean isEmpty()
   {
      return (f.length() == 0);
   }
   public static int toInt(String s)
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
