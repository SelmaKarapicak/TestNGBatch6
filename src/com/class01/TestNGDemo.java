package com.class01;

import org.testng.annotations.Test;

public class TestNGDemo {
	//ascending ordera gore print ediyor -->1,3,2
	@Test
	public void testOne() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	}
	
	@Test
	public void testTwo() {
		System.out.println("Test 2");
	}
	
	@Test
	public void testThree() {
		System.out.println("Test 3");
	}
	
	
	

}
