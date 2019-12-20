package com.qa.shoppingAuto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search {

	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a")
	private WebElement result;
	
	public void selectItem() {
		result.click();
	}
}
