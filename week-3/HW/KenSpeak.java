//Chauncey Smith
//CSCI165
//HomeWork 2
import java.util.Scanner;


public class KenSpeak{


  public static void main(String[] args){
    System.out.println("Please type any amount of numbers for them to be encoded into KenSpeak");
    //creating a scanner for input
    Scanner input = new Scanner(System.in);
    String numbers = input.nextLine();
    String codes = "*BEA@FK%RM";
    String encoded_string = "";
    String string_code = "";
    //now lets create a for loop that will go through the entire input
    for( int i = 0; i < numbers.length(); i++){
      char c = numbers.charAt(i);
      int char_to_int = Character.getNumericValue(c);
      string_code = codes.substring(char_to_int, char_to_int+1);
      encoded_string += string_code;

    }
    System.out.println("Here is your encoded numbers: "+ encoded_string);
  }

}
