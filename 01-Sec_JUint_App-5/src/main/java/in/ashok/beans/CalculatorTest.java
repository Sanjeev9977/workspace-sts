package in.ashok.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

	@Test
	public void addTest() {
		
		Calculator c=new Calculator();
		
		int a=c.add(10,20);
		int e=30;
		
		assertEquals(e,a);
		
	}
}
