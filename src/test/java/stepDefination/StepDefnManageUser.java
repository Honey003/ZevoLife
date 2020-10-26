package stepDefination;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cucumber.framework.PageObjects.ManageUsers;
import com.cucumber.framework.helper.Generic.GenericHelper;
import com.cucumber.framework.helper.PageObject.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import runner.ManageUserRunner;
import utils.Services;

@RunWith(Cucumber.class)

public class StepDefnManageUser extends BaseClass {


	@Given("User is on landing page\"https:\\/\\/qa.zevolife.com\\/\"")
	public void user_is_on_landing_page_https_qa_zevolife_com() throws InterruptedException, IOException {

		initializeDriver();

	}

	@Then("User login the application")
	public void user_login_the_application() throws InterruptedException {
		login(driver, true);


	}
	

	@And("Click on the Manage User menu")
	public void click_on_the_Manage_User_menu() {
		
		GenericHelper.clickElement(driver,ManageUsers.userListMenu);
		
		
		
	}

	@Then("Fill the desired information and submit")
	public void fill_the_desired_information_and_submit() {
		
		
		
	}

	@And("Validate the record is updated")
	public void validate_the_record_is_updated() {
	}

}
