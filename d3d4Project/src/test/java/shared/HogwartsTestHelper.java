package shared;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HogwartsTestHelper 
{
	public static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_PATH = "D:/chromedriver/chromedriver.exe";
	
	public static final String GRYFFINDOR_JSON_FILE_NAME = "gryffindor.json";
	
	private static final String HOGWARTS_DEVELOPER_ATTRIBUTE = "hogwartsDeveloper";
	
	final static Logger logger = Logger.getLogger(HogwartsTestHelper.class);
	
	public String getTagName(final HogwartsTags hogwartsTags)
	{
		return hogwartsTags.getTagName();
	}
	
	public void checkForElementPresence(final WebDriver driver, final By locator, final HogwartsTags hogwartsTags)
	{
		final WebElement teamsButton = driver.findElement(locator);
		final String expectedTagName = getTagName(hogwartsTags);
		
		assertThat(teamsButton.getTagName()).isEqualTo(expectedTagName);
	}
	
	public void checkForUrlPresence(final WebDriver driver, final String url)
	{
		driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void checkForAlertPresence(final WebDriver driver, final By alertId)
	{
		driver.findElement(alertId);
	}
	
	public void checkForGryffindorJSON(final WebDriver driver)
	{
		final String alertText = driver.switchTo().alert().getText();
		
		try
		{
			final String gryffindorJsonText = deserializeJson(GRYFFINDOR_JSON_FILE_NAME);
			assertThat(alertText).isEqualTo(gryffindorJsonText);
		}
		catch (final URISyntaxException uriSyntaxException)
		{
			logger.error("Error in URI syntax", uriSyntaxException);
		}
		catch (final IOException ioException)
		{
			logger.error("Could not complete file reading", ioException);
		}
	}
	
	public void checkForSaveDeveloperStatus(final WebDriver driver)
	{
		final String alertText = driver.switchTo().alert().getText();
		
		assertThat(alertText).isEqualTo(HOGWARTS_DEVELOPER_ATTRIBUTE);
	}
	
	private String deserializeJson(final String fileName) throws URISyntaxException, IOException
	{
		final URL resource = getClass().getResource(fileName);
        final Path path = Paths.get(resource.toURI());
        final byte[] contentInBytes = Files.readAllBytes(path);
        final String content = new String(contentInBytes);
        
        return content;
	}
}
