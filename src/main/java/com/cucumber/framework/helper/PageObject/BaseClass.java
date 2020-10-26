package com.cucumber.framework.helper.PageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.cucumber.framework.PageObjects.LoginPage;



public class BaseClass {

	public static WebDriver driver;
	
	static com.cucumber.framework.configreader.ConfigFileReader config = new com.cucumber.framework.configreader.ConfigFileReader();
	public Properties prop;
	

	public static void driverInitialization() {
		System.setProperty("webdriver.chrome.driver", config.getDriverPath());
		driver = new ChromeDriver();
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driverInitialization();
		}
		return driver;
	}

	public static void initializeDriver() {

		getDriver();

	}

	


	/*
	 * public WebDriver initializeDriver() throws IOException { prop = new
	 * Properties(); String currentDirectory = System.getProperty("user.dir");
	 * String propertyFilePath = currentDirectory +
	 * "/src/main/java/resources/config.properties"; FileInputStream fis = new
	 * FileInputStream(propertyFilePath); prop.load(fis); String browserName =
	 * prop.getProperty("browser"); System.out.println(browserName+" started");
	 * 
	 * if (browserName.equals("chrome")) { String currentDir =
	 * System.getProperty("user.dir"); String ChromeDriverPath = currentDir +
	 * "/Drivers/chromedriver.exe"; System.setProperty("webdriver.chrome.driver",
	 * ChromeDriverPath); driver = new ChromeDriver();
	 * 
	 * } else if (browserName.equals("firefox")) { String currentDirr =
	 * System.getProperty("user.dir"); String FirefoxDriverPath = currentDirr +
	 * "/Drivers/geckodriver.exe"; System.setProperty("webdriver.gecko.driver",
	 * FirefoxDriverPath); driver = new FirefoxDriver();
	 * 
	 * } driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); return
	 * driver;
	 * 
	 * }
	 */
	
	

	public static void login(WebDriver driver, boolean admin) throws InterruptedException {

		com.cucumber.framework.configreader.ConfigFileReader configFileReader = new com.cucumber.framework.configreader.ConfigFileReader();
		driver.get(configFileReader.getApplicationUrl());
		driver.manage().window().maximize();

		if (admin == true) {
			
			driver.findElement(LoginPage.emailtxTxtfield).sendKeys(configFileReader.userName());
			driver.findElement(LoginPage.passwordTxtfield).sendKeys(configFileReader.password());
			driver.findElement(LoginPage.loginBttn).click();
			driver.manage().window().maximize();
		}

		else {

			driver.findElement(LoginPage.emailtxTxtfield).sendKeys(configFileReader.companyAdminName());
			driver.findElement(LoginPage.passwordTxtfield).sendKeys(configFileReader.companyAdminPassword());
			driver.findElement(LoginPage.loginBttn).click();
			driver.manage().window().maximize();
		}

	}
	
	
	
	

	public static void getScreenshot() throws IOException {

		System.out.println("inside get ss" +driver);
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/SS.png"));

	}

}
