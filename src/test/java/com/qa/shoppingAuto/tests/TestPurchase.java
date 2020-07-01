package com.qa.shoppingAuto.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
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

public class TestPurchase {

	private WebDriver driver;

	@Before
	public void setup() {
		System.setProperty(Constants.PROPERTY, Constants.PATH);
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get("http://automationpractice.com/index.php");

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

		assertEquals("Your order on My Store is complete.", cartPage.getConfirmation());
	}

	@After
	public void tearDown() {
		this.driver.close();
	}

}
