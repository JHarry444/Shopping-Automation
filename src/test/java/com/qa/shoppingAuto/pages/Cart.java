package com.qa.shoppingAuto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart {
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]")
	private WebElement proceedButton;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input")
	private WebElement email;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input")
	private WebElement password;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button")
	private WebElement login;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/p/button")
	private WebElement proceedToShippingButton;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/div/span/input")
	private WebElement termsButton;

	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/p/button")
	private WebElement proceedToPaymentButton;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a")
	private WebElement payButton;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/p/button")
	private WebElement confirmButton;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/p/strong")
	private WebElement orderConfirmation;
	
	public void proceed() {
		this.proceedButton.click();
	}
	
	public void login(String email, String pass) {
		this.email.sendKeys(email);
		this.password.sendKeys(pass);
		this.login.click();
	}
	
	public void proceedToShipping() {
		this.proceedToShippingButton.click();
	}
	
	public void proceedToPayment() {
		this.termsButton.click();
		this.proceedToPaymentButton.click();
	}
	
	public void pay() {
		payButton.click();
	}
	
	public void confirm() {
		confirmButton.click();
	}
	
	public String getConfirmation() {
		return this.orderConfirmation.getText();
	}

}
