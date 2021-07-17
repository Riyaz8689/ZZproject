package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePageutilities {
	
	LoginPage(){
		
		PageFactory.initElements(driver, this);
				
	}
		
	@FindBy(xpath = "//input[@id = 'txtUsername']")
	WebElement tbx_UserName;
	
	@FindBy(xpath = "//input[@id = 'txtPassword']")
	WebElement tbx_PassWord;
	
	@FindBy(xpath = "//input[@id = 'btnLogin']")
	WebElement btn_Login;
	
	
	
	public  void EnterUserName() {
		tbx_UserName.clear();
		tbx_UserName.sendKeys(ConfigReader.username);
	}
	
	public void EnterPassword() {
		tbx_PassWord.sendKeys(ConfigReader.password);
	}
	
	public void ClickLogin() {
		btn_Login.click();
	}
	
	public  void EnterWithCreatedUserName() {
		tbx_UserName.clear();
		tbx_UserName.sendKeys(ConfigReader.Username);
	}
	
	public void EnterWithPassword() {
		tbx_PassWord.sendKeys(ConfigReader.Newpassword);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id = 'txtPassword']")));
		
		
	}

}
