//Chauncey Smith

//Invoice File

import java.io.*;
import java.util.*;

public class Invoice{
  //field varaibales
  private String invoiceNumber;
  private Account account;
  private double amount = 0.0;
  private Date orderDate;
  private ArrayList<Product> products;
  String x;

  public Invoice(){}

  public Invoice(String inv_num, Account acct, Date date, ArrayList<Product> products){
    this.products = products;
    this.invoiceNumber = inv_num;
    this.account = acct;
    this.orderDate = date;
    addProduct();
    setAmount();
  }

  public void addProduct(){
    //double cost = product.getPrice();
    Random ran = new Random();
    //random product, but at least one will be bought
    int j = ran.nextInt(19)+1;
    //set final price before looping
    double final_price = 0.0;
    for(int i=0;i<j;i++){
      //get a random product in the arraylist <products>
      Product pro = products.get(ran.nextInt(1000));
      //call a getter and add to final price
      double cost = pro.getPrice();
      cost = Math.round(cost*100)/100;
      final_price = cost+final_price;
      //call x tostring, then add x to y so they stack
      //very hard part for me was to think of a way to add the toString from products to make sure they go for every object listed
      String y = pro.toString();
      this.x=y+"\n"+x;
      products.add(pro);
    }
    //System.out.println("=================================");
    this.amount = final_price;
  }

  //setters and getters
  public Account getAccount(){
    return account;
  }
  public double getAmount(){
    return amount;
  }
  public void setAmount(){
    //putting in discount level
    double dl = this.account.getDiscountLevel();
    double discounted_amount = dl*amount;
    double ds = this.amount - discounted_amount;
    this.amount = ds;
    return;
  }
  public Date getDate(){
    return orderDate;
  }

  public void setDate(Date date){
    this.orderDate = date;
  }


  //finally our compareTO and toString
  public int compareTo(Invoice otherInvoice){
    if(this.amount == otherInvoice.amount){
      return 0;
    }
    else {
      int x = this.invoiceNumber.compareTo(otherInvoice.invoiceNumber);
      return x;
    }
    
  }
  public String toString(){
    return x+"Invoice Number:  "+invoiceNumber +"\n"+account.toString()+"\nCost:  $"+amount+"\n======================================";
  }
  //compare method
}
