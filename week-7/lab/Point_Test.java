import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Point_Test {

	@Test
	void testDistance() {
		Point p = new Point(3,4);
		double real_result = p.distance(5,6);
		double desired_result = 2.8284271247461903;
		assertEquals(desired_result,real_result);
	}
	
	@Test
	void testDistance2() {
		Point p = new Point(13,19);
		double real_result = p.distance(12,4);
		double desired_result = 15.033296378372908;
		assertEquals(desired_result,real_result);
	}
	
	@Test
	void testDistance3() {
		Point p = new Point(5,6);
		double real_result = p.distance(8,9);
		double desired_result = 4.242640687119285;
		assertEquals(desired_result,real_result);
	}
	
	@Test
	void testDistance4() {
		Point p = new Point();
		double real_result = p.distance(5,6);
		double desired_result = 7.810249675906654;
		assertEquals(desired_result,real_result);
				
	}
	
	@Test
	void testtoString() {
		Point p = new Point(4,5);
		String real = p.toString();
		String desired = "(4,5)";
		assertEquals(real,desired);
	}
	
	@Test
	void testCircle() {
		Circle c = new Circle(1,1,1);
		Circle c2 = new Circle(2,2,2);
		double real = c.distance(c2);
		double desired = 1.4142135623730951;
		assertEquals(real,desired);
	
	}
	
	@Test
	void testArea() {
		Point p = new Point(2,3);
		Circle c = new Circle(p,3);
		double real = c.getArea();
		double desired = 28.274333882308138;
		assertEquals(real,desired);
	}
	
	@Test
	void testCircum() {
		Point p = new Point(1,2);
		Circle c = new Circle(p,3);
		double real = c.getCircumference();
		double desired = 18.84955592153876;
		assertEquals(real,desired);
	}
	
	@Test
	void testCylinVolume() {
		Point p = new Point(3,5);
		Cylinder cy = new Cylinder(p,2,3.0);
		double real = cy.getVolume();
		double desired = 37.69911184307752;
		assertEquals(real,desired);
		
	}
}
