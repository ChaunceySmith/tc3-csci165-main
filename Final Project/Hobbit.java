/* This is our prey class, hobbits have items and will have distinct behaviors

*/

import java.util.Random;
import java.awt.Color;

public class Hobbit extends Creature{

    //a hobbit will have starting food, "lotis bread"
    //a hobbit will also start with a small sword
    
    //Map m = new Map();
    private Nazgul nazgul;
    private Food lotusBread = new Food();
    private int hobbitCounter = 0;
    private int healthDecay;

    public Hobbit(int x, int y){
        super();
        setX(x);
        setY(y);
        GRID.C[x][y] = this;
    }

    @Override
    public void chooseAction(){
        //account for health decay
        healthDecay = getHealth() - 5;
        //now scan for Nazguls

        if(healthDecay == 0){
            death(this);
        }
        int scan_result = scan();

        if(scan_result == 1){
            move();
        }

        if(scan_result == 0 && healthDecay < 75){
            stay();
        }

       if(scan_result == 0 && hobbitCounter == 15){
            replicate();
            hobbitCounter = 0;
        }

        else{
            move();
           
        }
        hobbitCounter = hobbitCounter + 1;
    }
    

    @Override
    public int scan(){
        // for(int i=getX()-1; i <getX()+2; i++){
        //     for(int j = getY()-1; j< getY()+ 2; j++){
        //         if(GRID.C[i] != null && GRID.C[i][j] != null){
        //             return 1;
        //         }
        //     }
        // }
            return 0;
            
        
    }
    

    @Override
    public void move(){


        
        if(scan() == 1){
            for(int i=getX()-1; i <getX()+ 2; i++){
                for(int j = getY()-1; j< getY()+ 2; j++){
                    if(GRID.C[i] != null && GRID.C[i][j] != null){
                        int x = GRID.C[i][j].getX();
                        int y = GRID.C[i][j].getY();

                        int deltaX = x - getX();
                        int deltaY = y - getY();

                        GRID.C[getX()][getY()] = null;
                        GRID.C[getX()-deltaX][getY()-deltaY] = this;

                    }
                }
            }
            moveRandomly();
        }
        if(getX() == 0){
            GRID.C[getX()][getY()] = null;
            GRID.C[19][getY()] = this;
            setX(19);
            setY(getY());
            //GRID.C[18][getY()] = this;
            moveRandomly();
        }
        if(getY() == 0){
            GRID.C[getX()][getY()] = null;
            GRID.C[getX()][19] = this;
            //GRID.C[18][getY()] = this;
            setX(getX());
            setY(19);
            moveRandomly();
        }
        if(getX()==19){
            GRID.C[getX()][getY()] = null;
            GRID.C[0][getY()] = this;
            setX(0);
            setY(getY());
            //GRID.C[18][getY()] = this;
            moveRandomly();
        }
        if(getY()==19){
            GRID.C[getX()][getY()] = null;
            GRID.C[getX()][0] = this;
            //GRID.C[18][getY()] = this;
            setX(getX());
            setY(0);
            moveRandomly();
        }



    

        
        else{  
        moveRandomly();
            
        }         

    
    }

        
             


    @Override
    public void attack(){
        //I have decided that hobbits will not attack

    }

    @Override
    public void death(Creature c){
        Hobbit h = (Hobbit) c;
        h = null;
    }

    @Override
    public void stay(){
        GRID.C[getX()][getY()]=this;
       // lotusBread.healthGain(this);
    }

    @Override
    public Creature replicate(){
        if(getX()==0 || getX()==19){
            return new Hobbit(1,getY());
        
        }
        if(getY()==0||getY()==19){
            return new Hobbit(getX(),1);
        }
        return new Hobbit(getX(),getY()+1);
        
    }
        
        

    @Override
    public Color color(){
        if(getHealth() < 95){
            return Color.YELLOW;
        }
        return Color.GREEN;
    }
    
    
}

  
