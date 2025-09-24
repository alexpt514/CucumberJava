package StepDef;

import java.util.Objects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import actions.CheckOutActions;
import actions.LandingPageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Util;

public class LandingPageStep {

	public Util util;

	public WebDriver driver;
	CheckOutActions checkOut;
	LandingPageActions landing;

	public LandingPageStep(Util util) {

		this.util = util;
		this.checkOut = util.pageObject.getCheckOutPage();
		this.landing = util.pageObject.getLandingPage();
	}

//Feature: Search for items
//Scenario Outline: Search with exact match

	@When("^I search for (.+)$")
	public void search(String name) {

		landing.searchItem(name);

	}

	@Then("^Search results should display items matching (.+)$")
	public void match(String name) {

		Assert.assertEquals(name, landing.getProductName().split("-")[0].trim());

	}

//Feature: Search for items
//Scenario Outline: Search with partial keywords

	@Then("^Search results should display items that contain (.+) or similar$")
	public void match_2(String long_name) {

		Assert.assertEquals(long_name, landing.getProductName().split("-")[0].trim());

	}

//Feature: Search for items
//Scenario: Search with no matching items
	/*
	 * @When("I search for {string}") public void i_search(String name) {
	 * 
	 * landing.searchItem(name);
	 * 
	 * }
	 */

	@Then("the result area should display no products message or be empty")
	public void no_results() {

		if (Objects.nonNull(landing.getProductName())) {
			System.out.println(landing.noResults());

		} else {

			System.out.println("Product visible!!! " + landing.getProductName());
		}

	}

//Feature: Adding Products to Cart
//  Scenario Outline: Add a single product to cart

	@And("I add the product to the cart")
	public void add_to_cart() {

		landing.add_to_cart();

	}

	@Then("the cart should show {int} item added")
	public void getQuant(int quant) {

		
		//landing.clickCart();
		String actualQuant = landing.getCartCount2();
		String expectedQuant = String.valueOf(quant); // convert int to String
		
		System.out.println("Expected: " + expectedQuant);
		System.out.println("Actual: " + actualQuant);		

		
		Assert.assertEquals(expectedQuant, actualQuant);


		
	}
	
	
	@And("^the cart shows the correct name (.+)$")
	public void checkNameCart(String name) {

		
		String expectedName = landing.getCartProductName().split("-")[0].trim();
		Assert.assertEquals(name,expectedName );
		
		System.out.println("Expected: " + name);
		System.out.println("Actual: " + expectedName);

	}
	
	
	
	@And("added item should appear with correct quantity {int}")
	public void getItemQuant(int quant) {
		
		//landing.clickCart();
		String actualQuant =landing.getProductCartQuant().split(" ")[0].trim();
		String expectedQuant = String.valueOf(quant);

		System.out.println("Expected: " + quant);
		System.out.println("Actual quantity of each item: " + actualQuant);
		
		Assert.assertEquals(expectedQuant, actualQuant);


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Given("User is on Vegetable site LandingPage")
	public void vegetable_landing_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Given Step");

		// util.driver = new ChromeDriver();

		// driver.get("https://linkinpark.com/");

		// util.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// ChromeDriver driver = new ChromeDriver();
		// util.setDriver(driver); //

		// driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// util.setDriver(driver);

		// util.pageObject.getLandingPage();

		System.out.println("Driver from util class!!!! " + util.driver);
	}

	@When("^User checks for the (.+) in search and add it to cart$")
	public void search_add_cart(String name) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("When Step");

		// LandingPageActions landingPage = util.pageObject.getLandingPage();

		LandingPageActions landingPage = new LandingPageActions(util.driver);

		landingPage.searchItem(name);

		landingPage.getSearchText();

		try {
			Thread.sleep(2000); // Let the user see the typed text
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		util.product2 = landingPage.getProductName().split("-")[0].trim(); // split() - split in two arrays devided by
																			// the "-" in string , using[0] selects the
																			// first atribute , and the trim() clears
																			// the spaces in the string ;

		// util.getPageObjectManager().getLandingPage().searchItem(name);

		System.out.println(util.product2 + " Present");
	}

	@When("^User checks for the (.+) in search$")
	public void search_cart(String name) {
		System.out.println("search");
		LandingPageActions landingPage = new LandingPageActions(util.driver);

		landingPage.searchItem(name);

	}

	@And("^adds (.+) to cart$")
	public void add_quantity(int quant) {

		// CheckOutActions checkOut = new CheckOutActions(util.driver);

		checkOut.addItems(quant);
		checkOut.addCart();
	}

}