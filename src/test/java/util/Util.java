package util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import actions.PageObjectManager;
import factory.DriverManage;

public class Util {

	public WebDriver driver;
	public String product2;
	public PageObjectManager pageObject;
	
	public GenericCode genericCode;
	public DriverManage newDriver;
	
	  public Util() throws IOException {
	        // Ensure driver is started for the thread
	        DriverManage.startDriver();
	        WebDriver driver = DriverManage.getDriver();

	        // Initialize page objects with the same thread-safe driver
	        this.pageObject = new PageObjectManager(driver);
	        this.genericCode = new GenericCode(driver);
	    }
   
	
	  
	  
}
