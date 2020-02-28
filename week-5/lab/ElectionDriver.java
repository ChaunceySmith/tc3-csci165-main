//Chauncey Smith

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;


public class ElectionDriver{
  //creating an arraylist filled with county results
  ArrayList<CountyResults2016> results = new ArrayList<CountyResults2016>();

  //now we fill our array
  public static void fillList(ArrayList results){

    //set scanner to null
    Scanner fileScan = null;

    try{
      //read through the file
      BufferedReader fileRead = new BufferedReader(new FileReader("2016_US_County_Level_Presidential_Results.csv"));
      //create fileScan
      fileScan = new Scanner(fileRead);

      //now we make a while loop
      while(fileScan.hasNext()){
        //split the line where commas are
        String data = fileScan.next();
        System.out.println(data);
      //  CountyResults2016 cr = new CountyResults2016(fileScan.parseDouble(), fileScan.parseDouble(), fileScan.parseDouble(), fileScan.parseDouble(), fileScan.parseDouble(), fileScan.parseDouble(), fileScan.parseDouble(), fileScan.parseString(), fileScan.parseString(), fileScan.parseInt());
        //results.add(cr);
      }

    }
    catch(IOException e){
      System.out.println("File not Found");
    }
  }

}
