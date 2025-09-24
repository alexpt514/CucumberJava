package StepDef;

import java.util.Iterator;
//import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import dev.failsafe.internal.util.Assert;

//import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.Util;



public class Search {

	Util util;
	
	public WebDriver driver;

	
	public Search(Util util) {
		
		this.util=util;
		
		this.driver=util.driver;
		
	}
	
	@Given("User is on google page")
	public void user_is_on_google_page() {
		
		/*
		 * Proxy proxy = new Proxy(); proxy.setHttpProxy("123.123.123.123:8080"); //
		 * e.g., "123.123.123.123:8080"
		 * 
		 * ChromeOptions options = new ChromeOptions(); options.setProxy(proxy);
		 */
	    // Start Chrome browser
		
		System.out.println("Running with Java version: " + System.getProperty("java.version"));
		
		WebDriverManager.chromedriver().setup();
		
	    WebDriver driver = null;
	    
	    //System.setProperty("webdriver.chrome.driver","C:\\Users\\Alex\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\drivers\\chrome-win64\\chrome.exe");
	    
	    util.driver =  new ChromeDriver();
	    
	    //driver.get("https://linkinpark.com/");
	    
	    util.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	
	   // System.out.println("Title: " + driver.getTitle());
	    
	    //driver.quit();
	    
	  
	    
	    util.driver.manage().window().maximize();
	    
	    
	    
	    util.driver.findElement(By.className("search-keyword")).click();
	    
	    //driver.findElement(By.xpath("//*[@id="root"]/div/header/div/div[2]/form/input")).sendKeys("automation");
	    
	    util.driver.findElement(By.className("search-keyword")).sendKeys("tom");
	    
	    //driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("automation");
	    
	    try {
	        Thread.sleep(2000); // Let the user see the typed text
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    String product = util.driver.findElement(By.className("product-name")).getText().split("-")[0].trim();  // split() - split in two arrays devided by the "-" in string , using[0] selects the first atribute , and the trim() clears the spaces in the string 
	    
	   //driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);
	    
	    //driver.findElement(By.name("btnK")).click();
	    
	    util.driver.findElement(By.className("product-action")).click();
	    
	    try {
	        Thread.sleep(2000); // Let the user see the typed text
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    util.driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/a[4]/img")).click();
	    
	    util.driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/div[2]/div[2]/button")).click();
	    
	    String product2 = util.driver.findElement(By.className("product-name")).getText().split("-")[0].trim();
	    
	    System.out.println(product +"  "+ product2);
	    
	    
		/*
		 * driver.findElement(By.linkText("Top Deals")).click();
		 * 
		 * Set<String> selector= driver.getWindowHandles(); Iterator<String> iterator =
		 * selector.iterator(); String parentWindow = iterator.next(); String
		 * childWindow = iterator.next();
		 * 
		 * driver.switchTo().window(childWindow);
		 * 
		 * System.out.println(parentWindow +"  "+ childWindow);
		 * 
		 * Assert.assertEquals(product, product2);
		 */
	    
	}

	/*
	 * @When("User enters the search {string} text") public void
	 * user_enters_the_search_text(String shortName) {
	 * System.out.println("User enters the search text" + shortName);
	 * 
	 * 
	 * 
	 * driver.findElement(By.linkText("Top Deals")).click();
	 * 
	 * Set<String> selector= driver.getWindowHandles(); Iterator<String> iterator =
	 * selector.iterator(); String parentWindow = iterator.next(); String
	 * childWindow = iterator.next();
	 * 
	 * driver.switchTo().window(childWindow);
	 * 
	 * System.out.println(parentWindow +"  "+ childWindow);
	 * 
	 * //Assert.assertEquals(product, product2); }
	 */

	@And("clicks enter")
	public void clicks_enter() {
		System.out.println("clicks enter");
	}

	@Then("User is redirected to the searched topic")
	public void user_is_redirected_to_the_searched_topic() {
		System.out.println("User is redirected to the searched topic");
	}
	
	@Given("^I want to write a step with (.+)$") //symbol (.+) accepts any data type so it doesnt have to be string or int or char , need to start the step with ^ and end it with $ 
	public void nameDef(String name) {
		
		System.out.println("User "+name+ "is redirected to the searched topic");
		
	}
	
	/*
	 * @Given("I want to write a step with {string}") public void nameDef(String
	 * name) {
	 * 
	 * System.out.println("User "+name+ "is redirected to the searched topic");
	 * 
	 * }
	 */
	
	@When ("^I check for the (.+) in step$")
	public void valueDef(String value)
	{
		
		
		System.out.println("User "+value+ "is redirected to the searched topic");
		
	}
	
	@Then ("I verify the {string} in step")
	public void statusDef(String status) {
		
		System.out.println("User "+status+ "is redirected to the searched topic");
		
	}
	
	@When("User enters the following text")
	public void listDef(List<String> list) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		  for (int i = 0; i < list.size(); i++) {
	            System.out.println("Topis is: "+list.get(i));
	        }
		//System.out.println("Topis is: "+list.get(0)+ "is redirected to the searched topic");
	}

	
}
