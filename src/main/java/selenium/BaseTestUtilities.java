package selenium;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestUtilities extends TestAsserts{
	static WebDriver driver;
	static ChromeOptions chromeOptions;
	static InternetExplorerOptions internetOptions;

     
	
	@BeforeMethod
	public void setUpBrowser() throws FileNotFoundException, IOException {
		ConfigReader.readConfigurations();
		driver = BasePageutilities.LaunchBrowser(ConfigReader.browser);
		driver.get(ConfigReader.url);
	}

	@AfterMethod
	public void tearDownBrowser(ITestContext methodName) throws Exception {
		BasePageutilities.captureScreenshot(driver,methodName.getName());
		driver.quit();
	}
}