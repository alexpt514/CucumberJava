package StepDef;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;

import actions.LandingPageActions;
import actions.OffersPageActions;
import actions.PageObjectManager;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import util.Util;

public class OffersPageStep {
	
	
	
	Util util;
	PageObjectManager pageobject;
	
	OffersPageActions offersPage;
	
	public OffersPageStep(Util util) {
		
		
		this.util=util;
		
		
	}
	
	
	String product;
	@And("^User goes to offers page and seacrhes for (.+)$")
	public void user_goes_to_offers_page_and_seacrhes_for_name(String name) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("And Step");
		
		
		switchToOffersPage();
		
		//OffersPageActions offersPage =  util.pageObject.getOffersPage();
		
		this.offersPage = util.pageObject.getOffersPage();
		
		//PageObjectManager pageobject = new PageObjectManager(util.driver);
		//OffersPageActions offersPage = pageobject.getOffersPage();
		// OffersPageActions offersPage = new OffersPageActions(util.driver);
		
		offersPage.searchItem(name);
		
		
		//product= offersPage.getProductName();
		
		//Assert.assertEquals(name, product);
		
		// CORREÇÃO: Inicializa offersPage e armazena na variável da classe
        
        
        // Debug: Verifica se o driver está disponível
        if (offersPage.driver == null) {
            throw new RuntimeException("Driver está null na OffersPageActions!");
        }
	}


	@Then("^(.+) is displayed on the page$")
	public void name_is_displayed_on_the_page(String name) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Then Step");
		
		product= offersPage.getProductName().split(" ")[0].trim();
		
		//util.product2 = landingPage.getProductName().split("-")[0].trim();  // split() - split in two arrays devided by the "-" in string , using[0] selects the first atribute , and the trim() clears the spaces in the string  ;

		System.out.println("Products: "+util.product2 + " "+ product);
		
		Assert.assertEquals(util.product2, product);
		
		//assertEquals(util.product2, product);
		//product= offersPage.getProductName();
		
		
		//Assert.assertEquals(name, product);
	    
	}
	
	public void switchToOffersPage() {
		
		
		//PageObjectManager pageObject = new PageObjectManager(util.driver);
		
		LandingPageActions landingPage = util.pageObject.getLandingPage();
		
		
		System.out.println("Here is the driver !!!!!!! "+" "+landingPage.driver);
		//LandingPageActions landingPage = new LandingPageActions(util.driver);
		
		landingPage.selectTopDeals();
		
		util.genericCode.switchToChild(); // switch to child method comes from util class , the object is created there and the method to switch comes from GenericCode class
	    
		/*
		 * Set<String> selector= util.driver.getWindowHandles(); Iterator<String>
		 * iterator = selector.iterator(); String parentWindow = iterator.next(); String
		 * childWindow = iterator.next();
		 * 
		 * util.driver.switchTo().window(childWindow);
		 */
	    
	    //System.out.println(parentWindow +"  "+ childWindow);
	    
	    //Assert.assertEquals(product, product2);
		}
		
		
	}


