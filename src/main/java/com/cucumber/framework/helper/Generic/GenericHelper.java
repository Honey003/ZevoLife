
package com.cucumber.framework.helper.Generic;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.interfaces.IwebComponent;
import com.cucumber.framework.utility.DateTimeHelper;
import com.cucumber.framework.utility.ResourceHelper;
import com.cucumber.framework.PageObjects.LoginPage;


public class GenericHelper extends LoginPage{

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(GenericHelper.class);

	public GenericHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("GenericHelper : " + this.driver.hashCode());
	}
	
		

	
	
	
	
	public static void sendKeysbyXpath(WebDriver driver, By Xpath, CharSequence... keysToSend) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Xpath));
		WebElement wl = getWebElement(driver, Xpath);
		wl.sendKeys(keysToSend);
	}
	

	public static void clickElement(WebDriver driver, By Xpath) {

		waitForElementToBeClickable(driver, Xpath);
		getWebElement(driver, Xpath).click();

	}
	

	public static void waitForElementToBeClickable(WebDriver driver, By Xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));

	}
	
	
	

	public WebElement getElement(By locator) {
		oLog.info(locator);
		if (IsElementPresentQuick(locator))
			return driver.findElement(locator);

		try {
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re) {
			oLog.error(re);
			throw re;
		}
	}

	/**
	 * Check for element is present based on locator If the element is present
	 * return the web element otherwise null
	 * 
	 * @param locator
	 * @return WebElement or null
	 */
		  
		  
	/*
	 * public WebElement getElementWithNull(By locator) { oLog.info(locator); try {
	 * return driver.findElement(locator); } catch (NoSuchElementException e) { //
	 * Ignore } return null; }
	 */
	public boolean IsElementPresentQuick(By locator) {
		boolean flag = driver.findElements(locator).size() >= 1;
		oLog.info(flag);
		return flag;
	}

	/*
	 * public String takeScreenShot(String name) throws IOException {
	 * 
	 * if (driver instanceof HtmlUnitDriver) {
	 * oLog.fatal("HtmlUnitDriver Cannot take the ScreenShot"); return ""; }
	 * 
	 * File destDir = new File(ResourceHelper.getResourcePath("screenshots/") +
	 * DateTimeHelper.getCurrentDate()); if (!destDir.exists()) destDir.mkdir();
	 * 
	 * File destPath = new File(destDir.getAbsolutePath() +
	 * System.getProperty("file.separator") + name + ".jpg"); try {
	 * org.apache.logging.log4j.core.util.FileUtils .copyFile(((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE), destPath); } catch (IOException e)
	 * { oLog.error(e); throw e; } oLog.info(destPath.getAbsolutePath()); return
	 * destPath.getAbsolutePath(); }
	 */
	public String takeScreenShot() {
		oLog.info("");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

}
