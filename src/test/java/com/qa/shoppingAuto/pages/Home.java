package com.qa.shoppingAuto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {

	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]")
	private WebElement searchBar;
	
	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")
	private WebElement searchButton;
	
	public void search(String item) {
		this.searchBar.sendKeys(item);
		this.searchButton.click();
	}
}
