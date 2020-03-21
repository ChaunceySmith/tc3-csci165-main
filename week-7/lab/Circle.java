//Chauncey Smith

//circle class
//import java.lang.Math.*;

public class Circle{
    //first we start with composition, and make an instance of point
    private Point center = new Point();
    
    //declare the radius as being one
    private int radius = 1;

    //private double area = 0.0;

    //now we set up our constructors
    public Circle(){}
        
    //one to set x,y,and radius
    public Circle(int x,int y, int radius){
        setRadius(radius);
        setCenter(x,y);
    }

    //this constructor takes a point and radius
    public Circle(Point center, int radius){
        setCenter(center);
        setRadius(radius);
    }

    //now we make our getters and setters
    public int getRadius(){
        return radius;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public Point getCenter(){
        return center;
    }

    public void setCenter(Point center){
        this.center = center;
    }

    //alot of these methods will be called from point
    //this is so we dont have to rewrite code
    public int getCenterX(){
        int x_point = center.getX();
        return x_point;
    }

    public void setCenterX(int x){
        int p = center.getX();
        this.center.setX(p);
    }

    public int getCenterY(){
        int y_point = center.getY();
        return y_point;
    }

    public void setCenterY(int y){
        int p = center.getY();
        this.center.setY(p);
    }

    public int[] getCenterXY(){
        return this.center.getXY();
    }

    public void setCenter(int x,int y){
        this.center.setXY(x,y);
    }

    //basic toString
    @Override
    public String toString(){
        return "Circle[radius = "+radius+", center = "+center.toString()+"]";
    }

    //now we create methods for area circum and distance between two circles
    public double getArea(){
        double pi = Math.PI;
        double area = (pi*(Math.pow(radius,2)));
        return area;
    }

    public double getCircumference(){
        double pi = Math.PI;
        double diam = radius * 2;
        double circum = pi*diam;
        return circum;
    }

    public double distance(Circle otherCircle){
        double dis_1 = center.distance(otherCircle.center);
        return dis_1;
    }

    //set equals method
    @Override
    public boolean equals(Object obj){
        //first identity check
        if (this == obj)                    return true;
        // then null check
        if (obj == null)                    return false;
        // finally origin check
        if (getClass() != obj.getClass())   return false;

        Circle circle = (Circle) obj;  //now we downcast MAKING OBJECT A CIRCLE
        return this.radius == circle.radius && this.center == circle.center;
    }

}
