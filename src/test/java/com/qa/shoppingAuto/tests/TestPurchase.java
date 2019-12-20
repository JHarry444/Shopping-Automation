package com.qa.shoppingAuto.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qa.shoppingAuto.consts.Constants;
import com.qa.shoppingAuto.pages.Cart;
import com.qa.shoppingAuto.pages.Home;
import com.qa.shoppingAuto.pages.Item;
import com.qa.shoppingAuto.pages.Search;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestPurchase {

	private WebDriver driver;
	private static ExtentReports extent = new ExtentReports("report.html", true);

	@Before
	public void setup() {
		System.setProperty(Constants.PROPERTY, Constants.PATH);
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get("http://automationpractice.com/index.php");
		ExtentTest test  = extent.startTest("Purchase test");
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.search("Blouse");
		Search searchPage = PageFactory.initElements(driver, Search.class);
		searchPage.selectItem();
		Item itemPage = PageFactory.initElements(driver, Item.class);
		itemPage.addToCart();
		Cart cartPage = PageFactory.initElements(driver, Cart.class);
		cartPage.proceed();
		cartPage.login("a@b2.com", "password");
		cartPage.proceedToShipping();
		cartPage.proceedToPayment();
		cartPage.pay();
		cartPage.confirm();
		if ("Your order on My Store is complete.".equals(cartPage.getConfirmation())) {
			test.log(LogStatus.PASS, "Yay");
		} else {
			test.log(LogStatus.FAIL,"Purchase failed");
			extent.endTest(test);
			fail("Purchase failed");
		}
	}

	@After
	public void tearDown() {
		this.driver.close();
	}
	
	@AfterClass
	public static void flushReport() {
		extent.flush();
	}

}
