//Chauncey Smith
//Lab 5
//March 3rd


import java.util.Scanner;
import java.io.File;
import java.io.IOException;

//This file will contain all characteristics of the address for the customer

//first we make the class public so we can access it with other files
public class Address{
  //now we set our field variables
  private String street;
  private String city;
  private String state;
  private String zip;


  /*next we make our constructors, one with zero arugements, the other with
  all methods called*/

  public Address(){}

  public Address(String street, String zip){
    this.street = street;
    setZip(zip);
  }
  public Address(Address copy){
    this.street = copy.street;
    this.city = copy.city;
    this.state = copy.state;
    this.zip = copy.zip;
  }
  //now we make our setter method, for set street
  public void setStreet(String street){
    //"this" referencing the field variable is making the street of setStreet
    this.street = street;
  }
  //not we have a getter method
  public String getStreet(){
    return street;
  }
  //another getter method for city
  public String getCity(){
    return city;
  }
  public String getState(){
    return state;
  }
  //now we have a setter method for zip
  //this method also will set state and zip
  public void setZip(String zip){
    if(zip.length() > 5 || zip.length() < 5){
      this.zip = "Invalid Zip Code";
      return;
    }

    this.zip = zip;
    
    setCityState(zip);
  }
  public String getZip(){
    return zip;
  }
  //now we make our equals method to test similar addresses

  //we need to do a deep comparison for each aspect of the address

  //note, i used your equals as a template
  public boolean equals(Address otherAddress){
    return 	this.street.equals(otherAddress.street) 	&&
            this.city.equals(otherAddress.city) 		  &&
            this.state.equals(otherAddress.state) 		&&
            this.zip.equals(otherAddress.zip);
  }

  //my toString method, also note it is like yours
  @Override
  public String toString(){
    return "Address: "+street + ", " + city + " " + state + ", " + zip;
  }

  private void setCityState(String zip){

    //this is when things get complicated
  
    try{
        //open the file and read through it using a buffered reader
        File fileRead = new File("zip_code_database.csv");
        //create fileScan
        Scanner fileScan = new Scanner(fileRead);
  
        //now we make a while loop
        while(fileScan.hasNextLine()){
                  
            //we want to take the line that the file scan has so we can parse and take substring
            String line = fileScan.nextLine();

            if(line.substring(0, 5).equals(zip)) {
            
              //now we need to split the values at the comma
              //we want to go to the fifth comma becasue it is 
              String[] split = line.split(",",5);
          
              String rest = parseValues(split[4]);
              rest = parseValues(rest);

              String state = rest.substring(0, rest.indexOf(","));

              //take out slashes for city
              this.city = split[3].replace("\"", "");
              this.state = state;

              return;
            }
        }
        fileScan.close();
    }

    catch(IOException e){
        System.out.println("File not Found");
      }
}

private String parseValues(String x){
    //find the quote and splice it, then add two buecasue of comma
    if(x.indexOf("\"") == 0){
        return x.substring(x.indexOf("\",",1) + 2);
    }
    //if it starts with comma add one from the index and take the rest of x
    return x.substring(x.indexOf(",")+1);
}
}


