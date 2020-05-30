package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("This is Before Class");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("This is After Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is after method");
	}
	
	@Test
	public void test1() {
		System.out.println("This is test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("This is test 2");
	}
	
	public void test3() {
		System.out.println("This is test 3");
	}

}
