package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import factory.DriverManage;

import java.time.Duration;
import java.util.List;

public class LandingPageActions {

	public WebDriver driver;

	// By search = By.className("search-keyword");

	By addToCart = By.className("product-action2");
	By add = By.className("increment");
	By sub = By.className("decrement");
	By search = By.cssSelector(".search-keyword");
	By product = By.className("product-name");
	By topDeals = By.linkText("Top Deals");
	By noResults = By.className("no-results");
	By cart = By.className("cart-icon");
	By productCartQuant = By.className("quantity");
	By productCartQuantTotal = By.className("product-total");
	By productCartEachQuant = By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[%s]/div[2]/p[1]");
	
	By productCartList = By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li");
	//By productCartQuant = By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li/div[2]/p[1]");
	By productCart = By.className("product-info");
	By addCart = By.className("product-action");
	By proceedCheckOut = By.className("action-block");
	By cartItemQuant = By.className("cart-items");
	By itemQuant = By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/div[1]/table/tbody/tr[1]/td[3]/strong");
	

	public LandingPageActions(WebDriver driver) {

		this.driver = DriverManage.getDriver();
	}

	public void searchItem(String name) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(search));

		WebElement inputField =driver.findElement(search);

		// Check if the field is not empty
		String existingText = inputField.getAttribute("value");
		if (existingText != null && !existingText.isEmpty()) {
			inputField.clear(); // Clear the field
		}

		inputField.sendKeys(name); // Type new text

	}

	public void getSearchText() {
		
		
		

		driver.findElement(search).getText();

	}

	public String getProductName() {

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(product));
		 */
	    try {
	        Thread.sleep(2000); // Let the user see the typed text
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		return driver.findElement(product).getText();
	}

	public void selectTopDeals() {

		driver.findElement(topDeals).click();

	}

	public void addItems(int quantity) {

		for (int i = 0; i < quantity; i++) {

			driver.findElement(add).click();
			System.out.println("Loop number :" + i);
		};

		driver.findElement(addToCart).click();
	}
	
	public String noResults() {
		
		try {
	        Thread.sleep(2000); // Let the user see the typed text
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		return driver.findElement(noResults).getText();
		
		
	}
	
	public void add_to_cart() {
		
		try {
	        Thread.sleep(2000); // Let the user see the typed text
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		driver.findElement(addCart).click();				
	}

	
	public void clickCart() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cart));
		
		
		driver.findElement(cart).click();
	}
	
	public String getProductCartQuant(int expectedQuant) {
		
		try {
	        Thread.sleep(2000); // Let the user see the typed text
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		String quant = null;
		
		  try {
		        List<WebElement> elements = driver.findElements(proceedCheckOut);
		        if (!elements.isEmpty()) {
		        	driver.findElement(cart).click();
		        	

		    	    Thread.sleep(2000); // Let the user see the typed text
		    	    
		    	    List<WebElement> productCartLists = driver.findElements(productCartList);
		    	    
		    	    List<WebElement> testList = driver.findElements(productCartQuantTotal);
		    	    
		    	    //String[] texts= driver.findElement((By) productCartList).getText();
		    	   
		    	    System.out.println("Cart Item List Size" + productCartLists.size());
		    		
		        	quant =driver.findElement(productCartQuant).getText();
		        	
		        	for (int i = 1; i < productCartLists.size(); i++) {
		        	    int actualQuant = Integer.parseInt(driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li["+i+"]/div[2]/p[1]")).getText().split(" ")[0].trim()); // get the quant of each item,
		        	    
		        	    //System.out.println("Item " + i + ": " + item.getText());
		        	    System.out.println("Item name:  "+ productCartLists.get(0).getText());
		        	    Assert.assertEquals(expectedQuant, actualQuant);
		        	}
		        	
		        	
		        	for (int i = 0; i < testList.size(); i++) {
		        	    
		        	    //System.out.println("Item " + i + ": " + item.getText());
		        	    System.out.println("!!!!!!!!!!!!!Test list Item name:  "+ testList.get(i).getText());
		        	   
		        	}
		        	
		        } else {
		            System.out.println("Element not present. No action taken.");
		        }
		  } catch (Exception e) {
		        System.out.println("Exception occurred while checking or clicking: " + e.getMessage());
		    }
		  
		  //catch(IOException | Exception ex)
		  //"//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li["+i+"]/div[2]/p[1]"
		  

		  
		    // Get all cart items
			/*
			 * List<WebElement> productNames =
			 * driver.findElements(By.cssSelector("p.product-name")); List<WebElement>
			 * quantities = driver.findElements(By.cssSelector("td:nth-child(3) p"));
			 * 
			 * System.out.println("Products in cart:"); for (int i = 0; i <
			 * productNames.size(); i++) { String name =
			 * productNames.get(i).getText().split("-")[0].trim(); String quantity =
			 * quantities.get(i).getText(); System.out.println(name + " - Quantity: " +
			 * quantity); }
			 */
		  
		  
		return quant;
		
	}
	
	public String getCartProductName() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productCart));

		return driver.findElement(productCart).getText();

	}
	
	public int getCartCount()  {
		
		 List<WebElement> products = null;
		
		  try {
		        List<WebElement> elements = driver.findElements(proceedCheckOut);
		        if (!elements.isEmpty()) {
		        	products =driver.findElements(cartItemQuant);
		        	
		        } else {
		            System.out.println("Element not present. No action taken.");
		        }
		    } catch (Exception e) {
		        System.out.println("Exception occurred while checking or clicking: " + e.getMessage());
		    }
		  
		  
		return products.size();
		  
		  
		
	}
	
	public String getCartCount2()  {
		
		 String quant = null;
		  
		  
		 quant =driver.findElement(itemQuant).getText();
		  
		return quant;
		
	}
	
}
