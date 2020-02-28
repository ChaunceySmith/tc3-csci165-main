import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemperatureDebugTest {

	Temperature t = new Temperature();
	
	@Test
	void testTOFarhenheirt() {
		double one = 0.0;
		double desired_result = 32.0;
		float real_result = t.getTemperatureF(one);
		assertEquals(desired_result, real_result);
	}

	void testTOCelsisus() {
		double one = 32.0;
		double desired_result = 0.0;
		float real_result = t.getTemperatureC(one);
		assertEquals(desired_result, real_result);
	}
	void testTOC() {
		double one = 212.0;
		double desired_result = 100.0;
		float real_result = t.getTemperatureC(one);
		assertEquals(desired_result, real_result);
	}
}
