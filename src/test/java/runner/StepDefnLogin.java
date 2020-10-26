package runner;

import java.io.IOException;
import org.junit.runner.RunWith;
import com.cucumber.framework.PageObjects.LoginPage;
import com.cucumber.framework.helper.PageObject.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

public class StepDefnLogin extends BaseClass {

	@Given("User is on landing page\"https:\\/\\/qa.zevolife.com\\/\"")
	public void user_is_on_landing_page_https_qa_zevolife_com() throws IOException {

		initializeDriver();
		driver.get("https://qa.zevolife.com/en/login");
		driver.manage().window().maximize();

	}

	@Then("add user name")
	public void add_user_name() throws InterruptedException {

		LoginPage.sendData(driver, LoginPage.emailtxTxtfield, "superadmin@grr.la");

	}

	@Then("Password")
	public void password() throws InterruptedException {

		LoginPage.sendData(driver, LoginPage.passwordTxtfield, "Admin@123");
		LoginPage.clickElement(driver, LoginPage.loginBttn);
	}

	@Then("Verify user logged in the application")
	public void verify_user_logged_in_the_application() {

		System.out.println("Test");

	}

	@Then("close the browser")
	public void close_the_browser() {
		System.out.println("Test");

	}

}