import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {
	Address a = new Address("Calhoun Rd","49220");
	Customer c = new Customer("Chauncey","Smith","chaunceysmith@myjacs.org",a);

	@Test
	void testCustomertoString() {
		//first lets just test toString
		String str = c.toString();
		String desired_result = "Name:  Chauncey Smith\nEmail: chaunceysmith@myjacs.org\nAddress:  Calhoun Rd Addison MI, 49220";
		assertEquals(desired_result,str);
	}
	
	@Test
	void testEmail() {
		Customer c_2 = new Customer("Bob","Dash","aushfi@",a);
		String desired_result = "None on File";
		assertEquals(desired_result, c_2.getEmail());
	}
	
	@Test
	void testEmail2() {
		Customer c_3 = new Customer("Dirty","Dan","1234ewr",a);
		String desired_result = "None on File";
		assertEquals(desired_result, c_3.getEmail());
	}
	
	@Test
	void testEmail3() {
		Customer c_4 = new Customer("PinHead","Larry","sifuh@sjhf@.com",a);
		String desired_result = "None on File";
		assertEquals(desired_result,c_4.getEmail());
	}

	@Test
	void testEquals() {
		Customer c_5 = new Customer("Harry","Patrick","hpaary@gamil.com",a);
		boolean desired_result = true;
		boolean real = c_5.equals(c_5);
		assertEquals(desired_result,real);
	}
}
