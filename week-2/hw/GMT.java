//Chauncey Smith

//Homework 1

//Number 6

import java.lang.*;

public class GMT{
  public static void main(String[] args){
    long mills = System.currentTimeMillis(); //call current time in milliseconds
    long secs = mills / 1000; //divide by 1000 to get seconds
    double floor_secs = Math.floor(secs); //floor division for the seconds value
    double additoinal_secs = floor_secs % 60; //modulus for the additional seconds
    double mins = floor_secs / 60; //do the same thing with minutes
    double hours = mins / 60; //and hours
    System.out.println(hours+":"+mins+":"+secs);
    //this one was done wrong
    //could not figure out how to get the exact time using ONLY math, would have used time class
  }//end of main
}//end of class
