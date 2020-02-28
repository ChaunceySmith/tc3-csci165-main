//Chauncey Smith
//Lab 4
//This is where our temperature methods will go

public class Temperature{

  //static class features
  public static enum    Scale{C,F};
  private Scale scaleF = Scale.F;
  private Scale scaleC = Scale.C;
  //setting a temperature value
  private double temp_value = 0.0;
  //now we set an enumeration for Celsius

  //public static enum    Temperature{C};
  //private Temperature    temp    = Temperature.C;
  //I am going to make a constructor
  public Temperature(){}

  public Temperature(Scale mode){
    setValue();
    setScale(mode);
    setBoth(mode, temp_value);
    equals(temp_value);

    //compareTo(mode);
    }



  //now we make two getter methods that return the temperature
  public float getTemperatureC(double degrees){
    //to find the temperature in Celsius we must use the conversion
    double DegreesC = 5 * ((degreesF - 32)/9);
    //round the value
    float roundedC = Math.round(DegreesC);
    //return the value in Celsius
    return roundedC;
  }

  public float getTemperatureF(double degreesC){
    //same thing as above just converting to farhenheit
    double DegreesF = (9 * (degreesC)/5) + 32;

    float roundedF = Math.round(DegreesF);
    //return value in farhenheit
    return roundedF;
  }


  //now we make our setter methods

  public void setValue(){
    //set a value as above, but added to the arguement of temp
    temp_value = temp_value;

}

  //now we set scale that will return a double
  public void setScale(Scale c){
    //call the method of getting temp c
    if(c == Scale.C) c = Scale.F;
    else{
      c = Scale.C;
    }
    //return the temp

  }

  //now we set a scale to both
  public void setBoth(Scale b, double temper){
    //if it is Celsius we want to convert it to farhenheit
    if(b == Scale.F){
      double temp_f = getTemperatureF(temper);
    }
    //vice versa
    else{
      double temp_c = getTemperatureC(temper);
    }
  }
  //now we create two comparison methods to see if the temperatures are equal
  public boolean equals(Temperature t){
    if((t.temp_value == this.temp_value) && (t.scaleF == this.scaleF)){
      return true;
    }
    else{
      return false;
    }
  }

  private int compareTo(Temperature t){
    if(t.temp_value < this.temp_value){
      return 1;
    }
    if(t.temp_value == this.temp_value){
      return 0;
    }
    if(t.temp_value > this.temp_value){
      return -1;
    }
    else{
      return 100;
    }
  }

  @Override
  public String toString(){
      String state = "";
      if(scaleC == Scale.C){
        state = ("The temperature is in Celsius and it is "+ getTemperatureC(temp_value)+" and the value == Farhenheit " +equals(temp_value));
      }
      if(scaleF == Scale.F){
        state = ("The temperature is in Farhenheit and it is "+ getTemperatureF(temp_value)+" and is equal to Celsisus " +equals(temp_value));
      }
      else   state = "No temperature recorded";
      return state;
  }
}
