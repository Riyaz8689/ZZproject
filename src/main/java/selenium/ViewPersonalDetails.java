package selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPersonalDetails extends BasePageutilities {
	
	ViewPersonalDetails(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='welcome']")
	WebElement menu_Welcome;
	
	@FindBy(xpath = "//div[@id='welcome-menu']/ul/li[3]/a")
	WebElement submenu_Logout;
	
	public void ClickOnWelcomeMenu() {
		
		menu_Welcome.click();
	}
	
	public void ClickOnLogOut() {
	
		submenu_Logout.click();
	}
	
	
	
}
