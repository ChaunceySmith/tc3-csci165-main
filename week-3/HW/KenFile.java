//Chauncey Smith
//Homework 2
//This file will read a file and create a new one


//first lets import
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;


public class KenFile{

  public static void main(String[] args){
    //must set these to null to read files and scan
    FileInputStream fileIn = null;
    Scanner fileScan = null;

    //basic try and catch
    try{
      fileIn = new FileInputStream("numbers.txt");
      FileWriter fileWriter = new FileWriter("encodedNumbers.txt");
      fileScan = new Scanner(fileIn);
      int counter = 0;
      while(fileScan.hasNextLine()){
        String numbers = fileScan.nextLine();
        String codes = "*BEA@FK%RM";
        //make empty strings
        String encoded_string = "";
        String string_code = "";
        //now lets create a for loop that will go through the entire input
        for( int i = 0; i < numbers.length(); i++){
          //now we must convert char characters to ints
          char c = numbers.charAt(i);
          int char_to_int = Character.getNumericValue(c);
          //now we take the substring of codes that correspond to the number that we got
          //from char to int
          string_code = codes.substring(char_to_int, char_to_int+1);
          encoded_string += string_code;

      }
      //close files 
      fileWriter.write(encoded_string+'\n');
    }
    fileScan.close();
    fileWriter.close();



  }
  catch(IOException e){
    System.out.println("File not Found");
  }
}
}
