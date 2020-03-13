//Chauncey Smith

//Products file

public class Product{
  //set field variables
  private String name;
  private String description;
  //INVARIANT PRICE MUST BE POSITIVE
  private double price;
  //INVARIANT SKU MUST BE 10 CHARACTER LENGTH AND START WITH either 001,002,003,004,110
  private String sku;
 
  //now we set our constructors
  public Product(){}




  public Product(String name, String description, double price, String sku){
    setName(name);
    this.description = description;
    setPrice(price);
    setSKU(sku);
  }
  
  //now we make our getters and setters
  public void setSKU(String sku){
    //more validation
    if(sku.length() == 10){
      String x = sku.substring(0,3);
      if(x.equals("001") || x.equals("002") || x.equals("003") || x.equals("004") || x.equals("110")){
        this.sku = sku;
      }
    }
    else{
      this.sku = sku;
    }
  }
  //getters and setters, very basic flow from other files
  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
  public void setPrice(double price){
    //price cant be negatice
    if(price > 0){
      this.price = price;
    }
  }
  public double getPrice(){
    return price;
  }
  public boolean equals(Product otherProduct){
    return  this.name.equals(otherProduct.name)                 &&
            this.description.equals(otherProduct.description)   &&
            this.price == (otherProduct.price)                  &&
            this.sku.equals(otherProduct.sku);

  }
  //our tostring method
  public String toString(){
    return "Product Name: "+name+"\nProduct Description: "+description+"\nPrice: $"+price+"\nSKU: "+sku;
  }
}
