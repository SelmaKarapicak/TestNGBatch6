package com.class04;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class MyListenerDeneme extends CommonMethods{
	
	@Test
	public void validLogin() {
		login.login();
	}
	
	@Test
	public void invalidLogin() {
		Assert.assertTrue(false);
	}
}
