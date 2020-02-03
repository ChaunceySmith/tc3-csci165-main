//Chauncey Smith
//Homework 1, 01/29/20
//Number 1

import java.util.Scanner;

public class Primitives{
  public static void main(String[] args){

    boolean bool = false; //boolean primitive type, true or false
    System.out.printf("Boolean is either true or false this variable called bool is false \n",bool);
    byte byt = 127; //for a byte we set a simple value, sequence of 8 bits, you can store anything, based of ASCII table
    System.out.printf("A byte is a sequence of 8 bits, small amount of data it ranges to -128 to %d \n", byt);
    char chrA = 'Z'; //a char holds a single character that can hold a number,letter,or symbol, much like a byte it also goes to a greater range than byte
    char chrB = 7; //char can be character or numeric literals based on ASCII table
    System.out.printf("A char can hold letters,symbols like %s and 7 \n",chrA,chrB); //had trouble with this format of chr B would not print no matter what I tried
    short shrt = 32767; //this is the highest range, but short is for small numbers
    System.out.printf("A short is a bigger amount of data that goes to -32767 to %d \n", shrt);
    int in = 42949672; //just a bigger range of numbers like short can hold more
    System.out.printf("An int is a big amount of data, but remember only whole numbers no fractions, ranges from -2^32 to %d, notice I did not put the full number \n", in);
    long lng = 2^63L; //just a massive amount of data that can be allocated, long is the biggest amount you can go to
    System.out.printf("A long is a massive amount of data, the biggest being 2^-64 to %d, notice a couple powers short \n",lng);

    //now we go to floating and double/decimals
    float flot = 0.5f; //we can use decimals and fractions with floats 2^-32
    System.out.printf("Float is working with decimels and small numbers an example is like %f \n", flot);
    double doble = 0.0555f; //much more precise, 2^-64 very small
    System.out.printf("Doulble similar to float but with much smaller number like %f \n",doble);
  //end of main method



//Number 2
 {
    Scanner input = new Scanner(System.in); //creating a scanner, variable called input, allocating memory and calling an input instance
    System.out.println("Please enter an integer to find the square,cube and fourth power ");
    int number = input.nextInt(); //the number entered
    double square = Math.pow(number,2); //now we call the math method of power and square it
    double cube = Math.pow(number,3); //then cube it
    double fourth = Math.pow(number,4); //then take it to the fourth
    System.out.println(number + " Squared is: " + square +"\n"); //multiple print statements to make it readable
    System.out.println(number + " Cubed is: " + cube +"\n");
    System.out.println(number + " to the fourth is: " + fourth );
  }

//Number 3
    int big = Integer.MAX_VALUE; //calling the max value on int
    int small = Integer.MIN_VALUE; //calling the min
    System.out.println("The max value of an Int is: "+big);//simple print statements
    System.out.println("The min value of an Int is: "+small);

    //now we jump to comparing the values
    System.out.println(Integer.compare(big,small) +" it is 1, meaning a (the big value) is bigger than b (the small value)"); //comparing two numbers, becasue big is greater than small the output is one
    System.out.println(Integer.compareUnsigned(big,small)+ " becasue an unsigned number can only be positive, it is showing us that a is bigger than b through opposite means"); //a signed number can be positive or negative while an unsigned number can only be positive



//Number 4
    //Scanner input = new Scanner(System.in); //creating scanner for user input
    //System.out.println("Please enter a number with decimals: ");
    //float number_one
    //CALLISTO TOLD ME NOT TO DO THIS ONE, PROBLEMS WITH THE ISFINITE METHOD


//Number 5
    Scanner input = new Scanner(System.in); //create scanner getting ready for input
    System.out.println("Please enter a dividend: "); //asking user for input
    int dividend = input.nextInt();   //telling input is int
    System.out.println("Please enter a divisor: ");
    int divisor = input.nextInt();
    double floor_result = dividend / divisor;   //dividing
    double final_floor = Math.floor(floor_result);   //using the math class and calling the floor method we floor the result
    double modulus = dividend % divisor; //simple modulus
    System.out.printf("With floor division it is %.2f, and with modulus it is %.2f",final_floor, modulus); //printf statements






}//end of main
}//end of class
