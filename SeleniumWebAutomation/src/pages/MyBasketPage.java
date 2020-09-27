package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import extensions.WebElementExtensions;

public class MyBasketPage {
	WebDriver driver;
	
	public MyBasketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/button[2]/svg")
	WebElement increaseCountButton;
	
	public void IncreaseCount() {
		try {
			WebElementExtensions.WaitForElementExist(driver, increaseCountButton);
			increaseCountButton.click();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/input")
	WebElement productCount;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"partial-basket\"]/div/div[3]/div[2]/div[3]/div[2]")
	WebElement productPrice;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/button")
	WebElement deleteProductButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/div[1]/button[2]")
	WebElement deleteButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"basketNoProductPage\"]/div[2]/div/div[1]/p/span")
	WebElement noProductLabel;
	
	public String GetNoProductLabel() {
		try {
			WebElementExtensions.WaitForElementExist(driver, noProductLabel);
			return noProductLabel.getText();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String GetProductCount() {
		try {
			WebElementExtensions.WaitForElementExist(driver, productCount);
			return productCount.getText();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void DeleteProductFormBasket() {
		try {
			WebElementExtensions.WaitForElementExist(driver, deleteProductButton);
			deleteProductButton.click();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void DeleteConfirmation() {
		try {
			WebElementExtensions.WaitForElementExist(driver, deleteButton);
			deleteButton.click();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String GetProductPrice() {
		try {
			WebElementExtensions.WaitForElementExist(driver, productPrice);
			return productPrice.getText();
		} catch (Exception e) {
			throw e;
		}
	}
	
}
