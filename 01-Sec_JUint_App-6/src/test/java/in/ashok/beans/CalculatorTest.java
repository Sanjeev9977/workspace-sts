package in.ashok.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	@Test
	public void addTest() {
		
		Calculator c=new Calculator();
		
		int a=c.add(10,20);
		int e=30;
		
		assertEquals(e,a);
	}
	
	@Test
	public void mulTest() {
Calculator c=new Calculator();
		
		int a=c.mul(2,2);
		int e=4;
		
		assertEquals(e,a);
	
		
	}

}
