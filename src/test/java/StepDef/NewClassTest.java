package StepDef;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import util.Util;

public class NewClassTest {
	
	WebDriver driver;
	Util util;
	
	public NewClassTest(Util util) {
		
		this.util=util;
		
	}
	
	@When("User enters the search {string} text")
	public void user_enters_the_search_text(String shortName) {
		System.out.println("User enters the search text" + shortName);
		
		
		
			util.driver.findElement(By.linkText("Top Deals")).click();
		    
		    Set<String> selector= util.driver.getWindowHandles();
		    Iterator<String> iterator = selector.iterator();
		    String parentWindow = iterator.next();
		    String childWindow = iterator.next();
		    
		    util.driver.switchTo().window(childWindow);
		    
		    System.out.println(parentWindow +"  "+ childWindow);
		    
		    //Assert.assertEquals(product, product2);
	}

}
