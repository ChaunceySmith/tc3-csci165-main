import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {
	Address a = new Address("Calhoun Rd","49220");
	Customer c = new Customer("Chauncey","Smith","chaunceysmith@myjacs.org",a);
	Date d = new Date(3,12,2020);
	Account ac = new Account("CS23621",c,45.21,150.00,0.2,d);

	
	
	@Test
	
	void testCreditLimit() {
		Account a_2 = new Account("ufiauhf",c,-45.0,-150.0,d);
		double credit_limit = a_2.getCreditLimit();
		 double desired_result = 0.0;
		 assertEquals(desired_result,credit_limit);
			
		
	}


	@Test
	
	void testBalance() {
		Account a_2 = new Account("ufiauhf",c,-45.0,-150.0,d);
		double balance = a_2.getBalance();
		double desired_result = 0.0;
		 assertEquals(desired_result,balance);
			
		
	}
	
	@Test
	
	void testAccountID() {
		Account a_3 = new Account("Platty",c,34.5,23.5,d);
		String desired_result = "CHNCYSMTH31220205";
		String actual = a_3.getAccountID();
		assertEquals(desired_result,actual);
	}
}
