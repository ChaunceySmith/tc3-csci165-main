//Chauncey Smith

//this is our customer file, we will call the address in this file

public class Customer{
  //set field variables
  private String firstName;
  private String lastName;
  

  //INVARIANT EMAIL MUST CONTAIN "@" AND MUST BE GREATER THAN 2 CHARACTERS @ MUST
  //OCCUR BEFORE DOMAIN
  private String email;
  //call the address class
  private Address address;

  //now we make our constructors

  //first an empty constructor
  public Customer(){}

  public Customer(String firstName, String lastName, String email, Address address){
    this.firstName = firstName;
    this.lastName = lastName;
    setEmail(email);
    this.address = address;
  }
  public Customer(Customer copy){
    this.firstName = copy.firstName;
    this.lastName = copy.lastName;
    this.email = copy.email;
    this.address = new Address(copy.address);
  }

  public void setName(String first, String last){
    this.firstName = first;
    this.lastName = last;
  }

  public void setEmail(String email){
    //now we set up conditions that have to be met
    if(email.contains("@") == false){
      this.email = "None on File";
      return;
    }
    int x = email.indexOf("@");
    String y = email.substring(x+1);
      if(x == 0 || y.contains("@") == true || email.length() < 2 || y.length() < 3){
      this.email = "None on File";
      return;
    }
    else{
      this.email = email;
    }
  }
  public String getName(){
    return firstName +" " +lastName;

  }
  
  public String getEmail(){
    return email;
  }
  public boolean equals(Customer otherCustomer){
    //same equals method as before, doing a deep comparison of each field variable
    return this.firstName.equals(otherCustomer.firstName) &&
           this.lastName.equals(otherCustomer.lastName)   &&
           this.email.equals(otherCustomer.email)         &&
           this.address.equals(otherCustomer.address);
  }
  @Override
  public String toString(){
    
    return "Name:  "+firstName+" "+lastName+"\nEmail: "+email+"\n"+address.toString();
  }
}