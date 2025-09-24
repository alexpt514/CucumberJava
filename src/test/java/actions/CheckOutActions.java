package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManage;

import java.time.Duration;

public class CheckOutActions {

	public WebDriver driver;

	// By search = By.className("search-keyword");

	// By addToCart = By.className("product-action2");
	By addToCart = By.cssSelector(".product-action");

	By add = By.className("increment");
	By sub = By.className("decrement");
	By search = By.cssSelector(".search-keyword");
	By product = By.className("product-name");
	By topDeals = By.linkText("Top Deals");
	By quantity = By.className("quantity");

	public CheckOutActions(WebDriver driver) {

		this.driver = DriverManage.getDriver();
	}

	public void searchItem(String name) {

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(search));

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

	public void addItems(int quantity) {

		try {
			Thread.sleep(3000); // Sleep for 3 seconds (3000 milliseconds)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 1; i <= quantity; i++) {
			ExpectedConditions.visibilityOfElementLocated(add);
			driver.findElement(add).click();
			System.out.println("Loop number :" + i);
		}
		;

	}

	public void addCart() {

		ExpectedConditions.visibilityOfElementLocated(addToCart);
		driver.findElement(addToCart).click();

	}

	public String showQuant() {

		// System.out.println("Quantity inserted:
		// "+driver.findElement(quantity).getText());
		return driver.findElement(quantity).getText();

	}

}
