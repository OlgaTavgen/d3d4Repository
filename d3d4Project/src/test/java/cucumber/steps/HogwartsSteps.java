package cucumber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.locators.HogwartsLocators;
import shared.HogwartsTags;
import shared.HogwartsTestHelper;
import shared.HogwartsUrls;

import static cucumber.locators.HogwartsLocators.*;

public class HogwartsSteps extends HogwartsTestHelper
{	
	WebDriver driver;
	
	@Given("^I am on home page$")
	public void goToHogwartsHomePage() 
	{
		System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
		driver.navigate().to(HogwartsUrls.HOGWARTS_HOME);
	}
	
	@When("^I click on Gryffindor team$")
	public void clickGryffindorTeam() 
	{
		final WebElement gryffindorTeam = driver.findElement(GRYFFINDOR_TEAM);
		gryffindorTeam.click();
	}
	
	@Then("^Teams button is available$")
	public void checkForTeamsButtonPresence() 
	{
		checkForElementPresence(driver, TEAMS_BUTTON, HogwartsTags.TEAMS_BUTTON);
	}
	
	@Then("^Gryffindor team is shown to user$")
	public void checkForGryffindorTeamPresence() 
	{
		checkForElementPresence(driver, GRYFFINDOR_TEAM, HogwartsTags.GRYFFINDOR_TEAM);
	}
	
	@Then("^Hufflepuf team is shown to user$")
	public void checkForHufflepufTeamPresence() 
	{
		checkForElementPresence(driver, HUFFLEPUF_TEAM, HogwartsTags.HUFFLEPUF_TEAM);
	}
	
	@Then("^Ravenclaw team is shown to user$")
	public void checkForRavenclawTeamPresence() 
	{
		checkForElementPresence(driver, RAVENCLAW_TEAM, HogwartsTags.RAVENCLAW_TEAM);
	}
	
	@Then("^Slytherin team is shown to user$")
	public void checkForSlytherinTeamPresence() 
	{
		checkForElementPresence(driver, SLYTHERIN_TEAM, HogwartsTags.HUFFLEPUF_TEAM);
	}
	
	@Then("^Dashboard url is available for user$")
	public void checkForDashboardUrl() 
	{
		checkForUrlPresence(driver, HogwartsUrls.HOGWARTS_DASHBOARD);
	}
	
	@Then("^Alert window is shown to user$")
	public void checkForAlertWindowPresence() 
	{
		checkForAlertPresence(driver, HogwartsLocators.DASHBOARD_ALERT_WINDOW);
	}
	
	@Then("^Alert window contains Gryffindor Dashboard JSON response info$")
	public void checkAlertWindowForGryffindorJson() 
	{
		checkForGryffindorJSON(driver);
	}
}
