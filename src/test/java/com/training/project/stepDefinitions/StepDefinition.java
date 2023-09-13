package com.training.project.stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.training.project.pages.AdminPage;
import com.training.project.pages.DashboardPage;
import com.training.project.pages.EmployeePage;
import com.training.project.pages.LoginPage;

import io.cucumber.java.en.*;

import com.training.project.loadProperties.LoadProps;
public class StepDefinition {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	AdminPage adminPage;
	EmployeePage empPage;
	WebDriverWait wait;
	public static WebDriver driver = null;

	@Test
	@Given("User is on given url")
	public void userIsOnGivenUrl() throws InterruptedException {
		String Url = LoadProps.getProperty("Url");
		driver.get(Url);
	}

	@Test
	@When("User enters username and password")
	public void enterUsernameAndPassword() throws InterruptedException {
		String username = LoadProps.getProperty("Username");
		String password = LoadProps.getProperty("Password");
		loginPage = new LoginPage(driver);
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
	}

	@Test
	@When("User click on Login button")
	public void clickOnLoginButton() throws InterruptedException {
		loginPage.clickLoginButton();
	}

	@Test
	@When("^User wait for (\\d+) seconds$")
	public void waitForMillis(long seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}
	
	@Test
	@When("User click on Buzz item")
	public void clickOnBuzzItem() throws InterruptedException {
		dashboardPage = new DashboardPage(driver);
		dashboardPage.clickOnBuzz();
	}

	@Test
	@When("User click on Post button")
	public void clickOnPostButton() throws InterruptedException {
		dashboardPage.clickPostButton();
	}
	
	@Test
	@When("User click on Admin Page")
	public void clickOnAdminItem() throws InterruptedException {
		dashboardPage = new DashboardPage(driver);
		dashboardPage.clickOnAdmin();
	}
	
	@Test
	@When("User click on add user button")
	public void clickAddButton() throws InterruptedException {
		dashboardPage.clickOnAddUserButton();
	}
	
	@Test
	@When("User click on Share Photos button")
	public void clickOnSharePhotosBtn() throws InterruptedException {
		dashboardPage.clickSharePhotosButton();
	}
	
	@Test
	@When("User writes a message")
	public void writeAnyMessage() throws InterruptedException {
		String msg = LoadProps.getProperty("Message");
		dashboardPage.inputMessage(msg);
	}
	
	@Test
	@When("User click on upload image button")
	public void uploadImage() throws InterruptedException {
		//Image uploading using sendKeys
		WebElement chooseFile = driver.findElement(By.cssSelector("input.oxd-file-input[type='file']"));
		chooseFile.sendKeys("/home/atliq-14/eclipse-workspace/Automation_Training_Project/Pictures/images.png");
		waitForMillis(1);
	}
	
	@Test
	@When("User click on Share button")
	public void clickShareButton() throws InterruptedException {
		dashboardPage.clickShareButton();
		waitForMillis(2);
	}
	
	@When("User select {string} user")
	public void selectUser(String user) throws InterruptedException {
		final By dropdown = new By.ByXPath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
	    final By Dropdownoptions = new By.ByXPath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div"); 
		selectUserFromDropdown(user,dropdown,Dropdownoptions);
		waitForMillis(1);
	}
	
	@When("User enters employee name {string}")
	public void enterEmployeeName(String emyName) throws InterruptedException {
		adminPage = new AdminPage(driver);
		adminPage.inputEmployeeName(emyName);
		final By dropdown = new By.ByXPath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
	    final By Dropdownoptions = new By.ByXPath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div"); 
		selectUserFromDropdown(emyName,dropdown,Dropdownoptions);
		waitForMillis(1);
	}
	
	@When("User enters username {string}")
	public void enterUsername(String username) throws InterruptedException {
		adminPage.inputUsername(username);
		waitForMillis(1);
	}
	
	@When("User select status as {string}")
	public void selectStatus(String status) throws InterruptedException {
		final By dropdown = new By.ByXPath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div");
	    final By Dropdownoptions = new By.ByXPath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div"); 
	    selectUserFromDropdown(status,dropdown,Dropdownoptions);
	    waitForMillis(1);
	}
	
	@When("User enters password and confirm password as {string}")
	public void enterPassword(String password) throws InterruptedException {
		adminPage.inputPassword(password);
		adminPage.inputConfirmPassword(password);
	}
	
	@When("User click on PIM Page")
	public void clickOnPimPage() throws InterruptedException {
		empPage = new EmployeePage(driver);
		empPage.clickOnPIM();
	}
	
	@When("User click on add employee button")
	public void clickAddEmpButton() throws InterruptedException {
		empPage.clickOnAddButton();
	}
	
	@When("User enters first name, middle name, and last name")
	public void enterNewEmployeeDetails() throws InterruptedException {
		empPage = new EmployeePage(driver);
		String firstName = LoadProps.getProperty("Firstname");
		String middleName = LoadProps.getProperty("Middlename");
		String lastName = LoadProps.getProperty("Lastname");
		empPage.enterEmployeeDetails(firstName,middleName,lastName);
	}
	
	@When("User clicks on save button")
	public void clickSaveButton() throws InterruptedException {
		empPage.clickOnSaveButton();
	}
	
	private void selectUserFromDropdown(String dropdownName, By dropdown, By Dropdownoptions) throws InterruptedException {
	    
		driver.findElement(dropdown).click();
		waitForMillis(1);
		WebElement divElement = driver.findElement(Dropdownoptions);
		
		scriptForDropdown(divElement);
		
		// Find all div elements within the dropdown options
		List<WebElement> hiddenElements = divElement.findElements(By.tagName("div"));
		// Assuming the hidden elements are also div's
		for (WebElement element : hiddenElements) {
			if (element.getText().equals(dropdownName)) {
				element.click();
				break;
			}
		}
	}
	
	private void scriptForDropdown(WebElement divElement) throws InterruptedException  {
		// Execute JavaScript to make the dropdown options visible
		String script = "arguments[0].style.display='block';";
		((JavascriptExecutor) driver).executeScript(script, divElement);
	}

}
