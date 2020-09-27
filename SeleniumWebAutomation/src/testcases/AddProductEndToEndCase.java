package testcases;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import extensions.CSVUtils;
import pages.LoginPage;
import pages.MainPage;
import pages.MyBasketPage;
import pages.ProductDetailPage;

public class AddProductEndToEndCase extends TestBase {

	@Test
	public void init() throws Exception{
		LoginPage trendyolLoginPage = new LoginPage(driver);
		trendyolLoginPage.clickFancyClose();
		trendyolLoginPage.clickSignInButton();
		trendyolLoginPage.setEmail(CSVUtils.GetDataFromCSV("src\\data\\testdata.csv",1, 0));
		trendyolLoginPage.setPassword(CSVUtils.GetDataFromCSV("src\\data\\testdata.csv",1, 1));
		
		MainPage trendyolMainPage = trendyolLoginPage.clickLoginSubmit();
		trendyolMainPage.clickFancyCloseButton();
		trendyolMainPage.setToSearchbox();
		trendyolMainPage.clickSearchIcon();
		
		ProductDetailPage productDetail = trendyolMainPage.clickAnyProduct();
		productDetail.WriteProductDetail();
		String productPriceOnDetail = productDetail.GetPrice();
		productDetail.clickAddToBasket();
		
		MyBasketPage myBasket = productDetail.clickMyBasket();
		assertEquals(productPriceOnDetail, myBasket.GetProductPrice());
		myBasket.IncreaseCount();
		assertEquals("2", myBasket.GetProductCount());
		myBasket.DeleteProductFormBasket();
		myBasket.DeleteConfirmation();
		assertEquals("Sepetinizde ürün bulunmamaktadır.", myBasket.GetNoProductLabel());
		//Thread.sleep(10000);
	}
}
