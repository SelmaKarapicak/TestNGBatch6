package com.utils;

import com.pages.AddEmployeePageElements;
import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.pages.PersonalDetailsPageElements;

//initializes all page classes and stores references in static variables
//that will be called/used in test classes
public class PageInitializer extends BaseClass {
	
	public static LoginPageElements login;
	public static AddEmployeePageElements addEmp;
	public static DashBoardPageElements dashboard;
	public static PersonalDetailsPageElements pdetails;
	
	public static void initialize() {
		
		 login=new LoginPageElements();
		 dashboard=new DashBoardPageElements();
		 addEmp=new AddEmployeePageElements();
		 pdetails=new PersonalDetailsPageElements();
	}

}
