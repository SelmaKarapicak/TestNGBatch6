package com.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeMethod(alwaysRun=true) //to make this method run before every @Test method
	public static void setUp()  {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		switch(ConfigsReader.getProperty("browser").toLowerCase()) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			 driver=new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver=new FirefoxDriver();
			break;
			default:
				throw new RuntimeException("Browser is not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url"));
		
		//initialize all page objects as part of setup
		PageInitializer.initialize();
	}
	
	public static void wait(int num) {
		try {
			Thread.sleep(num*1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod(alwaysRun = true) //to make this method to run after every @Test method
	public static void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
