package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import extensions.WebElementExtensions;

public class MainPage {
	WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"auto-complete-app\"]/div/div/input")
	WebElement searchBox;
	
	public void setToSearchbox() {
		try {
			WebElementExtensions.WaitForElementExist(driver, searchBox);
			searchBox.sendKeys("bilgisayar");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"auto-complete-app\"]/div/div[2]/div/a[1]")
	WebElement searchedText;
	
	public void clickSearchIcon() {
		try {
			WebElementExtensions.WaitForElementExist(driver, searchedText);
			searchedText.click();
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div/div/div/div/div[1]")
	WebElement fancyCloseButton;
	
	public void clickFancyCloseButton() {
		try {
			WebElementExtensions.WaitForElementExist(driver, fancyCloseButton);
			fancyCloseButton.click();
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div")
	WebElement allProduct;
	
	public ProductDetailPage clickAnyProduct() {
		try {
			WebElementExtensions.WaitForElementExist(driver, allProduct);
			java.util.List<WebElement> childList = allProduct.findElements(By.xpath(".//*"));
			Random rand = new Random(); 
	        childList.get(rand.nextInt(childList.size())).click();
	        return new ProductDetailPage(driver);
		} catch (Exception e) {
			throw e;
		}
		
	}
}
