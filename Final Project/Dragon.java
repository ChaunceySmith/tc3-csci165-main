//

import java.awt.Color;
public class Dragon extends Creature{

    private int health = 50;

    private int dmg = 10;

    public Dragon(int x,int y){
        stay();
        
    }

    //I did not extend dragon to creatures because I want the dragon to have different behaviors than creatures
    @Override
    public void stay(){
        GRID.C[getX()][getY()]=this;
        
    }

    //the attack can be commanded by the nazguls
    @Override
    public Color color(){
        return Color.RED;
    }

    @Override
    public void chooseAction() {

        stay();
    }

    @Override
    public int scan(){

        return 0;
    }


    @Override
    public void move(){

        stay();
        //GRID.C[getX()][getY()] = null;

        //GRID.C[getX()+1][getY()+1] = this;
    }

    @Override
    public void attack(){
        stay();
    }

    @Override
    public void death(Creature c){
        stay();
    }

    @Override
    public Dragon replicate(){
        return new Dragon(getX()+1,getY()+1);
    }


}