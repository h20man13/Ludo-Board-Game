package hw3;
////////////////////////////////////////////////////////////////////////////////
// File:             Customer.java
// Course:           CSC232, Spring
// Authors:          Jacob Bauer
//
// Acknowledgements: Prof. Howard
//                   Provided me with the instructions and the description of the project
//
// Online sources:  https://moodle3.depauw.edu/mod/assign/view.php?id=203387
//
////////////////////////////////////////////////////////////////////////////////

/**                                                                                                                                                                                                                                           
   The <code>CustomerTestDriver</code> class is used to test the customer class                                                                                                                                                                                
   @author Jacob Bauer <jacobbauer_2021@depauw.edu>                                                                                                                                                                                           
*/

public class CustomerTestDriver
{
  public static void main(String[] args)
  {
    Customer BH = new Customer("Brian","Howard" , ' ' , 53);
    System.out.println(BH.toString());
    Customer BC = new Customer(args[0] , args[1], 'A', 52);
    System.out.println(BC.toString());
  }
}
