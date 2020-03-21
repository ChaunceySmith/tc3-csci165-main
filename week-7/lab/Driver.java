//Chaucney Smith 
//lab 6

//Driver class for finding distance between two points

import java.util.ArrayList;


public class Driver{

    public static void main(String[] args){
        //create an array list of Point
        ArrayList<Point> points = new ArrayList<Point>();
        //basic for loop, we want to only get 10 points
        for(int i=0;i<11;i++){
            //call the constructor
            Point x = new Point(i,i);
            //add to the array list
            points.add(x);
            //call toString
            System.out.println(x.toString());
            
        }
        //now lets test
        Point p1 = new Point(3,4);
        System.out.println(p1.distance());

        Point p2 = new Point(3,4);
        Point p3 = new Point(5,6);
        System.out.println(p2.distance(p3));

        Point p4 = new Point(7,8);
        System.out.println(p4.distance(10,13));


        //THIS IS FOR OUR CIRCLE CLASS

        //create arrayList
        ArrayList<Circle> circles = new ArrayList<Circle>();
        //fill it up with circles
        for(int i=0;i<11;i++){
            Circle x = new Circle(i,i,i);
            circles.add(x);
            System.out.println(x.toString());
        }
        //NOW WE TEST RESULTS
        Circle C1 = new Circle(3,4,1);
        Circle C2 = new Circle(5,6,2);
        System.out.println(C1.distance(C2));

        Circle C3 = new Circle(p3,3);
        System.out.println(C3.distance(C1));

        Circle C4 = new Circle();
        System.out.println(C4.distance(C3));

        //THIS IS FOR THE CYLINDER SUBCLASS

        Cylinder cylin = new Cylinder();
        System.out.println(cylin.getVolume());

        Cylinder cylin2 = new Cylinder(p3, 2, 2.0);
        System.out.println(cylin2.getVolume());

        Cylinder cylin3 = new Cylinder(4,5,6,3.0);
        System.out.println(cylin3.getVolume());

        double circum = cylin.getCircumference();
        System.out.println(circum);

        double area = cylin2.getArea();
        System.out.println(area);


        //EXAMINING POLYMORPHIC BEHAVIOR
        Circle[] circle = new Circle[10];
        for(int i = 0; i < 5; i++){
            Cylinder cy = new Cylinder(i,i,i,1.0);
            circle[i] = cy;
            System.out.println(cy.toString());
            cy.getVolume();
        }

        for(int i=6;i<10;i++){
            Circle cir = new Circle(i,i,i);
            circle[i] = cir;
            System.out.println(cir.toString());
            //cir.getVolume();
            //CANNOT CALL A PARENT TO A CHILD METHOD ONLY CYLINDER CAN DO IT
        }

        //now we create object to see how broad we can get our code
        
        //make object size 12
        Object[] obj = new Object[12];
        //setting 4 loops to test it
        for(int i=0;i<3;i++){
            Point p = new Point(i,i);
            obj[i] = p;
            System.out.println(p.toString());
        }
        for(int i=3;i<6;i++){
            Circle p = new Circle(i,i,i);
            obj[i] = p;
            System.out.println(p.toString());
        }

        for(int i=6;i<9;i++){
            Cylinder p = new Cylinder(i,i,i,1.0);
            obj[i] = p;
            System.out.println(p.toString());
        }

        for(int i=9;i<12;i++){
            Address ad = new Address("Calhoun Rd","49220");
            obj[i] = ad;
            System.out.println(ad.toString());
        }
        //OMG THAT IS SO COOL!!!! THIS OPENS THE DOORS TO MANY THINGS
    }
}