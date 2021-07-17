package selenium;

import java.io.File;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePageutilities {

	static WebDriver driver;
	static ChromeOptions chromeOptions;
	

	public static WebDriver LaunchBrowser(String browserType) {

	//	DesiredCapabilities capabilities;
		if (browserType.equalsIgnoreCase("Chrome")) {
			chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(false);
			chromeOptions.addArguments("--start-maximized");
			// chromeOptions.addArguments("--headless");
			chromeOptions.setAcceptInsecureCerts(true);
			chromeOptions.setExperimentalOption("excludeSwitches",
					Collections.singletonList("enable-automation"));

			chromeOptions.setExperimentalOption("useAutomationExtension", false);

			// capabilities = DesiredCapabilities.chrome();
			// capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//driver-exes//chromedriver.exe");
			driver = new ChromeDriver(chromeOptions);

		} else if (browserType.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//driver-exes//geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "//driver-exes//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(ConfigReader.elementWait,
		// TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(ConfigReader.pageloadwait, TimeUnit.SECONDS);

		return driver;
	}

	public static void captureScreenshot(WebDriver driver, String screenshotName) throws Exception {
		TakesScreenshot screenshot = ((TakesScreenshot) driver); // Cast the driver to be of type
		// TakeScreenshot
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				System.getProperty("user.dir") + "//screenshots//" + screenshotName + ".png");
		FileUtils.copyFile(srcFile, destFile);

	}

	public static WebElement waitForElementTobePresent(WebDriver driver, By by) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, ConfigReader.elementwait);
		WebElement element;
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			
		} catch (Exception e) {
			System.out.println("Element is not present in the DOM within time ["
					+ ConfigReader.elementwait + "]");
			element = null;

			throw e;

		}
		return element;
	}

	public static WebElement findElementBy(String by, String value) throws Exception {
		WebElement element;

		By bys;
		if (by.equalsIgnoreCase("id")) {
			bys = By.id(value);
		} else if (by.equalsIgnoreCase("name")) {
			bys = By.name(value);
		} else if (by.equalsIgnoreCase("xpath")) {
			bys = By.xpath(value);
		} else if (by.equalsIgnoreCase("class")) {
			bys = By.className(value);
		} else {
			return null;
		}

		element = waitForElementToBeVisible(driver, bys);
		return element;
	}

	public static WebElement findElementByXpath(String value) throws Exception {
		String xpath = ConfigReader.GetLocator(value);
		return findElementBy("xpath", xpath);

	}

	public static WebElement findElementByID(String value) throws Exception {
		String id = ConfigReader.GetLocator(value);
		return findElementBy("id", id);
	}

	public static WebElement findElementByClass(String value) throws Exception {
		String clazz = ConfigReader.GetLocator(value);
		return findElementBy("class", clazz);
	}

	public static WebElement findElementByName(String value) throws Exception {
		String name = ConfigReader.GetLocator(value);
		return findElementBy("name", name);
	}

	public static WebElement waitForElementToBeVisible(WebDriver driver, By by) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, ConfigReader.elementwait);
		WebElement element;
		try {
			element = waitForElementTobePresent(driver, by);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(
					"Element is not visible within time [" + ConfigReader.elementwait + "]");
			element = null;
			throw e;
		}
		return element;
	}

	public static void waitForElementToBeInvisible(WebDriver driver, long timeOutInSeconds,
			String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
	}

	public static void waitForElementToBeClickable(WebDriver driver, long timeOutInSeconds,
			String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}
}