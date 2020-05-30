package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer {
	
	/**
	 * This method that clears and send keys
	 * @param element
	 * @param text
	 */
	
	public static void sendText(WebElement element, String text) {
		
		element.clear();
		element.sendKeys(text);
	}
	
	/**
	 * Method checks if radio/checkbox is enabled and clicks it
	 * @param radioOrcheckBox
	 * @param value
	 */
	
	public static void clickRadioOrCheckBox(List<WebElement> radioOrcheckBox, String value) {
		
		 String actualValue;
		
		for (WebElement el: radioOrcheckBox) {
			actualValue=el.getAttribute("value").trim();
			
			if(el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}
		}
	
	/**
	 * Method that checks if text is there and then selects it
	 * @param element
	 * @param textToSelect
	 */
	
	public static void selectDdValue(WebElement element, String textToSelect) {
		
		try {
			Select select=new Select(element);
			List<WebElement>options=select.getOptions();
			
			for (WebElement el: options) {
				if(el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);   //ayrica clickde kullanabilirsin
					break;
				}
			}
			
		}catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that selects value by index
	 * @param element
	 * @param index
	 */
	
	public static void selectDdValue(WebElement element, int index) {
		
		try {
			Select select2=new Select(element);
			int size=select2.getOptions().size();
			if(size>index) {
				select2.selectByIndex(index);
			}	
		}catch(UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
	
	public static void acceptAlert() {
		
		try {
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		}catch(NoAlertPresentException e){
			e.printStackTrace();
		}
	}
	
public static void dismissAlert() {
		
		try {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		
		}catch(NoAlertPresentException e){
			e.printStackTrace();
		}
	}

public static String getAlertText() {
	
	String alertText=null;
	
	try {
	Alert alert=driver.switchTo().alert();
	alertText=alert.getText();
	
	}catch(NoAlertPresentException e) {
		e.printStackTrace();
	}
	return alertText;
}
	
public static void sendAlertText(String text) {
		
		try {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
		
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
}

public static void switchToFrame(String nameOrId) {
	
	try {
	driver.switchTo().frame(nameOrId);
	
	}catch(NoSuchFrameException e) {
		e.printStackTrace();
	}
}

public static void switchToFrame(int index) {
	
	try {
		driver.switchTo().frame(index);
	}catch(NoSuchFrameException e) {
		e.printStackTrace();
	}
}

/**
 * Method switches focus to child window
 */
public static void switchToChildWindow() {
	String mainWindow = driver.getWindowHandle();
	Set<String> windows = driver.getWindowHandles();
	for (String window : windows) {
		if (!window.equals(mainWindow)) {
			driver.switchTo().window(window);
			break;
		}
	}
}

public static WebDriverWait getWaitObject() {
	WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
	return wait;
}


public static WebElement waitForClickability(WebElement element) {
	return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
}


public static WebElement waitForVisibility(WebElement element) {
	return getWaitObject().until(ExpectedConditions.visibilityOf(element));
}

public static void click(WebElement element) {
	waitForClickability(element);
	element.click();
}

public static JavascriptExecutor getJSObject() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	return js;
}

public static void jsClick(WebElement element) {
	getJSObject().executeScript("arguments[0].click();", element);
}

public static void scrollToElement(WebElement element) {
	getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
}

/**
 * Method that will scroll the page down based on the passed pixel parameters
 * @param pixel
 */
public static void scrollDown(int pixel) {
	getJSObject().executeScript("window.scrollBy(0,"+pixel+")");
}

/**
 * Method that will scroll the page up based on the passed pixel parameters
 * @param pixel
 */
public static void scrollUp(int pixel) {
	getJSObject().executeScript("window.scrollBy(0,-"+pixel+")");
}

public static void isDisplayed(WebElement element) {
	boolean isDisplayed = element.isDisplayed();
	String text = element.getText(); // this used for comparing , text represents label/attributes
	if (element.isDisplayed()) {// or i can do element.isDisplayed()
		System.out.println(text + " is displayed: " + isDisplayed);// +isDisplayed);
	} else {
		System.out.println(text + " is not displayed: " + isDisplayed);// + isDisplayed);
	}
}
/**
 * this method will take a screenshot
 * @param fileName
 */

   public static void takeScreenshot(String fileName) {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File file=ts.getScreenshotAs(OutputType.FILE);
	try {
	    FileUtils.copyFile(file, new File("/screenshot/"+fileName+".png"));	
    }catch(IOException e){
	   System.out.println("Cannot take a screenhsot");
	}
}
	

}
