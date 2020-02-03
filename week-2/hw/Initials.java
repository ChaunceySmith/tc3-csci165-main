//Chauncey Smith


//Number 7

import java.util.Scanner; //import util scanner

public class Initials{
  public static void main(String[] args){
    String name; //setting string for the name
    Scanner input = new Scanner(System.in);  //asking user for input
    System.out.println("Please enter your first and last name separated by a space: ");
    name = input.nextLine(); //storing the name in a variable
    int space = name.indexOf(" ") + 1;  //finding the last letter of the index
    char last_char = name.charAt(space); //could not immedielty convert to char, had to slice the first character first
    char char_character = name.charAt(0); //converting the first letter to char
    System.out.println(char_character); //printing out both letters
    System.out.println(last_char);
    int x = ((int)char_character); //converting to char values
    int y = ((int) last_char);
    System.out.println(x); //printing char values
    System.out.println(y);
    System.out.println(x+y); //printing the sum of the char values
    String first_letter = name.substring(0,1); //slicing the first and last letter
    String last_letter = name.substring(space, space+1);
    System.out.println(first_letter + last_letter); //concatonating
    input.close(); //closing scanner
  }//end of main
}//end of class
