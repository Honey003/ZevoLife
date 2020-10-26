package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
public class ManageUserRunner {
	
	  @CucumberOptions(features = "src/test/java/features", glue="stepDefination")
	  public class TestRunner extends AbstractTestNGCucumberTests {
	  

	  
	  
	  }


	 


}
