package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends BasePageutilities{
	
	Dashboard(){
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath = "//a[contains(@id,'viewPim')]/b")
	WebElement Navigationtab_Pim;
	
	@FindBy(xpath = "//a[contains(@id,'viewPim')]/following-sibling::ul/li[3]")
	WebElement SubNavigationtab_AddEmployee;
	
	@FindBy(xpath = "//a[@id='welcome']")
	WebElement menu_Welcome;
	
	@FindBy(xpath = "//div[@id='welcome-menu']/ul/li[3]/a")
	WebElement submenu_Logout;
	
	@FindBy(xpath = "//a[@class='panelTrigger']")
	WebElement txt_AccountName;
	
	Actions PIM = new Actions(driver);
	
	public void ClickOnNavigationTabPIM() {
		
		PIM.moveToElement(Navigationtab_Pim).build().perform();
	}
	
	public void ClickOnAddEmployee() {
		driver.manage().timeouts().implicitlyWait(ConfigReader.elementwait, TimeUnit.SECONDS);
		PIM.moveToElement(SubNavigationtab_AddEmployee).click().build().perform();
	}
	
	public  String GetAccountName() {
		driver.manage().timeouts().implicitlyWait(ConfigReader.elementwait, TimeUnit.SECONDS);
		 String AccountName = txt_AccountName.getText();
		 return AccountName;
	}
	
public void ClickOnWelcomeMenu() {
		
		menu_Welcome.click();
	}
	
	public void ClickOnLogOut() {
	
		submenu_Logout.click();
	}
	
	

}
