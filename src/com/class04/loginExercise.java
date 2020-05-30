package com.class04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;
import com.utils.ExcelUtility;

public class loginExercise extends CommonMethods {
	
 @Test(dataProvider="empInfo")
 public void login(String username, String password) {
	 
	 login.loginpar(username,password);
 }
 
 @DataProvider
 public Object[][] empInfo(){
	 return ExcelUtility.excelToArray(Constants.TESTDATA_FILEPATH, "Sheet1");
 }

}
