package util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import actions.LandingPageActions;

public class GenericCode {
	
	WebDriver driver;
	By checkOutIcon= By.className("cart-icon");
	By checkOutButton= By.className("action-block");
	
	public GenericCode(WebDriver driver) {
		
		
		this.driver=driver;
		
	}
	
	
	public void switchToChild() {
		
		
	    
	    Set<String> selector= driver.getWindowHandles();
	    Iterator<String> iterator = selector.iterator();
	    String parentWindow = iterator.next();
	    String childWindow = iterator.next();
	    
	    driver.switchTo().window(childWindow);
		
	}

	
	public void checkOutClick() {
		
		ExpectedConditions.visibilityOfElementLocated(checkOutIcon);
		driver.findElement(checkOutIcon).click();
		ExpectedConditions.visibilityOfElementLocated(checkOutButton);
		driver.findElement(checkOutButton).click();
				
	}
}
