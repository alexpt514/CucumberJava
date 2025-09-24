package StepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class LoginSteps {

	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.print("Given step");
	    //throw new io.cucumber.java.PendingException();
		
		
	    // Start Chrome browser
	    WebDriver driver = null;
	    
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Alex\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\drivers\\chrome-win64\\chrome.exe");
	    
	    driver =  new ChromeDriver();
	    
	    driver.get("https://www.google.com");
	
	    System.out.println("Title: " + driver.getTitle());
	    driver.quit();
	}

	
	/*
	 * @When("user enters <username> and <password>") public void
	 * user_enters_name1_and_abc() { // Write code here that turns the phrase above
	 * into concrete actions System.out.print("When step"); //throw new
	 * io.cucumber.java.PendingException(); }
	 */
	 
	  @When("user enters {string} and {string}")
	  public void user_enters_credentials(String username, String password) {
	      System.out.println("Username: " + username + ", Password: " + password);
	      // Add actual login logic here
	  }
		/*
		 * @When("user enters name1 and abc") public void user_enters_name1_and_abc1() {
		 * // Write code here that turns the phrase above into concrete actions throw
		 * new io.cucumber.java.PendingException(); }
		 */
	
	@And("clicks on login button")
	public void clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.print("And step");
		 // TODO: Add logic to click the login button using your test framework, e.g., Selenium:
	    // driver.findElement(By.id("loginButton")).click();
	}

	@Then("user is redirected to the email page")
	public void user_is_redirected_to_the_email_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.print("Then step");
		// TODO: Add logic to click the login button using your test framework, e.g., Selenium:
	    // driver.findElement(By.id("loginButton")).click();
	}

	/*
	 * @When("user enters name2 and {int}") public void
	 * user_enters_name2_and(Integer int1) { // Write code here that turns the
	 * phrase above into concrete actions System.out.print("When 2 step"); throw new
	 * io.cucumber.java.PendingException(); }
	 */



	
	
	
}
