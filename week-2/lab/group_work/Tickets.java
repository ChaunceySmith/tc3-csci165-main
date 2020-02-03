//Chauncey Smith, Garett Davenport
//Tickets Group assignment

import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Tickets{

    public static void main(String[] args){

        /*
            The following code steps you through the String processing
            and math neccessary to determine if a single ticket number is valid.
            Your job with this code is to:

            ~   Closely study the code. Reverse engineer it. Use the API for guidance
                to understand the classes and methods that are being used.
            ~   Add comments for each statement, describing in detail what the line is doing
                I want to know DETAILS, not generalizations. RESEARCH!
            ~   When you have completed that, add code to complete the following

                1) Using a Scanner, open the file: tickets.txt
                2) Using a while(hasNext) loop, read each ticket number
                3) Run the ticket number through the provided math and String processing
                4) If the ticket number is valid write it to a new file called: valid_tix.txt
                5) Ignore the invalid ticket numbers

            ~   Additional code must also be commented. But I am more interested in why you are doing
                something, not the details of how.

            Check your work: There are 101 valid ticket numbers among the 1000 provided ticket numbers
                             These people make mistakes!!!

            Submit only Java source code files. Also submit valid_tix.txt

        */
        FileInputStream fileIn = null;
        Scanner fileScan = null;
        try{
            fileIn = new FileInputStream("tickets.txt"); //first we use a try except (we do this to open the file)
            FileWriter fileWriter = new FileWriter("valid_tix.txt");
            fileScan = new Scanner(fileIn); //next we create a scanner to read through the file, we need this becasue we have to go through the tickets
            int counter = 0;   //we set the line number to help the scanner go along each line of the file
            while(fileScan.hasNextLine()){ //now we set a while loop for the file scanner to go through every line
                String ticket = fileScan.nextLine();
                String  last = ticket.substring(ticket.length() - 1);  // also a string setting a variable called last, we are removing the last digit of the string(taking the length -1)
                int     last_digit = Integer.valueOf(last);  //we are now storing the value of the last_digit becasue we need it to compare to the remainder, so we are simply setting a variable
                String  reduced_ticket = ticket.substring(0, ticket.length() - 1);
                int     ticket_number = Integer.valueOf(reduced_ticket); //this is our final int of the reduced ticket without the last digit
                int     remainder = ticket_number % 7; //using modulus division to find the remainder of the ticket number % by 7
                boolean validity = remainder == last_digit; //this is how we check the validity of the statement, if the remainder == the last digit the ticket is valid

                if(validity == true){ //we need an if statement so we can write the ticket number if it is valid

                    fileWriter.write(ticket + '\n'); //writing the ticket to the file
                    counter++;}

            }//end of while loop
            System.out.println(counter);  //counting the digits 
            fileScan.close();  //closing a file
            fileWriter.close(); //closing the fileWriter
        }//end of try
        catch(IOException e){
            System.out.println("File not Found");
        }//end of catch for FileInputStream
      //String  ticket  = "123454";   //telling Java what ticket it is, stating it is a string

    }//end of main
}//end of class
