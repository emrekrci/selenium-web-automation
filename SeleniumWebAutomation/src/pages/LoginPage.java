package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import extensions.WebElementExtensions;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"accountBtn\"]")
	WebElement signInButton;
	
	public void clickSignInButton() {
		try {
			WebElementExtensions.WaitForElementExist(driver, signInButton);
			signInButton.click();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement inputEmailAddress;
	
	public void setEmail(String email) {
		try {
			WebElementExtensions.WaitForElementExist(driver, inputEmailAddress);
			inputEmailAddress.sendKeys(email);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement inputPassword;
	
	public void setPassword(String password) {
		try {
			WebElementExtensions.WaitForElementExist(driver, inputPassword);
			inputPassword.sendKeys(password);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@FindBy(xpath = "//*[@id=\"loginSubmit\"]")
	WebElement loginSubmit;
	
	public MainPage clickLoginSubmit() throws InterruptedException {
		try {
			Thread.sleep(5000);
			WebElementExtensions.WaitForElementExist(driver, loginSubmit);
			loginSubmit.click();
			return new MainPage(driver);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@FindBy(xpath = "/html/body/div[8]/div/div/a")
	WebElement closeFancyBox;
	
	public void clickFancyClose() throws Exception {
		try {
			WebElementExtensions.WaitForElementExist(driver, closeFancyBox);
			if(WebElementExtensions.IsElementDisplayed(closeFancyBox)) {
				closeFancyBox.click();
			}else {
				throw new Exception("Close Fancy Button is not displayed");
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[8]/div/span")
	WebElement closePolicy;
	
	public void ClosePolicy() {
		try {
			WebElementExtensions.WaitForElementExist(driver, closePolicy);
			closePolicy.click();
		} catch (Exception e) {
			throw e;
		}
	}
}
