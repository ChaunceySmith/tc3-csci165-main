
public class Food{
    private int healthRestored = 25;

    public Food(){
        
    }

    public int healthGain(Hobbit h){
        return healthRestored + h.getHealth();
     }
}