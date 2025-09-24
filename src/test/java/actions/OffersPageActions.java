package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverManage;

public class OffersPageActions {

	
	public WebDriver driver;
	
	
	public OffersPageActions(WebDriver driver) {
		
		
		this.driver = DriverManage.getDriver();
		
	}
	
	
	
	
	By search = By.id("search-field");
	By product = By.xpath("//*[@id=\"root\"]//div[1]//div//div/table/tbody");
	
	By topDeals = By.linkText("Top Deals");
	
	
	

	
	
	public void searchItem(String name) {
	
	driver.findElement(search).sendKeys(name);
	
	
	}
	
	public void getSearchText() {
		
		
		driver.findElement(search).getText();
		
	}
	
	
	public String getProductName() {
		
		return driver.findElement(product).getText();	
	}
	
	
	public void selectTopDeals() {
		
		
		driver.findElement(topDeals).click();
		
	}
	
	
	
}
