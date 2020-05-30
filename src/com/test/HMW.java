package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

//Automate user stories below:
//US 12678 As an Admin I should be able to create login credentials while adding employee
//
//US 67789 As an admin while adding employee if I leave required fields empty I should see “Required” message
//Note: first name and last name are required fields

public class HMW extends CommonMethods{
	
	@Test
	public void login() {
		login.login();
	}
	  
	@Test
	 public void navigateAndAddEmployee() {
		login.login();
		dashboard.navigateToAddEmployee();
		sendText(addEmp.firstName,ConfigsReader.getProperty("employeeFirstname"));
		sendText(addEmp.lastName,ConfigsReader.getProperty("employeeLastname"));
		sendText(addEmp.uploadpic, ConfigsReader.getProperty("filePath"));
		}
		
	@Test
	public void loginCredentials() {
		login.login();
		dashboard.navigateToAddEmployee();
		sendText(addEmp.firstName,ConfigsReader.getProperty("employeeFirstname"));
		sendText(addEmp.lastName,ConfigsReader.getProperty("employeeLastname"));
		sendText(addEmp.uploadpic, ConfigsReader.getProperty("filePath"));
		addEmp.chkLoginDetails.click();
		sendText(addEmp.userPassword, "SelmaKara12345678.");
		sendText(addEmp.confirmPassword,"SelmaKara12345678.");
		wait(2);
		click(addEmp.save);
		wait(2);
	}
	
	@Test
	public void required() {
		login.login();
		addEmp.chkLoginDetails.click();
		sendText(addEmp.userPassword, "SelmaKara12345678.");
		sendText(addEmp.confirmPassword,"SelmaKara12345678.");
		click(addEmp.save);
		
		String expected="Required";
		String actualFname=addEmp.requiredfirstName.getText();
		String actualLname=addEmp.requiredlastName.getText();
		Assert.assertEquals(actualFname, expected,"First name is required");
		Assert.assertEquals(actualLname, expected,"Last name is required");
	}
	
	

}
