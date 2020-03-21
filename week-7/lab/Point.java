//Chauncey Smith
//Date 3/13/2020

public class Point{

    //set private variables

    //set x and y
    private int x = 0;
    private int y = 0;

    //set our constructors

    //a no arg constructor will set default location to 0,0
    public Point(){
        this.x = 0;
        this.y = 0;
        distance();
    }
    
    //one to set a x and y coordinate
    public Point(int x,int y){
        //call method verification
        setX(x);
        setY(y);
        distance(x,y);
    }

    //now we set our setters and getters
    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x=x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    //this getter returns type int array
    public int[] getXY(){
        int coordinates[] = {x,y};
        return coordinates;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    //these our the distance methods, a little messy
    public double distance(int x2, int y2){
        return Math.sqrt((Math.pow((x2-x),2)+Math.pow((y2-y),2)));
    }

    public double distance(Point otherPoint){
        return Math.sqrt((Math.pow((otherPoint.x-x),2)+Math.pow((otherPoint.y-y),2)));
    }

    public double distance(){
        return Math.sqrt((Math.pow((this.x-0),2)+Math.pow((this.y-0),2)));
    }

    

    //toString method is (0,0)
    @Override
    public String toString(){
        return "("+x+","+y+")";
    }

    //finally our equals method
    @Override
    public boolean equals(Object obj) {
        // idenitity check
        if (this == obj)                    return true;
        // null check
        if (obj == null)                    return false;
        // origin check
        if (getClass() != obj.getClass())   return false;

        Point other = (Point) obj;                  // down cast
        return this.x == other.x && this.y == other.y;
    }
}