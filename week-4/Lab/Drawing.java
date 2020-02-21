//Chauncey Smith
//Lab 3

//In this lab we will take the file form National Oceanic and Atmospheric Information
//into a 2D array and create a graph to see which elevation is the shortest in colorado

//first lets import

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Drawing{

  //now i will make a method to fill the colorado array
  public static void fillArray(int[][] matrix, String fileName, int rows, int columns){
    //set scanner to null
    Scanner fileScan = null;

    //now we do our try/except to open the file
    try{
      //make a bufferedreader to go through the file and read it, set scanner to file read
      BufferedReader fileRead = new BufferedReader(new FileReader(fileName));
      fileScan = new Scanner(fileRead);

      //lets set a for loop that can go through the file and place the data from the file
      //into the array
      for(int i = 0; i<rows; i++){
          //nested loop to place the numbers into the columns
          for(int j = 0; j<columns; j++){
            matrix[i][j] = fileScan.nextInt();
          } //end of nested loop
       } //end of loop
      //close scanner
      fileScan.close();
      //close file read
      fileRead.close();
    } //end of try
      catch(IOException e){
        System.out.println("File not Found");
      } //end of except

    } //end of fillArray

    //new method to find max
  public static int findMax(int[][] matrix){
    //we start at 0,0 and have a nested loop that goes
    //through the columns and rows
    int max = matrix[0][0];
    //set basic loop that goes through rows
    for (int i = 0; i<matrix.length; i++){
      //nested loop that goes through columns
      for(int j = 0; j<matrix[i].length; j++){
        //if the max is greater than the previous max, that is the max
        if (matrix[i][j] > max){
          max = matrix[i][j];
        } //end of if
      } //end of nested loop
    } //end of loop
    return max;
  } //end of findmax
  //now we do the same thing but for min
  public static int findMin(int[][] matrix){
    //start at 0,0
    int min = matrix[0][0];
    //same
    for (int i = 0; i<matrix.length; i++){
      for(int j = 0; j<matrix[i].length; j++){
        //the only difference is sign change < and >
        if (matrix[i][j] < min){
          min = matrix[i][j];
        } //end of if
      } //end of nested loop
    } //end of loop
    return min;
  } //end of findmin

  // public static int findMin_One(int[] array) {
  //   int min = array[0];
  //   for (int i = 0; i<array.length; i++){
  //     if (array[i] < min){
  //       min = array[i];
  //     }
  //     }
  //     return min;
  // }

} //end of class
