 //NOW WE USE INHERITANCE TO USE CYLINDER
 public class Cylinder extends Circle{
    //set height
    private double height;

    //now we make default constructor
    public Cylinder(){
        super();    //call superclass
        this.height = 1.0;
    }

    //call super class, and set height
    public Cylinder(double height){
        super();
        this.height = height;
    }

    //constructor that takes x and y point as well as radius and height
    public Cylinder(int x, int y, int radius, double height){
        super(x,y,radius);
        this.height = height;
    }

    public Cylinder(Point point,int radius, double height){
        super(point, radius);
        this.height = height;
    }

    public double getHeight(){
        return height;
    }
    //then we can getArea from circle and multiply it by height
    public double getVolume(){
        return getArea() * height;
    }

    //then our basic toString and equals method
    @Override
    public boolean equals(Object obj){
    //first identity check
    if (this == obj)                    return true;
    // then null check
    if (obj == null)                    return false;
    // finally origin check
    if (getClass() != obj.getClass())   return false;
    
    Cylinder cylin = (Cylinder) obj;
    return this.height == cylin.height;
    }

    @Override
    public String toString(){
        return super.toString()+"Height = "+height;
    }
}