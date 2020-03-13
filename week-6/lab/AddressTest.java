import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddressTest {

	Address test_ad = new Address("Calhoun Rd", "49220");
	@Test
	void testAddress() {
		Address test_ad_2 = new Address("Calhoun Rd", "49220");
		boolean x = test_ad.equals(test_ad_2);
		assertTrue(x);
	}
	@Test
	void testAddress_2() {
		Address test_ad_3 = new Address("Fairview Dr", "13053");
		Address test_ad_4 = new Address("Fairview Dr", "13053");
		boolean y = test_ad_3.equals(test_ad_4);
		assertTrue(y);
	}
	@Test
	void testValidZip() {
		
		String zip_one = "283653757";
		Address x = new Address("Calhoun Rd",zip_one);
		String zip = "Invalid Zip Code";
		assertEquals(zip,x.getZip());
	}
	@Test
	void testValidZip2() {
		String zip_two = "4922";
		Address y = new Address("Calhoun Rd",zip_two);
		String zip_three = "Invalid Zip Code";
		assertEquals(zip_three, y.getZip());
		
	}
	@Test
	void testEquals() {
		Address z = new Address("Calhoun Rd","49220");
		boolean desired_result = true;
		boolean real = z.equals(z);
		assertEquals(desired_result,real);
	}
	
}
