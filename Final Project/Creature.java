
//Welcome to my final Project 
/*This will be our main class the "Creature" class with define many methods that
will detirmine behavior of our prey and predator
*/


//We want to make Creature abstract because there will be no Creatures called Creatures

import java.awt.Color;
import java.util.Random;

public abstract class Creature{

    //first our creature name, this will detirmine if they are a prey,predator, or a special creature 

    //our turn counter will detirmine certain types of behavaior for both prey and predator
    private int turnCounter;

    //health and damage are the basic stats for both prey and predator
    private int Health = 100;

    private int x;
    private int y;

    public abstract void move();
        //this will be our main method in use, every creature moves
    

    //this is our main method we want to protect
    protected void moveRandomly(){
        Random rand = new Random();
        int x = rand.nextInt(3)-1;
        int y = rand.nextInt(3)-1;
        
        //this gives our range in our grid and how big it is
        x = Math.min(Math.max(getX()+x,0), GRID.WIDTH-1);
        y = Math.min(Math.max(getY()+y,0), GRID.HEIGHT-1);
        
            GRID.C[getX()][getY()] = null;
            GRID.C[x][y] = this;
            setX(x);
            setY(y);
    
    }


    public abstract void attack();
        //this method can be used by prey but mainly predator

    public abstract void death(Creature c);
    

    public abstract Creature replicate();


    public abstract void stay();
        //if prey or predator cant move becasue of restrictions, then they will stay

    public abstract int scan();

    public abstract void chooseAction();
        //this will detirmine where the creature will move
       // System.out.println("This is the chooseAction method");
 

    public abstract Color color();
        //this method will return a color based off of the health of the creature




    
        //our getters and setters

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getTurnCounter(){
        return turnCounter;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public int getHealth(){
        return Health;
    }
}