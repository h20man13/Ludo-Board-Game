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
   private Scanner sc;
   private PrintWriter pw;
   private int lines;
   private File f;
   public Save(String filename)
   {
      f = new File(filename);
      try 
      {
         pw = new PrintWriter(f);
      } 
      catch(FileNotFoundException e) 
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      try 
      {
         sc = new Scanner(f);
      } 
      catch (FileNotFoundException e) 
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public void save(String[] saveData)
   {
      lines = saveData.length;
      for(int i = 0; i < lines; i++)
      {
         pw.println(saveData[i]);
      }
   }
   public String[] get()
   {
      String[] l = new String[lines];
      for(int i = 0; i < lines; i++)
      {
         l[i] = sc.nextLine();
      }
      return l;
   }
   public boolean isEmpty()
   {
      return (f.length() == 0);
   }
}
