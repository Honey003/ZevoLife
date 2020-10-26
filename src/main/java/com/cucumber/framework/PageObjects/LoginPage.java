package com.cucumber.framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.framework.helper.Generic.GenericHelper;
import com.cucumber.framework.helper.PageObject.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Services;

public class LoginPage  {

	public static WebDriver driver;

	public static By emailtxTxtfield = By.xpath("//input[@id='email']");
	public static By passwordTxtfield = By.xpath("//input[@id='password']");
	public static By loginBttn = By.xpath("//button[contains(text(),'Login')]");

	
	public void LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public static WebElement getWebElement(WebDriver driver, By Xpath) {

		WebElement webElement = driver.findElement(Xpath);

		return webElement;
	}

	public static void clickElement(WebDriver driver, By Xpath) {

		GenericHelper.clickElement(driver, Xpath);

	}

	public static void waitForElementToBeClickable(By Xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));

	}

	public static void sendData(WebDriver driver, By Xpath, String dataToSend) throws InterruptedException {
		GenericHelper.sendKeysbyXpath(driver, Xpath, dataToSend);

	}
	
	
	




}
