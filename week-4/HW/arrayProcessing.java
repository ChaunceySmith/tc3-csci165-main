//Chauncey Smith
//HW 4

//This is problem 1
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.BufferedReader;

public class arrayProcessing{
  public static void main(String[]  args){
    Scanner fileScan = null;
    //FileInputStream fileRead = null;
    try{
      //read through file
      BufferedReader fileRead = new BufferedReader(new FileReader("number_list.txt"));
      fileScan = new Scanner(fileRead);
      //set counter so we know how big the array should be
      int counter = 0;
      while(fileRead.readLine() != null){
        counter++;
      }

      int[] numbers = new int[counter];

    for(int i = 0; counter > i; i++)
        numbers[i] = fileScan.nextInt();
     }
    fileScan.close();
    fileRead.close();
    }
    catch(IOException e){
      System.out.println("File not Found");
    }
  }
  private static int max(int[] t) {
    int max = numbers[0];
    for (int i = 0; i<numbers.length(); i++){
      if (numbers[i] > max){
        max = numbers[i];
      }
    }
  }
  private static int min(int[] t){
    int min = numbers[0]
    for (int i = 0; i<numbers.length() i++){
      if (numbers[i] < min){
        min = numbers[i];
      }
    }
  }
}
