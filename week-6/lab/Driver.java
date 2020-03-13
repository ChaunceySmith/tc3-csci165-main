//Chauncey Smith

//This is our driver where we will call all of our methods and tests

//import statements
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.*;

   
public class Driver{
    public static void main(String[] args){
        



        //making 4 array lists with a 1000 size
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Account> accounts = new ArrayList<Account>();
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
     
        try{
            //opening file and scanning
            File fileRead = new File("customers.txt");
            Scanner fileScan = new Scanner(fileRead);
        
            while(fileScan.hasNextLine()){

                String line = fileScan.nextLine();
                //split the values into an array, regardless of the amount of spaces
                String[] values = line.split("\t");
                //take first name
                String first_name = values[0];
                //last
                String last_name = values[1];
                //email
                String email = values[2];
                //then conatonate street/address
                String street = values[3]+" "+values[4]+" "+values[5];
                //take the zip and put it in address
                String zip = values[6];
                Address address = new Address(street, zip);
                //then we have customer to add to the customer arraylist
                Customer c = new Customer(first_name,last_name,email,address);
                customers.add(c);
               // Account(String id,Customer customer, double balance, double creditLimit, double discountLevel){
                Account accont = new Account("lijsvblsj",c,1.0,.2,.2);
                //needed garbage data becaseu there are 3 setters, some structure issues

                //then add to account arraylist
                accounts.add(accont);

                
            }
            //demonstrating i can stack toString methods
            Address ad = new Address("Calhoun Rd","49220");
            Customer c = new Customer("Chauncey","Smith","chaunceyfloyd20@gmail.com",ad);
            Account ac = new Account("CS117092",c,1.0,.2,.2);
            System.out.println(ac.toString());

            fileScan.close();
        }
        catch(IOException e){
            System.out.println("File not Found");
          }

        Random random = new Random();
        //Date oderDate = new Date(6,15,2020);
        try{
            //open and read products
            File fileRead2 = new File("products.txt");
            Scanner fileScan2 = new Scanner(fileRead2);

            while(fileScan2.hasNextLine()){
                //take the line
                String line = fileScan2.nextLine();
                //split the values at the tabs
                String[] values = line.split("\t");
                //name of product
                String name = values[0];
                //description 
                String description = values[1];
                //the price as a string
                String s_price = values[2];
                //then converted
                double price = Double.parseDouble(s_price);
                //take the sku
                String sku = values[3];
                //put it through the constructor
                Product pro = new Product(name,description,price,sku);
                //add to prodcuts arraylist
                products.add(pro);

            }

            //make the date created
            Date date = new Date(3,20,2020);
                for(int i=0; i < 1000;i++){
                    //dummy invoice number, use products arraylist
                    Invoice in = new Invoice("C-3P00117",accounts.get(random.nextInt(1000)),date,products);
                    //add to invoice arraylist
                    invoices.add(in);
                }
                //call sort array
                //NOTE SORTED FROM SMALLEST COST TO GREATEST
                sortArray(invoices);

            //greet user
            System.out.println("==Press Enter to see the Invoices!==");
            //basic loop to the size of invoices
            for(int i = 0;i<invoices.size();i++){
                //make the scanner stop until user hits enter
                Scanner scan = new Scanner(System.in);
                scan.nextLine();
                //print and call toString
                System.out.println(invoices.get(i).toString());
            }

            
            fileScan2.close();
        }
        catch(IOException e){
            System.out.println("File not Found");
        }
     
    }
    public static void sortArray(ArrayList<Invoice> invoices){
        for(int i=0; i<invoices.size(); i++){
            Invoice inv = invoices.get(i);
            double min = inv.getAmount();
            for(int j=i+1; j<invoices.size();j++){
                Invoice inv_2 = invoices.get(j);
                double min_2 = inv_2.getAmount();
                if(min > min_2){
                    Collections.swap(invoices,i,j);
                }
            }

        }
           
    }

}

