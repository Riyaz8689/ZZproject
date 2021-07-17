package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee extends BaseTestUtilities {
	
	public AddEmployee() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement tbx_FirstName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement tbx_LastName;
	
	@FindBy(xpath = "//input[@id='employeeId']")
	WebElement tbx_EmployeeId;
	
	@FindBy(xpath = "//input[@id='chkLogin']")
	WebElement chkbox_LoginDetails;
	
	@FindBy(xpath = "//input[@id='user_name']")
	WebElement tbx_NewUserName;
	
	@FindBy(xpath = "//input[@id='user_password']")
	WebElement tbx_NewPassword;
	
	@FindBy(xpath = "//input[@id='re_password']")
	WebElement tbx_RePassword;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement btn_Save;
	
	
	
	
	public void EnterFirstName() {
		tbx_FirstName.sendKeys(ConfigReader.firstname);
	}
	
	public void EnterLastName() {
		tbx_LastName.sendKeys(ConfigReader.lastname);
		
	}
	
	public void EnterEmployeeId() {
		tbx_EmployeeId.clear();
		tbx_EmployeeId.sendKeys(ConfigReader.employeeid);
		
	}

	public void ClickOnLoginDetailsCheckBox() {
		chkbox_LoginDetails.click();
	}
	
	public void EnterToCreateUserName() {
		driver.manage().timeouts().implicitlyWait(ConfigReader.elementwait, TimeUnit.SECONDS);
		tbx_NewUserName.sendKeys(ConfigReader.Username);
		
	}
	
	public void EnterPassword() {
	
		tbx_NewPassword.sendKeys(ConfigReader.Newpassword);
	}
	
	public void ReTypePassword() {
	
		tbx_RePassword.sendKeys(ConfigReader.Newpassword);
	}
	
	public void ClickToSave() {
		
		btn_Save.click();
	}
	
	
	
}
