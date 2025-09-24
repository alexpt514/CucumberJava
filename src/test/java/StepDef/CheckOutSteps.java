package StepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import actions.CheckOutActions;
import actions.LandingPageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Util;

public class CheckOutSteps {
	
public Util util;

public WebDriver driver;

public CheckOutActions checkOut;

public CheckOutSteps (Util util){
	
	this.util=util;
	
}




@And("User goes to Checkout")
public void go_to_check_out() {
	
	
	
	
	System.out.println("User goes to Checkout");
	
	//checkOut= util.pageObject.getCheckOutPage();
	
	//checkOut.
	util.genericCode.checkOutClick();

	//System.out.println("QUANTITY!!!! "+util.pageObject.getCheckOutPage().showQuant());
}


//@Then("^\"(.+)\" and (\\d+) are displayed on the page$")
/*
 * @Then("{string} and {int} are displayed on the page") public void
 * check_out_page(String name, int quant) { System.out.println(name +"and "+
 * quant+ " are displayed on the page");
 * 
 * 
 * System.out.println("QUANTITY!!!! "+util.pageObject.getCheckOutPage().
 * showQuant());
 * 
 * }
 */

@Then("{string} is displayed on the page")
public void name_is_displayed_on_the_page(String name) {
    // Code to verify the name is displayed
    System.out.println("Verifying that " + name + " is displayed on the page.");
}

@And("{int} is displayed on the page")
public void quant_is_displayed_on_the_page(Integer quant) {
    // Code to verify the quantity is displayed
    System.out.println("Verifying that quantity " + quant + " is displayed on the page.");
}
/*
 * @And("^(.+) is displayed on the page$") public void check_out_page_quant(int
 * quant) { System.out.println(quant + " is displayed on the page");
 * 
 * }
 */

}