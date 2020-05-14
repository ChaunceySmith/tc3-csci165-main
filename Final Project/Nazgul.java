//Nazgul class

import java.util.Random;

import java.awt.Color;
public class Nazgul extends Creature{

    //I will implement weapons later
    //private Items
    private final int SCREAMDMG = 25;
    private final int BLADEDMG = 100;

    private int nazgulTurnCounter = 0;
    private int nazgulDecay;
    //private Hobbit hobbit;

    //each nazgul will get a dragon
   // private Dragon dragon;

    public Nazgul(int x, int y){
        super();
        setX(x);
        setY(y);
        GRID.C[x][y] = this;
    }



    @Override
    public void chooseAction() {

        //main method constantly moving

        nazgulTurnCounter = nazgulTurnCounter+1;
        nazgulDecay = getHealth() - 5;
        if(nazgulDecay == 0){
            death(this);
        }
        int scan_result = scan();

        if(scan_result == 1){
            move();
        }

        if(scan_result == 0 && nazgulTurnCounter == 20){
            //stay();
            replicate();
            //nazgulTurnCounter = 0;
        }

        if( scan_result == 0 && nazgulTurnCounter == 10){
            replicate();
        }
        move();
    }

    @Override
    public int scan(){

        if(getX()==0 || getX()==19||getY()==0||getY()==19){
            return 0;
        }
        for(int i=getX()-1; i <getX()+ 2; i++){
            for(int j = getY()-1; j< getY()+ 2; j++){
                if(GRID.C[i] != null && GRID.C[i][j] != null){
                    if(GRID.C[i][j].equals(GRID.C[getX()][getY()])){
                        continue;
                    }
                    return 1;
                }
            }
        }
        return 0;
    }


    @Override
    public void move(){

         if(scan() == 1){
             attack();
             moveRandomly();
         }  


        if(getX()==0){
            GRID.C[getX()][getY()]=null;
            GRID.C[getX()+1][getY()] = this;
            moveRandomly();
        }
        if(getY()==0){
            GRID.C[getX()][getY()]=null;
            GRID.C[getX()][getY()+1] = this;
            moveRandomly();
        }

        if(getX()==19){
            GRID.C[getX()][getY()]=null;
            GRID.C[getX()-1][getY()] = this;
            moveRandomly();
        }

        if(getY()==19){
            GRID.C[getX()][getY()]=null;
            GRID.C[getX()][getY()-1]=this;
            moveRandomly();
        }

        else{
             moveRandomly();
            
         }
        //GRID.C[getX()][getY()] = null;

        //GRID.C[getX()+1][getY()+1] = this;
    }

    @Override
    public void attack(){

       // Hobbit h = (Hobbit) c;
        for(int i = getX()-1; i < getX() + 2; i++ ){
            for(int j = getY()-1; j < getY() + 2; j++){
                if(GRID.C[i] != null && GRID.C[i][j] != null){
                    if(GRID.C[i][j].equals(GRID.C[getX()][getY()])){
                        continue;
                        }
                    GRID.C[i][j] = null;
                    GRID.C[getX()][getY()]=null;
                   
                    Dragon d = new Dragon(i,j);
                    
                    nazgulDecay = getHealth() + 20;
                }
            }
        }
    }

    @Override
    public void stay(){
        
    }

    @Override
    public void death(Creature c){
        Nazgul n = (Nazgul) c;
        n = null;
        
    }

    @Override
    public Nazgul replicate(){
        if(getX()==0 || getX()==19){
            return new Nazgul(1,getY());
        
        }
        if(getY()==0||getY()==19){
            return new Nazgul(getX(),1);
        }
        return new Nazgul(getX()+1,getY()+1);


        
    }


    @Override
    public Color color(){
        return Color.BLACK;
    }
        
}

