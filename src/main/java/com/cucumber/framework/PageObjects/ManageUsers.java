package com.cucumber.framework.PageObjects;

import org.openqa.selenium.By;

public class ManageUsers {
	
	public static By userListMenu = By.xpath("//p[contains(text(),'Manage Users')]");
	public static By addUserBttn = By.xpath("//a[@href='https://qa.zevolife.com/en/admin/users/create']");
	public static By firstName = By.xpath("//input[@id='first_name']");
	public static By lastName = By.xpath("//input[@id='last_name']");
	public static By email = By.xpath("//input[@id='email']");
	public static By dob = By.xpath("//input[@id='date_of_birth']");
	public static By gender= By.xpath("//span[@id='select2-gender-container']");
	public static By height = By.xpath("//input[@id='height']");
	public static By weight = By.xpath("//input[@id='weight']");
	public static By createUserSubmitBttn= By.xpath("//button[@id='zevo_submit_btn']");

	
	
	
	
	
	
	
	
	
	
	
	
}
