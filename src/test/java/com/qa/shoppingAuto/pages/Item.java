package com.qa.shoppingAuto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Item {
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button")
	private WebElement cartButton;
	
	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")
	private WebElement checkoutButton;

	public void addToCart() {
		this.cartButton.click();
		this.checkoutButton.click();
	}
}
