//Chauncey Smith
//Lab 2
//Feb 4, 2020
//CSCI165
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream; //first lets import
import java.io.File;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.FileReader;

public class FoodTruck{  //our basic opening to the java program
  public static void main(String[] args){
    System.out.println("Welcome to the CS FoodTruck!\n==================================");
    Scanner input = new Scanner(System.in);  //allocating memory for the scanner so the user can input their name
    System.out.println("Please enter your name to start: ");
    String name = input.nextLine();  //we take the whole line of input as we store the name in the next line
    System.out.println("Enter the quantity of each item \n==================================");

    FileInputStream fileIn = null;  //we set these to null to open up the files
    Scanner fileScan = null;
    FileInputStream fileIntwo = null;
    Scanner fileScantwo = null;

    int counter = 0;
    try{  //a simple try and catch to start working with files
        fileIn = new FileInputStream("menus.txt"); //next we take the menus file and the prices and assign a scanner to them
        fileIntwo = new FileInputStream("prices.txt");
        fileScan = new Scanner(fileIn); //assign scanner
        fileScantwo = new Scanner(fileIntwo);
        String[] menu = new String[3]; //making an array for the 3 items in the file
        double[] prices = new double[3];
        int[] quantity = new int[3];
        //set a simple while loop to print out all of the menu options from the file
        double subtotal = 0.00; //now we make the subtotal a double becasue it will have decimals
        while(fileScan.hasNextLine() && fileScantwo.hasNextLine()){  //set a basic loop that goes till the end of the lines
          //now menu and prices will take the full line and store it into an array
          menu[counter] = fileScan.nextLine();
          //same thing as above
          prices[counter] = fileScantwo.nextDouble();
          //now we print these results to the user
          System.out.printf("%s - $%.2f:%n",menu[counter],prices[counter]);
          //then we ask them how many of each item they would like
          Scanner input_two = new Scanner(System.in);
          //how we set quantity as an array so we can easily take the value for the receipt
          quantity[counter] = input_two.nextInt();
          //next we do some math to find the subtotal
          double cost = quantity[counter] * prices[counter];
          double charge = cost + subtotal;
          subtotal = charge;
          //add one to the counter so the array increases
          counter ++;
          }//end of loop




        //OUTPUT TIME


        //First we take the invoice number

    //this has been done before so just finding the index and adding one for the name
    int space = name.indexOf(" ") + 1;
    //taking the char value at the last name
    char last_char = name.charAt(space);
    //doing it for the first
    char char_character = name.charAt(0);
    int char_addition = last_char + char_character;
    //adding the char values then finding the length of the name and multiplying
    int name_length = name.length();
    int char_multiply = char_addition * name_length;

    //time and date
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    //next we import date and time to easily find the current time and date
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    //next we need to turn these values into strings so we can slice them
    String date = dateFormatter.format(now);
    String time = timeFormatter.format(now);
    //following the algorithim of taking the date and year but no "/" or ":"
    String date_slice = date.substring(0,2);
    int date_slice_two = date.indexOf("/") + 1;
    String f_date_slice = date.substring(date_slice_two,date_slice_two+2);
    String date_number = date_slice + f_date_slice;
    String time_slice = time.substring(0,2);
    int time_slice_two = time.indexOf(":") + 1; //basic slicing
    String f_time_slice = time.substring(time_slice_two,time_slice_two+2);
    String time_number = time_slice + f_time_slice;
    //now we concatonate the two so we can get part of the invoice number
    String date_time_number = date_number+time_number;


    //finding the initials

    //basic slicing very similar to char value and date
    String first_letters = name.substring(0,2);
    String last_letters = name.substring(space, space+2);
    String upper_case = first_letters.toUpperCase(); //converting to uppercase
    String last_upper = last_letters.toUpperCase();
    //now we have to add all of the ingrdients to get the invoice number
    String final_invoice_number = upper_case+last_upper+char_multiply+date_time_number;


    //now we taking the sales tax and subtotal
    double sales_tax = subtotal * .0625;
    double total = sales_tax + subtotal;

    //now formatting the receipt begins, we use printf to pad the basic receipt dimensions
    System.out.println("================================================\n");
    System.out.format("%-30s%-30s","Invoice Number:",final_invoice_number);
    System.out.format("\n%-30s%-30s","Date:",dateFormatter.format(now));
    System.out.format("\n%-30s%-30s","Time:",timeFormatter.format(now));
    //System.out.format("%30s %10")
    System.out.format("\n\n%s%30s%10s%10s\n","Item","Quantity","Price","Total");
    System.out.println("\n========================================================");
    //made a basic while loop to print the prices quantity and total for each item the customer chose
    int index = 0;
    int counter_two = 0;
    while(index < 3){
      System.out.format("\n%-30s%-10d$%-10.2f$%-10.2f\n", menu[counter_two],quantity[counter_two],prices[counter_two],quantity[counter_two] * prices[counter_two]);
      index++;
      counter_two++;
    } //end of loop
    System.out.println("=======================================================");
    //now we print the subtotal sales tax and total
    System.out.format("\n%-50s$%-10.2f","Subtotal",subtotal);
    System.out.format("\n%-50s$%-10.2f","Tax of 6.25%",sales_tax);
    System.out.format("\n%-50s$%-10.2f","Total",total);


    //NOW WE WRITE CONSOLE OUTPUT TO FILE

    //set buffered reader to read the input stream
    //it will read the next line
    String invoice = final_invoice_number;

    String s_subtotal = String.valueOf(subtotal);
    //now we make a new file with the invoice number to print each line from the console to the file
    PrintStream file = new PrintStream(final_invoice_number+".txt");
    //i could not find a way to print the whole invoice,
    System.setOut(file);
    System.out.printf("Invoice Number: %s",invoice);
    System.out.printf("\nDate: %s",date);
    System.out.printf("\nTime: %s",time);
    System.out.printf("\nTotal Charge =====> $%.2f",total);
    //file.writeDouble(sales_tax);
    //file.writeDouble(total);

    //print each line that was read in the file
    //close the file
    file.close();

}//end of try

catch(IOException e){
  System.out.println("File Not Found");
} //end of exception


      //DecimalFormat df = new DecimalFormat("#.00");
      //System.out.println("$"+df.format(cost));

      input.close(); //close input
    }//end of main

  }//end of class
