package com.training.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(css = "a[href='/web/index.php/buzz/viewBuzz']")
	WebElement buzzItemLink;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div/div/div/form/div[1]/div[2]/div/textarea")
	WebElement messageInput;
	
	@FindBy(css = "button.oxd-button[type='submit']")
	WebElement postButton;
	
	@FindBy(css = "a[href='/web/index.php/admin/viewAdminModule']")
	WebElement adminLink;
	
	@FindBy(css = "button.oxd-button.oxd-button--secondary[type='button']")
	WebElement addUserButton;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div/div/div/form/div[2]/div[1]/div[2]/div/div")
	WebElement uploadImageButton;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div[2]/button[1]")
	WebElement sharePhotosButton; 
	
	@FindBy(xpath ="//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div/div/div/form/div[3]/button")
	WebElement shareButton;
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBuzz() {
		buzzItemLink.click();
	}
	
	public void inputMessage(String msg) {
		messageInput.sendKeys(msg);
	}
	
	public void clickPostButton() {
		postButton.click();
	}
	
	public void clickOnAdmin() {
		adminLink.click();
	}
	
	public void clickOnAddUserButton() {
		addUserButton.click();
	}
	
	public void uploadImageButton() {
		uploadImageButton.click();
	}
	
	public void clickSharePhotosButton() {
		sharePhotosButton.click();
	}
	
	public void clickShareButton() {
		shareButton.click();
	}

}
