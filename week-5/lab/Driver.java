//Chauncey Smith
//Lab 4

//This is our main method and execution will take place

public class Driver{

  public static void main(String[] args){
    Temperature t = new Temperature();
    Temperature t_one = new Temperature(Temperature.Scale.C);
    Temperature t_two = new Temperature(Temperature.Scale.F);
    System.out.println(t.getTemperatureC(156.4)+","+t.getTemperatureF(45.3));
    //System.out.println(t_two.compareTo(100));
    System.out.println(t_two); //temp given in farhenheit
    System.out.println(t_one); //temp in Celsius


  }
}
