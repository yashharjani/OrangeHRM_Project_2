package com.training.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name = "username")
	WebElement usernameInput;
	
	@FindBy(name = "password")
	WebElement passwordInput;
	
	@FindBy(css = "button.orangehrm-login-button[type='submit']")
	WebElement loginButton;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputUsername(String username) {
		usernameInput.sendKeys(username);
	}
	
	public void inputPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}

}
