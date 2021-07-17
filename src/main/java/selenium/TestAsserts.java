package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class TestAsserts {

	public static void ShouldBeEqual(String expected, String actual) {
		Assert.assertEquals(expected, actual);
		System.out.println("Condition Satisfied, Expected value[" + expected
				+ "] matching with actual value[" + actual + "]");
	}

	public static void ShouldNotBeEqual(String expected, String actual) {
		Assert.assertNotSame("Condition Not Satisfied, Expected value[" + expected
				+ "] matching with actual value[" + actual + "]", expected, actual);

		System.out.println("Condition Satisfied, Expected value[" + expected
				+ "] is not matching with actual value[" + actual + "]");

	}

	public static void ShouldBeDisplayed(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
		System.out.println("Condition Satisfied, Element is displayed");
	}

	public static void ShouldNotBeDisplayed(WebElement element) {
		Assert.assertFalse(element.isDisplayed());
		System.out.println("Condition Satisfied, Element is not displayed");
	}

	public static void ShouldContainsInUrl(String expected, WebDriver driver) {
		Assert.assertTrue(driver.getCurrentUrl().contains(expected));
		System.out.println("Condition Satisfied, Url contains value[" + expected + "]");
	}

	
	public static void ShouldContainsInUrl(String expected, String url) {
		Assert.assertTrue(url.contains(expected));
		System.out.println("Condition Satisfied, Url contains value[" + expected + "]");
	}

}
