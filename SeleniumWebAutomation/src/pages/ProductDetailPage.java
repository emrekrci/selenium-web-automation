package pages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import extensions.WebElementExtensions;

public class ProductDetailPage {
	WebDriver driver;
	
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[2]/div[2]/div[1]/div[1]/div[1]/h1/div/span")
	WebElement productName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[3]/div[2]/span[@class = 'prc-dsc' or @class = 'prc-slg']")
	WebElement productPrice;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[2]/div[1]/button[1]")
	WebElement addToBasketButton;
	
	public void clickAddToBasket() {
		try {
			WebElementExtensions.WaitForElementExist(driver, addToBasketButton);
			addToBasketButton.click();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"myBasketListItem\"]")
	WebElement myBasketIcon;
	
	public MyBasketPage clickMyBasket() throws InterruptedException {
		try {
			Thread.sleep(5000);
			WebElementExtensions.WaitForElementExist(driver, myBasketIcon);
			myBasketIcon.click();
			return new MyBasketPage(driver);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void WriteProductDetail() throws IOException {
		try {
			WebElementExtensions.WaitForElementExist(driver, productPrice);
			File productDetail = new File("src\\data\\productdetail.txt");
			productDetail.createNewFile();
			FileWriter fileWriter = new FileWriter(productDetail);
			fileWriter.write("Product Name: " + productName.getText() + "\nProduct Price: " + productPrice.getText());
			fileWriter.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String GetPrice() {
		try {
			WebElementExtensions.WaitForElementExist(driver, productPrice);
			return productPrice.getText();
		} catch (Exception e) {
			throw e;
		}
	}
}
