package actions;

import org.openqa.selenium.WebDriver;

import factory.DriverManage;
import util.GenericCode;

public class PageObjectManager {

	public LandingPageActions landingPage; // create a LandingPageActions object to manage the creation in this class
	public OffersPageActions offersPage; // create a OffersPageActions object to manage the creation in this class
	public GenericCode genericCode;
	public CheckOutActions checkPage;
	public WebDriver driver;

	public PageObjectManager(WebDriver driver) {

		this.driver = DriverManage.getDriver();

	}

	public LandingPageActions getLandingPage() {

		if (landingPage == null) {
			landingPage = new LandingPageActions(this.driver);
		}
		return landingPage;

	}

	public OffersPageActions getOffersPage() {

		if (offersPage == null) {
			offersPage = new OffersPageActions(this.driver);
		}
		return offersPage;

	}

	public CheckOutActions getCheckOutPage() {

		if (checkPage == null) {
			checkPage = new CheckOutActions(this.driver);
		}
		return checkPage;

	}

	public GenericCode getGenericCode() {
		if (genericCode == null) {
			genericCode = new GenericCode(this.driver);
		}
		return genericCode;

	}

}
