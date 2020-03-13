//Chauncey Smith

//Now we create an account class that will call customer and date class
import java.util.Random;


public class Account{
  //set private field variables
  private String accountID;
  private Customer customer;
  //INVARIANT BALANCE, CREDIT LIMIT, AND DISCOUNT LEVEL CANNOT BE NEGATIVE
  private double balance;
  //INVARIANT CREDIT LIMIT CANNOT BE OVER 200%
  private double creditLimit;
  private Date dateCreated;
  //RULE, every year the account has a 2% discount
  private double discountLevel;

  //constructors
  public Account(){}

  public Account(String id, Customer customer){
    setAccountID(id);
    this.customer = customer;
  }
  public Account(String id, Customer customer, double balance, double creditLimit){
    setAccountID(id);
    this.customer = customer;
    setBalance(balance);
    setCreditLimit(creditLimit);
    
  }
  public Account(String id,Customer customer, double balance, double creditLimit, double discountLevel){
      this.customer = customer;
      setDiscountLevel(discountLevel);
      setAccountID(id);
      //this.customer = customer;
      setBalance(balance);
      setCreditLimit(creditLimit);
      //this.dateCreated = dateCreated;
     // setDiscountLevel(discountLevel);
  }

  
  //now we make a copy constructor to protect privacy
  public Account(Account copy){
    //to copy an instance of customer we must call new to allocate new memory&reference
    this.customer = new Customer(copy.customer);
    this.balance = copy.balance;
    this.creditLimit = copy.creditLimit;
    this.discountLevel = copy.discountLevel;

  }

  //setters and getters
  public Customer getCustomer(){
    return customer;
  }
  public double getBalance(){
    return balance;
  }
  public double getCreditLimit(){

    return creditLimit;
  }
  public double getDiscountLevel(){

    return discountLevel;
  }

  public void setAccountID(String name){
    //making the account id

    //fist grab name
    name = customer.getName();
    //then replace all vowels 
    name = name.replaceAll("[AaEeIiOoUu ]","");
    name = name.toUpperCase();
    //take the date created and make it a string and replace all
    String str_date = dateCreated.toString();
    str_date = str_date.replaceAll("/","");
    //concatonate
    String accountid = name + str_date;
    //basic loop that goes through the entire name and adds the ascii values
    int ascii = 0;
    for(int i = 0; i < name.length(); i++){
      int c = name.charAt(i);
      ascii = ascii + c;
    }
    //final account id with mod check didig
    int check_digit = ascii % name.length();
    String finalAccountID = accountid + check_digit;
    this.accountID = finalAccountID;
    return;
  }

  public void setDiscountLevel(double d){
    if(d>0){
  
      Random ran = new Random();
      //get ran year
      int year = ran.nextInt(15);
      //make it the discount lvl
      double discount = year*.02;
      discount = Math.round(discount*100)/100;
      //make the year in current times
      year = 2020-year;
      this.discountLevel = discount;
      //get ran day and month
      int month = ran.nextInt(12);
      int day = ran.nextInt(28);
      this.dateCreated = new Date(month,day,year);
      return;
    }
    else{
      this.discountLevel = 0.0;
      return;
    }
  }

  public void setBalance(double b){
    if(b > 0){
      //setting a ran balance
        Random ran = new Random();
        int max = 100000;
        int min = 100;
        //making a range for the balance
        double random_b = min + (max - min) * ran.nextDouble();
        random_b = Math.round(random_b*100)/100;
        this.balance = random_b;
        return;
    }
    else{
      return;
    }
  }
  public void setCreditLimit(double cl){
    //also making a random credit limit with some invariants
    //described above
    double bal = getBalance();
    if(cl > 0 || 2*cl < balance){
      bal = Math.round(bal*100)/100;
      this.creditLimit = .1*bal;
      return;
    }
    else{
      
      cl = 2*bal;
      cl = Math.round(cl*100)/100;
      this.creditLimit = cl;
      return;
    }
  }
  //set our eqyals method and compareTO
  public boolean equals(Account otherAccount){
    return this.accountID == (otherAccount.accountID)     &&
           this.customer.equals(otherAccount.customer)    &&
           this.balance   == (otherAccount.balance)       &&
           this.creditLimit == (otherAccount.creditLimit) &&
           this.discountLevel == (otherAccount.discountLevel);
  }
  public int compareTo(Account otherAccount){
    if(this.balance > otherAccount.balance){
      return 1;
    }
    else if(this.balance == otherAccount.balance){
      return 0;
    }
    else{
      return -1;
    }
  }
  //finally toString

@Override
public String toString(){
    return "AccountID:   "+accountID+"\n"+customer.toString()+"\nBalance:  $"+balance+"\nCredit Limit:   $"+creditLimit+"\nDate Created:  "+dateCreated.toString()+"\nDiscount Level:  %"+(discountLevel*100);
}
}
