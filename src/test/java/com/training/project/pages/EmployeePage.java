package com.training.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {
	
	@FindBy(css = "a[href='/web/index.php/pim/viewPimModule']")
	WebElement pimPage;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
	WebElement addButton;
	
	@FindBy(xpath ="//input[@name='firstName']")
	WebElement firstNameInput;
	
	@FindBy(xpath ="//input[@name='middleName']")
	WebElement middleNameInput;
	
	@FindBy(xpath ="//input[@name='lastName']")
	WebElement lastNameInput;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	WebElement saveButton;
	
	WebDriver driver;
	
	public EmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPIM() {
		pimPage.click();
	}
	
	public void clickOnAddButton() {
		addButton.click();
	}
	
	public void enterEmployeeDetails(String firstName, String middleName, String lastName) {
		firstNameInput.sendKeys(firstName);
		middleNameInput.sendKeys(middleName);
		lastNameInput.sendKeys(lastName);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}

}
