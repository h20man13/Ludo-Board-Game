////////////////////////////////////////////////////////////////////////////////
// File:             CustomerTest.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package hw3UnitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import HW3.Customer;

/**
 * 
 */
public class CustomerTest {

   @Test
   public void test() 
   {
      Customer jerry = new Customer("Jerry", "Mggaffany", 'H', 980);
      assertNull(jerry.toString());
   }

}
