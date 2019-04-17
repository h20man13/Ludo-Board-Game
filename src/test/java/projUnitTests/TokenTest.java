////////////////////////////////////////////////////////////////////////////////
// File:             TokenTest.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

package projUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import shapes.Token;

/**
 * 
 */
public class TokenTest {

   @Test
   public void test() 
   {
      Token f = new Token(null, 0, null);
      assertNull(f);
   }

}
