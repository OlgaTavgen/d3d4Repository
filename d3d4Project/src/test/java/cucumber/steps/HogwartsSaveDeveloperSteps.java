package cucumber.steps;

import static cucumber.locators.HogwartsLocators.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import shared.HogwartsTags;
import shared.HogwartsTestHelper;
import shared.HogwartsUrls;

public class HogwartsSaveDeveloperSteps extends HogwartsTestHelper
{
	WebDriver driver;
	
	@Given("^I am on Save Developer page$")
	public void goToHogwartsSaveDeveloperPage() 
	{
		System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
		driver.navigate().to(HogwartsUrls.HOGWARTS_SAVE_DEVELOPER);
	}
	
	@When("^I click on Save Developer button$")
	public void clickSaveDeveloperButton() 
	{
		final WebElement saveDeveloperButton = driver.findElement(SAVE_DEVELOPER_BUTTON);
		saveDeveloperButton.click();
	}
	
	@Then("^Save Developer button is available$")
	public void checkForSaveDeveloperButtonPresence() 
	{
		checkForElementPresence(driver, TEAMS_BUTTON, HogwartsTags.SAVE_DEVELOPER_BUTTON);
	}
	
	@Then("^Alert window says that Hogwarts Developer is saved$")
	public void checkAlertWindowForSaveDeveloper() 
	{
		checkForSaveDeveloperStatus(driver);
	}
}
