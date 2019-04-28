package hw3;
////////////////////////////////////////////////////////////////////////////////
// File:             Customer.java
// Course:           CSC232, Spring
// Authors:          Jacob Bauer
//
// Acknowledgements: Prof. Howard
//                   Provided me with the instructions and the description of the project
//
// Online sources:   https://stackoverflow.com/questions/833768/java-code-for-getting-current-time
//                   https://moodle3.depauw.edu/mod/page/view.php?id=203388
//                   https://moodle3.depauw.edu/mod/assign/view.php?id=203387
////////////////////////////////////////////////////////////////////////////////

import java.lang.String;
import java.time.LocalTime;

/**
   The <code>Customer</code> class is used to create customers
   @author Jacob Bauer <jacobbauer_2021@depauw.edu>
*/

public class Customer
{
  /**
   Constructor for the class customer
   @param firstName First name of the customer object
   @param lastName Last name of the customer object
   @param mI Middle initial of the customer object
   @param age age of the customer instance
  */
  public Customer(String firstName, String lastName, char mI, int age)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.mI = mI;
    this.age = age;
    gone = false;
    arrivalTime = LocalTime.now();
    departureTime = LocalTime.now();
  }
  /**
   <code>toString</code> is a method to convert the owning objects fields into a string representation taking up multiple lines
   @return s  returns 6 lines of code with descriptions of each line listed below:
   Line 1) "Customer:"<br>
   Line 2) "    Firstname: (firstName<)" <br>
   Line 3) "    Lastname: (lastName)" <br>
   Line 4) "    Middal initial:(mI)"<br>
   Line 5) "    Age: (age)" <br>
   Line 6) "    Arrival time: (arrivalTime)"<br>
   Line 7) "    Departure time: (rest as followed)<br>
   if gone = true then add to string (departureTime)<br>
   if gone = false then add to string "the person has not departed yet"
  */
  public String toString()
  {
    String s = "Customer:\n";
    s += ("    First name: " + firstName + '\n');
    s += ("    Last name: " + lastName + '\n');
    s += ("    Middle initial: " + mI + '\n');
    s += ("    Age: " + age + '\n');
    s += ("    Arrival time: " + arrivalTime + '\n');
    s += (this.gone) ? ("     Departure Time: " + departureTime) : ("    Departure Time: The person has not departed yet.");
    return s;
  }
  
  private final String firstName; //first name of customer 
  private final String lastName; //last name of customer
  private final char mI; // middle initial of customer
  private final int age; // age of customer
  private final LocalTime arrivalTime; //arrival time of customer
  private LocalTime departureTime; //departure time of customer
  private boolean gone; //has the customer departed yet? 
}

