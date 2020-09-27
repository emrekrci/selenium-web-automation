package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	public static WebDriver driver;
	
	@Before
	public void initializeWebDriver() throws IOException{
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.trendyol.com");
			
		} catch (Exception e) {
			throw e;
		}finally{
			driver.quit();
		}
		
	}
	
	@After
	public void quiteDriver() {
		driver.quit();
	}
}
