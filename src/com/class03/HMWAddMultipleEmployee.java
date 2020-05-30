package com.class03;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

import junit.framework.Assert;

public class HMWAddMultipleEmployee extends CommonMethods {
	
	@Test(dataProvider="getData")
	public void testAndLogin(String fname,String lname, String username, String password) {
		
		login.login();
		dashboard.navigateToAddEmployee();
		addEmp.employeeDetails(fname, lname);
		addEmp.chkLoginDetails.click();
		addEmp.userName.sendKeys(username);
		addEmp.userPassword.sendKeys(password);
		addEmp.confirmPassword.sendKeys(password);
		click(addEmp.save);
		
		takeScreenshot("screenshots/HRMS/"+ fname + lname +".png");
	
//	TakesScreenshot ts=(TakesScreenshot)driver;
//	File screen=ts.getScreenshotAs(OutputType.FILE);
//	try {
//		FileUtils.copyFile(screen, new File("screenshots/HRMS/"+ fname + lname +".png"));
//	}catch(IOException e) {
//		e.printStackTrace();
//	}
//	String expected=fname+" "+lname;
//	String actual=pdetails.verifyEmp.getText();
//	Assert.assertEquals(expected, actual);
	
}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][]data= {
				{"Leylaa","Acar","leylakkggkk","LLeyla12345678."},
				{"Semra","Turk","semrattgggttt","SSemra12345678."},
//				{"Ali","Can","alican","Alic12345678."},
//				{"Mary","Castle","marycast","Marycastle12345678."},
//				{"David","Smith","davids","Davidsmith12345678."},
				
		};
		return data;
		
	}
	
}
