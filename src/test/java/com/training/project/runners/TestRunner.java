package com.training.project.runners;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.training.project.loadProperties.LoadProps;
import com.training.project.stepDefinitions.StepDefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@CucumberOptions(
		features = "src/test/resources/FeatureFiles/OrangeHRM.feature",
		glue = "com.training.project.stepDefinitions",
		plugin = { "pretty", "html:target/HTMlReports/report.html"},
		tags = "@BuzzPost"
)

public class TestRunner extends AbstractTestNGCucumberTests{	
	
	@BeforeMethod
    public void setUp() {
		String browser = LoadProps.getProperty("browser");
		if (browser.equals("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        StepDefinition.driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			StepDefinition.driver = new FirefoxDriver();
		}
		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			StepDefinition.driver = new EdgeDriver();
		}
		else {
            System.out.println("Please pass the correct browser value: " + browser);
        }


        StepDefinition.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        StepDefinition.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        StepDefinition.driver.manage().window().maximize();
    }
	
	@AfterMethod
	public void tearDown() {
		StepDefinition.driver.close();
		StepDefinition.driver.quit();
	}

}
